package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Domain;

/**
 * @author NNA7HC
 *
 */

@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer>{
	
	@Query("SELECT d FROM Domain d WHERE d.activate = true")
	List<Domain> getAll();
}
