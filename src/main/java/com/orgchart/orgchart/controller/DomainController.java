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

import com.orgchart.orgchart.DTO.DomainDTO;
import com.orgchart.orgchart.Mapper.DomainMapper;
import com.orgchart.orgchart.service.DomainService;

@RestController
@RequestMapping(path = "api/domain")
public class DomainController {

	@Autowired
	DomainService dmService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<DomainDTO> getAllDepartment(){
		return DomainMapper.toDomainDTOList(this.dmService.getAll());
	}
	
	@RequestMapping(value = "/add-domain", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> addDomain(@RequestBody DomainDTO item) {
		return new ResponseEntity<Integer>(dmService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update-domain", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> updateDomain(@RequestBody DomainDTO item) {
		return new ResponseEntity<Integer>(dmService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete-domain", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> deleteDomain(@RequestBody DomainDTO item) {
		return new ResponseEntity<Integer>(dmService.delete(item), HttpStatus.OK);
	}
}
