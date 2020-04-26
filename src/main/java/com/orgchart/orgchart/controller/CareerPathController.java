package com.orgchart.orgchart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orgchart.orgchart.DTO.CareerPathDTO;
import com.orgchart.orgchart.Mapper.CareerPathMapper;
import com.orgchart.orgchart.service.CareerPathService;

/**
 * @author NNA7HC
 *
 */

@RestController
@RequestMapping(path = "api/career-path")
public class CareerPathController {
	@Autowired
	CareerPathService careerPathService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<CareerPathDTO> getAll(){
		return CareerPathMapper.toCareerPathDTOList(this.careerPathService.getAll());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> add(@RequestBody CareerPathDTO item) {
		return new ResponseEntity<Integer>(careerPathService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> update(@RequestBody CareerPathDTO item) {
		return new ResponseEntity<Integer>(careerPathService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> delete(@RequestBody CareerPathDTO item) {
		return new ResponseEntity<Integer>(careerPathService.delete(item), HttpStatus.OK);
	}
}
