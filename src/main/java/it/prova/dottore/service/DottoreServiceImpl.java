package it.prova.dottore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dottore.model.Dottore;
import it.prova.dottore.repository.DottoreRepository;

@Service
public class DottoreServiceImpl implements DottoreService {
	@Autowired
	private DottoreRepository repository;
	
	@Override
	@Transactional
	public List<Dottore> listAllElements() {
		return (List<Dottore>)repository.findAll();
	}
	
	@Override
	@Transactional
	public Dottore caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Dottore caricaSingoloElementoEager(Long id) {
		return repository.findByIdEager(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Dottore inserisciNuovo(Dottore dottore) {
		return repository.save(dottore);
	}
	
	@Override
	@Transactional
	public Dottore aggiorna(Dottore dottore) {
		return repository.save(dottore);
	}
	
	/*
	@Override
	@Transactional
	public void rimuovi(Dottore dottore) {
		repository.delete(dottore);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Dottore> findByExample(Dottore example, Integer pageNo, Integer pageSize, String sortBy) {
		Specification<Dottore> specificationCriteria = (root, query, cb) -> {

			List<Predicate> predicates = new ArrayList<Predicate>();
			
		

			if (StringUtils.isNotEmpty(example.getNome()))
				predicates.add(cb.like(cb.upper(root.get("nome")), "%" + example.getNome().toUpperCase() + "%"));

			if (StringUtils.isNotEmpty(example.getCognome()))
				predicates.add(cb.like(cb.upper(root.get("cognome")), "%" + example.getCognome().toUpperCase() + "%"));

			if (StringUtils.isNotEmpty(example.getCodiceDipendente()))
				predicates.add(cb.like(cb.upper(root.get("codicePaziente")), "%" + example.getCodiceDipendente().toUpperCase() + "%"));

			
			// inserire anche paziente ???
		
			
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));

		};
		
		Pageable paging = null;
		// se non passo parametri di paginazione non ne tengo conto
		if (pageSize == null || pageSize < 10)
			paging = Pageable.unpaged();
		else
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		return repository.findAll(specificationCriteria, paging);
	}
	*/
}
