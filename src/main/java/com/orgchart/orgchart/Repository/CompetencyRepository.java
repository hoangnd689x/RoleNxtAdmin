package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Competency;

/**
 * @author NNA7HC
 *
 */

@Repository
public interface CompetencyRepository extends JpaRepository<Competency, Integer>{
	
	@Query("SELECT c FROM Competency c WHERE c.activate = true")
	List<Competency> getAll();
}
