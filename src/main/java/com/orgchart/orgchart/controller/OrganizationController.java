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

import com.orgchart.orgchart.DTO.OrganizationDTO;
import com.orgchart.orgchart.Mapper.OrganizationMapper;
import com.orgchart.orgchart.service.OrganizationService;

@RestController
@RequestMapping(path = "api/org")
public class OrganizationController {

	@Autowired
	OrganizationService orgService;
	
	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<OrganizationDTO> getAllDepartment(){
		return OrganizationMapper.toOrganizationDTOList(this.orgService.getAll());
	}
	
	@RequestMapping(value = "/add-org", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> addDomain(@RequestBody OrganizationDTO item) {
		return new ResponseEntity<Integer>(orgService.add(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update-org", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> updateDomain(@RequestBody OrganizationDTO item) {
		return new ResponseEntity<Integer>(orgService.update(item), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete-org", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> deleteDomain(@RequestBody OrganizationDTO item) {
		return new ResponseEntity<Integer>(orgService.delete(item), HttpStatus.OK);
	}
}
