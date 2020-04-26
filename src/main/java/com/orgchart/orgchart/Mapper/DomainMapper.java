package com.orgchart.orgchart.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.orgchart.orgchart.DTO.DomainDTO;
import com.orgchart.orgchart.model.Domain;

/**
 * @author NNA7HC
 *
 */
public class DomainMapper {

	public static Domain toDomain(DomainDTO item) {
		Domain rs = new Domain();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setActivate(item.getActivate());
		
		return rs;
	}
	
	public static DomainDTO toDomainDTO(Domain item) {
		DomainDTO rs = new DomainDTO();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setActivate(item.getActivate());
		
		return rs;
	}
	
	public static List<DomainDTO> toDomainDTOList(List<Domain> list)
	{
		List<DomainDTO> rs = new ArrayList<DomainDTO>();
		for (Domain item : list) {
			rs.add(toDomainDTO(item));
		}
		return rs;
	}
}
