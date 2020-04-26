package com.orgchart.orgchart.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.orgchart.orgchart.DTO.CareerPathDTO;
import com.orgchart.orgchart.model.CareerPath;

/**
 * @author NNA7HC
 *
 */

public class CareerPathMapper {
	public static CareerPath toCareerPath(CareerPathDTO item) {
		CareerPath rs = new CareerPath();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setColor(item.getColor());
		rs.setActivate(item.getActivate());
		
		return rs;
	}
	
	public static CareerPathDTO toCareerPathDTO(CareerPath item) {
		CareerPathDTO rs = new CareerPathDTO();
		
		rs.setId(item.getId());
		rs.setName(item.getName());
		rs.setColor(item.getColor());
		rs.setActivate(item.getActivate());
		
		return rs;
	}
	
	public static List<CareerPathDTO> toCareerPathDTOList(List<CareerPath> list)
	{
		List<CareerPathDTO> rs = new ArrayList<CareerPathDTO>();
		for (CareerPath item : list) {
			rs.add(toCareerPathDTO(item));
		}
		return rs;
	}
}
