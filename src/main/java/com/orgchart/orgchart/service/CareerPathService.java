package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.DTO.CareerPathDTO;
import com.orgchart.orgchart.Mapper.CareerPathMapper;
import com.orgchart.orgchart.Repository.CareerPathRepository;
import com.orgchart.orgchart.model.CareerPath;


/**
 * @author NNA7HC
 *
 */
@Service
@Transactional
public class CareerPathService {
	
	@Autowired
	private CareerPathRepository careerPathRepository;
	
	public List<CareerPath> getAll(){
		return careerPathRepository.getAll();
	}
	
	public CareerPath findById(int id) {
		return careerPathRepository.getOne(Integer.valueOf(id));
	}
	
	public int add(CareerPathDTO obj) {
		CareerPath rs = new CareerPath();
		
		rs.setName(obj.getName());
		rs.setColor(obj.getColor());
		rs.setActivate(true);
		if(careerPathRepository.save(rs) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int update(CareerPathDTO obj) {
		
		if(careerPathRepository.save(CareerPathMapper.toCareerPath(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int delete(CareerPathDTO obj) {
		
		obj.setActivate(false);
		if(careerPathRepository.save(CareerPathMapper.toCareerPath(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	
//	 List<CareerPath> GetAllCareerpaths();
//	 
//	 CareerPath GetCPById(long id);
//	 
//	 boolean DeleteCP(long id);
//	 
//	 boolean UpdateCP(CareerPath orgUpdate);
//	 
//	 public boolean AddCP(CareerPath orgUpdate);
}
