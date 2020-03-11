package com.orgchart.orgchart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orgchart.orgchart.model.PositionDetails;
import com.orgchart.orgchart.serviceImpl.PositionDetailServiceImpl;

@Controller
public class PositionDetailsController {
	PositionDetailServiceImpl poDService = new PositionDetailServiceImpl();
	
	  @GetMapping("/position/details/{id}") public String
	  getPositionDetails(@PathVariable("id") String id, Model model ) {
	  List<PositionDetails> listDepartment = new ArrayList(); listDepartment =
	  poDService.getAllPositionDetails(); // start to loop 
	  for (PositionDetails
	  positionDetail : listDepartment) {
	  if(positionDetail.getPosition().equalsIgnoreCase(id)) {
		  
		  model.addAttribute("item",positionDetail); } 
	  }
	  
	  return "position-detail"; }
	 
}
