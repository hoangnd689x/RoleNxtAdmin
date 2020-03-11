package com.orgchart.orgchart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.orgchart.orgchart.model.Department;
import com.orgchart.orgchart.serviceImpl.DepartmentServiceImpl;
import com.orgchart.orgchart.serviceImpl.PositionDetailServiceImpl;

@Controller
public class DepartmentController {
	DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

	 @GetMapping("/")
	    public String index(Model model) {
		 List<Department> listDepartment = new ArrayList();
		 listDepartment = departmentService.getAllDepartments();
		 model.addAttribute("items",listDepartment);
	        return "department";
	    }
	 
}
