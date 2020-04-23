package com.orgchart.orgchart.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.orgchart.orgchart.DTO.OrganizationDTO;
import com.orgchart.orgchart.model.Organization;

/**
 * @author NNA7HC
 *
 */

public class OrganizationMapper {

	public static Organization toOrganization(OrganizationDTO item) {
		Organization rs = new Organization();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setBusinessSector(item.getBusinessSector());
		rs.setActivate(item.getActivate());
		rs.setDomainObj(DomainMapper.toDomain(item.getDomainObj()));
		
		return rs;
	}
	
	public static OrganizationDTO toOrganizationDTO(Organization item) {
		OrganizationDTO rs = new OrganizationDTO();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setBusinessSector(item.getBusinessSector());
		rs.setActivate(item.getActivate());
		rs.setDomainObj(DomainMapper.toDomainDTO(item.getDomainObj()));
		
		return rs;
	}
	
	public static List<OrganizationDTO> toOrganizationDTOList(List<Organization> list)
	{
		List<OrganizationDTO> rs = new ArrayList<OrganizationDTO>();
		for (Organization org : list) {
			rs.add(toOrganizationDTO(org));
		}
		return rs;
	}
}
