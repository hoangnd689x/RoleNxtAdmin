package com.orgchart.orgchart.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.orgchart.orgchart.DTO.CompetencyDTO;
import com.orgchart.orgchart.model.Competency;

public class CompetencyMapper {
	
	public static Competency toCompetency(CompetencyDTO item) {
		Competency rs = new Competency();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setCategory(item.getCategory());
		rs.setActivate(item.getActivate());
		rs.setDmOjb(DomainMapper.toDomain(item.getDmOjb()));
		
		return rs;
	}
	
	public static CompetencyDTO toCompetencyDTO(Competency item) {
		CompetencyDTO rs = new CompetencyDTO();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setCategory(item.getCategory());
		rs.setActivate(item.getActivate());
		rs.setDmOjb(DomainMapper.toDomainDTO(item.getDmOjb()));
		
		return rs;
	}
	
	public static List<Competency> toCompetencyList(List<CompetencyDTO> list)
	{
		List<Competency> rs = new ArrayList<Competency>();
		for (CompetencyDTO item : list) {
			rs.add(toCompetency(item));
		}
		return rs;
	}
	
	public static List<CompetencyDTO> toCompetencyDTOList(List<Competency> list)
	{
		List<CompetencyDTO> rs = new ArrayList<CompetencyDTO>();
		for (Competency item : list) {
			rs.add(toCompetencyDTO(item));
		}
		return rs;
	}
}
