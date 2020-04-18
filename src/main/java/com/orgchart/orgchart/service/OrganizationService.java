package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.Organization;

/**
 * @author YOG1HC
 *
 */
@Transactional
public interface OrganizationService {
	
	 List<Organization> getAllOrgs();
	 
	 List<Organization> getAllPureOrgs();
	 
	 Organization getOrgById(long id);
	 
	 boolean deleteOrg(long id);
	 
	 boolean UpdateOrg(Organization orgUpdate);
	 
	 public boolean AddOrg(Organization orgUpdate);
}
