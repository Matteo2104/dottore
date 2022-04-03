package it.prova.dottore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.dottore.model.Dottore;

public interface DottoreRepository extends CrudRepository<Dottore, Long>, PagingAndSortingRepository<Dottore, Long>, JpaSpecificationExecutor<Dottore> {
	@Query("from Dottore d where d.codiceDipendente = ?1")
	public Optional<Dottore> findByCodDip(String codiceDipendente);
}
