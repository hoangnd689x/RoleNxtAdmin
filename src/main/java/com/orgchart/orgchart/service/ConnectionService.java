package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.Connection;

/**
 * @author YOG1HC
 *
 */
@Transactional
public interface ConnectionService {
	
	 List<Connection> GetAllConnections();
	 
	 public boolean AddCon(List<Connection> cons);

	List<Connection> GetAllConnectionsByDepartmentID(long id);
}
