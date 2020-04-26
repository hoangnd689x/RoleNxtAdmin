package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.DTO.ConnectionDTO;
import com.orgchart.orgchart.Mapper.ConnectionMapper;
import com.orgchart.orgchart.Mapper.OrganizationMapper;
import com.orgchart.orgchart.Mapper.PositionMapper;
import com.orgchart.orgchart.Repository.ConnectionRepository;
import com.orgchart.orgchart.model.Connection;

/**
 * @author NNA7HC
 *
 */
@Service
@Transactional
public class ConnectionService {
	
	@Autowired
	ConnectionRepository connectionRepository;
	
	public List<Connection> getAll(){
		return connectionRepository.getAll();
	}
	
	public ConnectionDTO findById(int id) {
		return ConnectionMapper.toConnectionDTO(connectionRepository.getOne(Integer.valueOf(id)));
	}
	
	public int add(ConnectionDTO obj) {
		Connection rs = new Connection();
		
		rs.setOrgObj(OrganizationMapper.toOrganization(obj.getOrgObj()));
		rs.setSource(PositionMapper.toPosition(obj.getSource()));
		rs.setTarget(PositionMapper.toPosition(obj.getTarget()));
		rs.setActivate(true);
		
		if(connectionRepository.save(rs) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int update(ConnectionDTO obj) {
		
		if(connectionRepository.save(ConnectionMapper.toConnection(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
	
	public int delete(ConnectionDTO obj) {
		
		obj.setActivate(false);
		if(connectionRepository.save(ConnectionMapper.toConnection(obj)) != null)
		{
			return 1;
		} 
		return 0;
	}
//	 List<Connection> GetAllConnections();
//	 
//	 public boolean AddCon(List<Connection> cons);
//
//	List<Connection> GetAllConnectionsByDepartmentID(long id);
}
