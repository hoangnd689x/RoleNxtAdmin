package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.CareerPath;


/**
 * @author NNA7HC
 *
 */
@Repository
public interface CareerPathRepository extends JpaRepository<CareerPath, Integer>{
	@Query("SELECT c FROM CareerPath c WHERE c.activate = true")
	List<CareerPath> getAll();
}
