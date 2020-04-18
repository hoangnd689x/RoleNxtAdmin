package com.orgchart.orgchart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.model.PositionDetails;
import com.orgchart.orgchart.serviceImpl.OrganizationServiceImpl;
import com.orgchart.orgchart.serviceImpl.PositionDetailServiceImpl;

@Controller
public class DepartmentController {
	OrganizationServiceImpl departmentService = new OrganizationServiceImpl();

	 @GetMapping("/")
	    public String index(Model model) {
		 List<Organization> listDepartment = new ArrayList();
		 List<Organization> newListDepartment = new ArrayList();
		 listDepartment = departmentService.getAllOrgs();
		 for (Organization department : listDepartment) {
				  if(!department.getName().trim().isEmpty() && department.getName()!=null) {
					  newListDepartment.add(department); } 
				  }
		 model.addAttribute("items",newListDepartment);
	        return "department";
	    }
	 
}
