package com.orgchart.orgchart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orgchart.orgchart.model.Role;

/**
 * @author NNA7HC
 *
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Query("SELECT r FROM Role r WHERE r.activate = true")
	List<Role> getAll();
}
