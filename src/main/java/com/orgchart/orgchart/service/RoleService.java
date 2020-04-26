package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.DTO.RoleDTO;
import com.orgchart.orgchart.Mapper.RoleMapper;
import com.orgchart.orgchart.Mapper.CareerPathMapper;
import com.orgchart.orgchart.Mapper.CompetencyMapper;
import com.orgchart.orgchart.Mapper.DomainMapper;
import com.orgchart.orgchart.Mapper.PositionMapper;
import com.orgchart.orgchart.Repository.RoleRepository;
import com.orgchart.orgchart.model.Role;
import com.orgchart.orgchart.model.Role;

/**
 * @author NNA7HC
 *
 */
@Service
@Transactional
public class RoleService {
	
	@Autowired
	RoleRepository RoleRepository;
	
	public List<Role> getAll(){
		return RoleRepository.getAll();
	}
	
	public RoleDTO findById(int id) {
		return RoleMapper.toRoleDTO(RoleRepository.getOne(Integer.valueOf(id)));
	}
	
	public int add(RoleDTO obj) {
		Role rs = new Role();
		
		rs.setCareerPath(CareerPathMapper.toCareerPath(obj.getCareerPath()));
		rs.setPositionObj(PositionMapper.toPosition(obj.getPositionObj()));
		rs.setCompetencies(CompetencyMapper.toCompetencyList(obj.getCompetencies()));
		rs.setDomainRole(obj.getDomainRole());
		rs.setCategory(obj.getCategory());
		rs.setKRA(obj.getKRA());
		rs.setScope(obj.getScope());
		rs.setResponsibilities(obj.getResponsibilities());
		rs.setIndustrialRole(obj.getIndustrialRole());
		rs.setEntryCriteria(obj.getEntryCriteria());
		rs.setActivate(true);
		
		if(RoleRepository.save(rs) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int update(RoleDTO obj) {
		
		if(RoleRepository.save(RoleMapper.toRole(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int delete(RoleDTO obj) {
		
		obj.setActivate(false);
		if(RoleRepository.save(RoleMapper.toRole(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
//	 List<Role> GetAllRoles();
//	 
//	 Role GetRoleById(long id);
//	 
//	 boolean DeleteRole(long id);
//	 
//	 boolean UpdateRole(Role roleUpdate);
//	 
//	 public boolean AddRole(Role roleUpdate);
	 
}
