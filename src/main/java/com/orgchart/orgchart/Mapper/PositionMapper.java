package com.orgchart.orgchart.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.orgchart.orgchart.DTO.PositionDTO;
import com.orgchart.orgchart.model.Position;


/**
 * @author NNA7HC
 *
 */

public class PositionMapper {
	
	public static Position toPosition(PositionDTO item) {
		Position rs = new Position();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setCluster(item.getCluster());
		rs.setActivate(item.getActivate());
		rs.setCareerpathObj(CareerPathMapper.toCareerPath(item.getCareerpathObj()));
		rs.setOrganizationObj(OrganizationMapper.toOrganization(item.getOrganizationObj()));
		
		return rs;
	}
	
	public static PositionDTO toPositionDTO(Position item) {
		PositionDTO rs = new PositionDTO();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setCluster(item.getCluster());
		rs.setActivate(item.getActivate());
		rs.setCareerpathObj(CareerPathMapper.toCareerPathDTO(item.getCareerpathObj()));
		rs.setOrganizationObj(OrganizationMapper.toOrganizationDTO(item.getOrganizationObj()));
		
		return rs;
	}
	
	public static List<PositionDTO> toPositionDTOList(List<Position> list)
	{
		List<PositionDTO> rs = new ArrayList<PositionDTO>();
		for (Position item : list) {
			rs.add(toPositionDTO(item));
		}
		return rs;
	}
}
