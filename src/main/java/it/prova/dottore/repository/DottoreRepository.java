package it.prova.dottore.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.dottore.model.Dottore;

public interface DottoreRepository extends CrudRepository<Dottore, Long>, PagingAndSortingRepository<Dottore, Long>, JpaSpecificationExecutor<Dottore> {
	
}
