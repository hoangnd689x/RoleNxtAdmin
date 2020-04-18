package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.Domain;
import com.orgchart.orgchart.model.Organization;

/**
 * @author YOG1HC
 *
 */
@Transactional
public interface DomainService {
	
	 List<Domain> getAllDomains();
	 
	 Domain getDmById(long id);
	 
	 boolean deleteDm(long id);
	 
	 boolean UpdateDm(Domain orgUpdate);
	 
	 public boolean AddDm(Domain orgUpdate);
	 
	 List<Organization> GetOrgsByDomainId(long id);
}
