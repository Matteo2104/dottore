package it.prova.dottore.controller.api;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import it.prova.dottore.dto.DottoreDTO;
import it.prova.dottore.model.Dottore;
import it.prova.dottore.service.DottoreService;

@RestController
@RequestMapping("/api/dottore")
public class DottoreController {

	@Autowired
	private DottoreService dottoreService;
	
	@GetMapping
	public List<DottoreDTO> getAll() {
		return DottoreDTO.buildDottoreDTOListFromModelList(dottoreService.listAllElements()); 
	}
	
	@GetMapping("/{id}")
	public DottoreDTO findById(@PathVariable(value = "id", required = true) long id) {
		Dottore dottore = dottoreService.caricaSingoloElemento(id); 

		if (dottore == null)
			throw new RuntimeException("Dottore not found con id: " + id);

		return DottoreDTO.buildDottoreDTOFromModel(dottore);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreDTO createNew(@Valid @RequestBody DottoreDTO dottoreInput) {
		if (dottoreInput.getId() != null)
			throw new RuntimeException("Non è ammesso fornire un id per la creazione");

		Dottore newEntry = dottoreInput.buildDottoreModel();
		
		
		/*
		// andrebbe in un service!!!
		newEntry.setCodicePrevidenziale("REGPREV-" + newEntry.getCodiceFiscale());
		*/

		DottoreDTO result = DottoreDTO.buildDottoreDTOFromModel(dottoreService.inserisciNuovo(newEntry));
		return result;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable(required = true) Long id) {
		Dottore dottore = dottoreService.caricaSingoloElemento(id);

		/*
		if (dottore == null)
			throw new DottoreNotFoundException("Dottore not found con id: " + id);
		*/
		
		dottoreService.rimuovi(dottore);
	}
	
	@GetMapping("/assegna/{codiceDipendente}")
	public DottoreDTO findByCodDip(@PathVariable(required=true) String codiceDipendente) {
		Dottore dottore = dottoreService.trovaPerCodiceDipendente(codiceDipendente);
		
		if (dottore == null)
			throw new RuntimeException("non è stato trovato alcun dottore");
		
		System.out.println(DottoreDTO.buildDottoreDTOFromModel(dottore));
		
		return DottoreDTO.buildDottoreDTOFromModel(dottore);
	}
	
	/*
	
	
	
	
	
	
	
	
	@PutMapping("/{id}")
	public DottoreDTO update(@Valid @RequestBody DottoreDTO dottoreInput, @PathVariable(required = true) Long id) {
		Dottore dottore = dottoreService.caricaSingoloElemento(id);

		if (dottore == null)
			throw new DottoreNotFoundException("Not not found con id: " + id);

		dottoreInput.setId(id);
		Dottore dottoreAggiornato = dottoreService.aggiorna(dottoreInput.buildDottoreModel());
		return DottoreDTO.buildDottoreDTOFromModel(dottoreAggiornato, false);
	}
	
	
	
	
	
	@PostMapping("/search")
	public List<DottoreDTO> search(@RequestBody DottoreDTO example) {
		return DottoreDTO.buildDottoreDTOListFromModelList(
				dottoreService.findByExample(example.buildDottoreModel(), null, null, null).toList(), false);
	}
	*/
}
