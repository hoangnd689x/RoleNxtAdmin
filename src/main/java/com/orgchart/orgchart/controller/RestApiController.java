package com.orgchart.orgchart.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orgchart.orgchart.model.Position;
import com.orgchart.orgchart.service.PositionService;
import com.orgchart.orgchart.serviceImpl.PositionServiceImpl;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static Logger logger = LoggerFactory.getLogger(RestApiController.class);
	

	PositionServiceImpl positionService = new PositionServiceImpl();
	
	@RequestMapping(value = "/getAllPosition/", method = RequestMethod.GET)
	public ResponseEntity<List<Position>> getAllPosition(){
		
		List<Position> listPosition = new ArrayList();
		listPosition = positionService.getAllPosition();
		
		return new ResponseEntity<List<Position>>(listPosition, HttpStatus.OK);
	}
	
}
