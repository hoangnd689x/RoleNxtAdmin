package com.orgchart.orgchart.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.orgchart.orgchart.DTO.ConnectionDTO;
import com.orgchart.orgchart.model.Connection;

/**
 * @author NNA7HC
 *
 */

public class ConnectionMapper {
	public static Connection toConnection(ConnectionDTO item) {
		Connection rs = new Connection();
		
		rs.setId(item.getId());
		rs.setOrgObj(OrganizationMapper.toOrganization(item.getOrgObj()));
		rs.setSource(PositionMapper.toPosition(item.getSource()));
		rs.setTarget(PositionMapper.toPosition(item.getTarget()));
		rs.setActivate(item.getActivate());
		
		return rs;
	}
	
	public static ConnectionDTO toConnectionDTO(Connection item) {
		ConnectionDTO rs = new ConnectionDTO();
		rs.setId(item.getId());
		rs.setOrgObj(OrganizationMapper.toOrganizationDTO(item.getOrgObj()));
		rs.setSource(PositionMapper.toPositionDTO(item.getSource()));
		rs.setTarget(PositionMapper.toPositionDTO(item.getTarget()));
		rs.setActivate(item.getActivate());
		return rs;
	}
	
	public static List<ConnectionDTO> toConnectionDTOList(List<Connection> list)
	{
		List<ConnectionDTO> rs = new ArrayList<ConnectionDTO>();
		for (Connection item : list) {
			rs.add(toConnectionDTO(item));
		}
		return rs;
	}
}
