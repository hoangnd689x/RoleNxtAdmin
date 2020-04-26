package com.orgchart.orgchart.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.orgchart.orgchart.DTO.RoleDTO;
import com.orgchart.orgchart.model.Role;

/**
 * @author NNA7HC
 *
 */

public class RoleMapper {
	public static Role toRole(RoleDTO item) {
		Role rs = new Role();
		
		rs.setId(item.getId());
		rs.setCareerPath(CareerPathMapper.toCareerPath(item.getCareerPath()));
		rs.setPositionObj(PositionMapper.toPosition(item.getPositionObj()));
		rs.setCompetencies(CompetencyMapper.toCompetencyList(item.getCompetencies()));
		rs.setDomainRole(item.getDomainRole());
		rs.setCategory(item.getCategory());
		rs.setKRA(item.getKRA());
		rs.setScope(item.getScope());
		rs.setResponsibilities(item.getResponsibilities());
		rs.setIndustrialRole(item.getIndustrialRole());
		rs.setEntryCriteria(item.getEntryCriteria());
		rs.setActivate(item.getActivate());
		
		return rs;
	}
	
	public static RoleDTO toRoleDTO(Role item) {
		RoleDTO rs = new RoleDTO();
		
		rs.setId(item.getId());
		rs.setCareerPath(CareerPathMapper.toCareerPathDTO(item.getCareerPath()));
		rs.setPositionObj(PositionMapper.toPositionDTO(item.getPositionObj()));
		rs.setCompetencies(CompetencyMapper.toCompetencyDTOList(item.getCompetencies()));
		rs.setDomainRole(item.getDomainRole());
		rs.setCategory(item.getCategory());
		rs.setKRA(item.getKRA());
		rs.setScope(item.getScope());
		rs.setResponsibilities(item.getResponsibilities());
		rs.setIndustrialRole(item.getIndustrialRole());
		rs.setEntryCriteria(item.getEntryCriteria());
		rs.setActivate(item.getActivate());
		
		return rs;
	}
	
	public static List<RoleDTO> toRoleDTOList(List<Role> list)
	{
		List<RoleDTO> rs = new ArrayList<RoleDTO>();
		for (Role item : list) {
			rs.add(toRoleDTO(item));
		}
		return rs;
	}
}
