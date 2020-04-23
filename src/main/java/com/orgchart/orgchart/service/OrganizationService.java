package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.DTO.OrganizationDTO;
import com.orgchart.orgchart.Mapper.OrganizationMapper;
import com.orgchart.orgchart.Repository.DomainRepository;
import com.orgchart.orgchart.Repository.OrganizationRepository;
import com.orgchart.orgchart.model.Organization;

/**
 * @author NNA7HC
 *
 */
@Service
@Transactional
public class OrganizationService {
	
	@Autowired
	DomainService domainService;
	
	@Autowired
	OrganizationRepository orgRepository;
	
	public List<Organization> getAll(){
		return orgRepository.getAllOrg();
	}
	
	public OrganizationDTO findById(int id) {
		return OrganizationMapper.toOrganizationDTO(orgRepository.getOne(Integer.valueOf(id)));
	}
	
	public int add(OrganizationDTO obj) {
		Organization rs = new Organization();
		
		rs.setName(obj.getName());
		rs.setDomainObj(domainService.findById(obj.getDomainObj().getId()));
		rs.setBusinessSector(obj.getBusinessSector());
		rs.setActivate(true);
		
		if(orgRepository.save(rs) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int update(OrganizationDTO obj) {
		
		if(orgRepository.save(OrganizationMapper.toOrganization(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int delete(OrganizationDTO obj) {
		
		obj.setActivate(false);
		if(orgRepository.save(OrganizationMapper.toOrganization(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
//	 List<Organization> getAllOrgs();
//	 
//	 List<Organization> getAllPureOrgs();
//	 
//	 Organization getOrgById(long id);
//	 
//	 boolean deleteOrg(long id);
//	 
//	 boolean UpdateOrg(Organization orgUpdate);
//	 
//	 public boolean AddOrg(Organization orgUpdate);
}
