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

import com.orgchart.orgchart.DTO.ConnectionDTO;
import com.orgchart.orgchart.Mapper.ConnectionMapper;
import com.orgchart.orgchart.service.ConnectionService;

@RestController
@RequestMapping(path = "api/connection")
public class ConnectionController {
	
	@Autowired
	ConnectionService connectionService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<ConnectionDTO> getAll(){
		return ConnectionMapper.toConnectionDTOList(this.connectionService.getAll());
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> add(@RequestBody ConnectionDTO item) {
		return new ResponseEntity<Integer>(connectionService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> update(@RequestBody ConnectionDTO item) {
		return new ResponseEntity<Integer>(connectionService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> delete(@RequestBody ConnectionDTO item) {
		return new ResponseEntity<Integer>(connectionService.delete(item), HttpStatus.OK);
	}
}
