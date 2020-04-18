package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.model.Position;

/**
 * @author YOG1HC
 *
 */
@Transactional
public interface PositionService {
	
	 List<Position> getAllPositions();
	 
	 List<Position> getAllPurePositions();
	 
	 Position getPosById(long id);
	 
	 boolean deletePos(long id);
	 
	 boolean UpdatePos(Position orgUpdate);
	 
	 public boolean AddPos(Position orgUpdate);
}
