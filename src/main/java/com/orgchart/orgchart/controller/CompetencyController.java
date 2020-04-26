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

import com.orgchart.orgchart.DTO.CompetencyDTO;
import com.orgchart.orgchart.Mapper.CompetencyMapper;
import com.orgchart.orgchart.service.CompetencyService;

/**
 * @author NNA7HC
 *
 */

@RestController
@RequestMapping(path = "api/competency")
public class CompetencyController {

	@Autowired
	CompetencyService comService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<CompetencyDTO> getAll(){
		return CompetencyMapper.toCompetencyDTOList(this.comService.getAll());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> add(@RequestBody CompetencyDTO item) {
		return new ResponseEntity<Integer>(comService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> update(@RequestBody CompetencyDTO item) {
		return new ResponseEntity<Integer>(comService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> delete(@RequestBody CompetencyDTO item) {
		return new ResponseEntity<Integer>(comService.delete(item), HttpStatus.OK);
	}
	
}
