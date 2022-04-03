package it.prova.dottore.service;

import java.util.List;
import it.prova.dottore.model.Dottore;

public interface DottoreService {

	public List<Dottore> listAllElements();

	public Dottore caricaSingoloElemento(Long id);

	public Dottore inserisciNuovo(Dottore dottore);

	public Dottore aggiorna(Dottore dottore);

	public void rimuovi(Dottore dottore);

	//public Dottore caricaSingoloElementoEager(Long id);

	//public void rimuovi(Dottore dottore);

	//public Page<Dottore> findByExample(Dottore example, Integer pageNo, Integer pageSize, String sortBy);

}
