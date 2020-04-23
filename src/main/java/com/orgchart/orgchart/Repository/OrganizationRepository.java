package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Organization;

/**
 * @author NNA7HC
 *
 */

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer>{
	
	@Query("SELECT o FROM Organization o WHERE o.activate = true")
	List<Organization> getAllOrg();
}
