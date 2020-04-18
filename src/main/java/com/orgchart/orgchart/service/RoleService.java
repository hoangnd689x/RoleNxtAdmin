package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.Role;

/**
 * @author YOG1HC
 *
 */
@Transactional
public interface RoleService {
	
	 List<Role> GetAllRoles();
	 
	 Role GetRoleById(long id);
	 
	 boolean DeleteRole(long id);
	 
	 boolean UpdateRole(Role roleUpdate);
	 
	 public boolean AddRole(Role roleUpdate);
	 
}
