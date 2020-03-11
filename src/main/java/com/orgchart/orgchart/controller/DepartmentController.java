package com.orgchart.orgchart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.orgchart.orgchart.model.Department;
import com.orgchart.orgchart.model.PositionDetails;
import com.orgchart.orgchart.serviceImpl.DepartmentServiceImpl;
import com.orgchart.orgchart.serviceImpl.PositionDetailServiceImpl;

@Controller
public class DepartmentController {
	DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

	 @GetMapping("/")
	    public String index(Model model) {
		 List<Department> listDepartment = new ArrayList();
		 List<Department> newListDepartment = new ArrayList();
		 listDepartment = departmentService.getAllDepartments();
		 for (Department department : listDepartment) {
				  if(!department.getName().trim().isEmpty() && department.getName()!=null) {
					  newListDepartment.add(department); } 
				  }
		 model.addAttribute("items",newListDepartment);
	        return "department";
	    }
	 
}
