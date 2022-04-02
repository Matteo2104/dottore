package it.prova.dottore.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.dottore.dto.DottoreDTO;
import it.prova.dottore.model.Dottore;
import it.prova.dottore.service.DottoreService;

@RestController
@RequestMapping("api/dottore")
public class DottoreController {
	@Autowired
	private DottoreService dottoreService;
	
	/*
	@GetMapping
	public List<DottoreDTO> getAll() {
		return DottoreDTO.buildDottoreDTOListFromModelList(dottoreService.listAllElements(), false); 
	}
	
	@GetMapping("/{id}")
	public DottoreDTO findById(@PathVariable(value = "id", required = true) long id) {
		Dottore dottore = dottoreService.caricaSingoloElemento(id); // con paziente?

		if (dottore == null)
			throw new DottoreNotFoundException("Dottore not found con id: " + id);

		return DottoreDTO.buildDottoreDTOFromModel(dottore, false); // true?
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreDTO createNew(@Valid @RequestBody DottoreDTO dottoreInput) {
		//se mi viene inviato un id jpa lo interpreta come update ed a me (producer) non sta bene
		if(dottoreInput.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");
		
		Dottore dottoreInserito = dottoreService.inserisciNuovo(dottoreInput.buildDottoreModel());
		
		//System.out.println(AirbusDTO.buildAirbusDTOFromModel(airbusInserito, false));
		
		return DottoreDTO.buildDottoreDTOFromModel(dottoreInserito, false);
	}
	
	
	@PutMapping("/{id}")
	public DottoreDTO update(@Valid @RequestBody DottoreDTO dottoreInput, @PathVariable(required = true) Long id) {
		Dottore dottore = dottoreService.caricaSingoloElemento(id);

		if (dottore == null)
			throw new DottoreNotFoundException("Not not found con id: " + id);

		dottoreInput.setId(id);
		Dottore dottoreAggiornato = dottoreService.aggiorna(dottoreInput.buildDottoreModel());
		return DottoreDTO.buildDottoreDTOFromModel(dottoreAggiornato, false);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable(required = true) Long id) {
		Dottore dottore = dottoreService.caricaSingoloElementoEager(id);

		if (dottore == null)
			throw new DottoreNotFoundException("Dottore not found con id: " + id);
		
		
		if (dottore.getPazienteAttualmenteInVisita() != null && dottore.getPazienteAttualmenteInVisita().getId() != null)
			throw new DottoreNotEmptyException("Dottore with id: " + id + " has a patient associated, you cannot delete it");
		
	
		dottoreService.rimuovi(dottore);
	}
	
	
	@PostMapping("/search")
	public List<DottoreDTO> search(@RequestBody DottoreDTO example) {
		return DottoreDTO.buildDottoreDTOListFromModelList(
				dottoreService.findByExample(example.buildDottoreModel(), null, null, null).toList(), false);
	}
	*/
}