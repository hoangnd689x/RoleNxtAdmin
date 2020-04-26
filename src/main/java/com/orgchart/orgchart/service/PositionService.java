package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.DTO.PositionDTO;
import com.orgchart.orgchart.Mapper.CareerPathMapper;
import com.orgchart.orgchart.Mapper.DomainMapper;
import com.orgchart.orgchart.Mapper.OrganizationMapper;
import com.orgchart.orgchart.Mapper.PositionMapper;
import com.orgchart.orgchart.Repository.PositionRepository;
import com.orgchart.orgchart.model.Position;
import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.model.Position;

/**
 * @author NNA7HC
 *
 */
@Service
@Transactional
public class PositionService {
	
	@Autowired
	PositionRepository PositionRepository;
	
	public List<Position> getAll(){
		return PositionRepository.getAll();
	}
	
	public PositionDTO findById(int id) {
		return PositionMapper.toPositionDTO(PositionRepository.getOne(Integer.valueOf(id)));
	}
	
	public int add(PositionDTO obj) {
		Position rs = new Position();
		
		rs.setName(obj.getName());
		rs.setCluster(obj.getCluster());
		rs.setCareerpathObj(CareerPathMapper.toCareerPath(obj.getCareerpathObj()));
		rs.setOrganizationObj(OrganizationMapper.toOrganization(obj.getOrganizationObj()));
		rs.setActivate(true);
		
		if(PositionRepository.save(rs) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int update(PositionDTO obj) {
		
		if(PositionRepository.save(PositionMapper.toPosition(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int delete(PositionDTO obj) {
		
		obj.setActivate(false);
		if(PositionRepository.save(PositionMapper.toPosition(obj)) != null)
		{
			return 1;
		} 
		return 0;
		
	}
	
//	 List<Position> getAllPositions();
//	 
//	 List<Position> getAllPurePositions();
//	 
//	 List<Position> getPositionsByOrgId(long orgId);
//	 
//	 Position getPosById(long id);
//	 
//	 boolean deletePos(long id);
//	 
//	 boolean UpdatePos(Position orgUpdate);
//	 
//	 public boolean AddPos(Position orgUpdate);
}
