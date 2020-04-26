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

import com.orgchart.orgchart.DTO.PositionDTO;
import com.orgchart.orgchart.Mapper.PositionMapper;
import com.orgchart.orgchart.service.PositionService;

/**
 * @author NNA7HC
 *
 */

@RestController
@RequestMapping(path = "api/position")
public class PositionController {

	@Autowired
	PositionService positionService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<PositionDTO> getAll(){
		return PositionMapper.toPositionDTOList(this.positionService.getAll());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> add(@RequestBody PositionDTO item) {
		return new ResponseEntity<Integer>(positionService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> update(@RequestBody PositionDTO item) {
		return new ResponseEntity<Integer>(positionService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> delete(@RequestBody PositionDTO item) {
		return new ResponseEntity<Integer>(positionService.delete(item), HttpStatus.OK);
	}
}
