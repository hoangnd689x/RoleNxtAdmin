package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.CareerPath;
import com.orgchart.orgchart.model.Domain;
import com.orgchart.orgchart.model.Organization;

/**
 * @author YOG1HC
 *
 */
@Transactional
public interface CareerPathService {
	
	 List<CareerPath> GetAllCareerpaths();
	 
	 CareerPath GetCPById(long id);
	 
	 boolean DeleteCP(long id);
	 
	 boolean UpdateCP(CareerPath orgUpdate);
	 
	 public boolean AddCP(CareerPath orgUpdate);
}
