package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.DTO.DomainDTO;
import com.orgchart.orgchart.Mapper.DomainMapper;
import com.orgchart.orgchart.Repository.DomainRepository;
import com.orgchart.orgchart.model.Domain;

/**
 * @author NNA7HC
 *
 */
@Service
@Transactional
public class DomainService {
	
	@Autowired
	private DomainRepository domainRepository;
	
	public List<Domain> getAll(){
		return domainRepository.getAll();
	}
	
	public Domain findById(int id) {
		return domainRepository.getOne(Integer.valueOf(id));
	}
	
	public int add(DomainDTO obj) {
		Domain rs = new Domain();
		
		rs.setName(obj.getName());
		rs.setActivate(true);
		if(domainRepository.save(rs) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int update(DomainDTO obj) {
		
		if(domainRepository.save(DomainMapper.toDomain(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int delete(DomainDTO obj) {
		
		obj.setActivate(false);
		if(domainRepository.save(DomainMapper.toDomain(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
//	 List<Domain> getAllDomains();
//	 
//	 Domain getDmById(long id);
//	 
//	 boolean deleteDm(long id);
//	 
//	 boolean UpdateDm(Domain orgUpdate);
//	 
//	 public boolean AddDm(Domain orgUpdate);
//	 
//	 List<Organization> GetOrgsByDomainId(long id);
}
