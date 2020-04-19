package com.orgchart.orgchart.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orgchart.orgchart.model.CareerPath;
import com.orgchart.orgchart.model.Competency;
import com.orgchart.orgchart.model.Domain;
import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.model.Position;
import com.orgchart.orgchart.model.Role;
import com.orgchart.orgchart.model.Structure;
import com.orgchart.orgchart.service.CareerPathService;
import com.orgchart.orgchart.service.CompetencyService;
import com.orgchart.orgchart.service.DomainService;
import com.orgchart.orgchart.service.OrganizationService;
import com.orgchart.orgchart.service.PositionService;
import com.orgchart.orgchart.service.RoleService;
import com.orgchart.orgchart.service.StructureService;
import com.orgchart.orgchart.serviceImpl.CareerPathServiceImpl;
import com.orgchart.orgchart.serviceImpl.CompetencyServiceImpl;
import com.orgchart.orgchart.serviceImpl.DomainServiceImpl;
import com.orgchart.orgchart.serviceImpl.OrganizationServiceImpl;
import com.orgchart.orgchart.serviceImpl.PositionServiceImpl;
import com.orgchart.orgchart.serviceImpl.RoleServiceImpl;
import com.orgchart.orgchart.serviceImpl.StructureServiceImpl;

/**
 * @author YOG1HC
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestApiController {

	public static Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	PositionService positionService = new PositionServiceImpl();
	
	StructureService structureService = new StructureServiceImpl();
	
	OrganizationService departmentService = new OrganizationServiceImpl();
	
	DomainService dmService = new DomainServiceImpl();
	
	CompetencyService compService = new CompetencyServiceImpl();
	
	RoleService rlService = new RoleServiceImpl();
	
	CareerPathService cpService = new CareerPathServiceImpl();
	
	
	/**
	 * get all positions in an organization
	 *
	 */
	@RequestMapping(value = "/getAllPositions", method = RequestMethod.GET)
	public ResponseEntity<List<Position>> getAllPositions(){
		
		List<Position> listPosition = new ArrayList();
		listPosition = positionService.getAllPositions();
		
		return new ResponseEntity<List<Position>>(listPosition, HttpStatus.OK);
	}
	
	/**
	 * get Position by Id
	 *
	 */
	@RequestMapping(value = "/getPosById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Position> GetPosById(@PathVariable(required = false) long id){
		
		Position pos = new Position();
		pos = positionService.getPosById(id);
		
		return new ResponseEntity<Position>(pos, HttpStatus.OK);
	}
	
	/**
	 * update an Organization
	 *
	 */
	@PostMapping(path = "/updatePos")
	public ResponseEntity<Integer> UpdatePos(@RequestBody Position pos){
		
		int deleteStatus;
		boolean isDetele = positionService.UpdatePos(pos);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * add a new Organization
	 *
	 */
	@PostMapping(path = "/addPos")
	public ResponseEntity<Integer> AddPos(@RequestBody Position pos){
		
		int deleteStatus;
		boolean isDetele = positionService.AddPos(pos);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * Delete an Organization
	 *
	 */
	@RequestMapping(value = "/deletePos/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> DeletePos(@PathVariable(required = false) long id){
		
		int deleteStatus;
		boolean isDetele = positionService.deletePos(id);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * get all Domain
	 *
	 */
	@RequestMapping(value = "/getAllDomains", method = RequestMethod.GET)
	public ResponseEntity<List<Domain>> getAllDomains(){
		
		List<Domain> listDm = new ArrayList();
		listDm = dmService.getAllDomains();
		
		return new ResponseEntity<List<Domain>>(listDm, HttpStatus.OK);
	}
	
	/**
	 * get a Domain by Id
	 *
	 */
	@RequestMapping(value = "/getDmById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Domain> GetDomainById(@PathVariable(required = false) long id){
		
		Domain dm = new Domain();
		dm = dmService.getDmById(id);
		
		return new ResponseEntity<Domain>(dm, HttpStatus.OK);
	}
	
	/**
	 * update a Domain
	 *
	 */
	@PostMapping(path = "/updateDm")
	public ResponseEntity<Integer> UpdateDomain(@RequestBody Domain dm){
		
		int deleteStatus;
		boolean isDetele = dmService.UpdateDm(dm);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * add a new Domain
	 *
	 */
	@PostMapping(path = "/addDm")
	public ResponseEntity<Integer> AddDomain(@RequestBody Domain dm){
		
		int deleteStatus;
		boolean isDetele = dmService.AddDm(dm);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * Delete a Domain
	 *
	 */
	@RequestMapping(value = "/deleteDm/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> DeleteDomain(@PathVariable(required = false) long id){
		
		int deleteStatus;
		boolean isDetele = dmService.deleteDm(id);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}

	
	/**
	 * get all Departments in an organization
	 *
	 */
	@RequestMapping(value = "/getAllOrgs", method = RequestMethod.GET)
	public ResponseEntity<List<Organization>> getAllDepartments(){
		
		List<Organization> listDepartment = new ArrayList();
		listDepartment = departmentService.getAllOrgs();
		
		return new ResponseEntity<List<Organization>>(listDepartment, HttpStatus.OK);
	}
	
	/**
	 * get Organization by Id
	 *
	 */
	@RequestMapping(value = "/getOrgById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Organization> GetOrgById(@PathVariable(required = false) long id){
		
		Organization org = new Organization();
		org = departmentService.getOrgById(id);
		
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
	
	/**
	 * update an Organization
	 *
	 */
	@PostMapping(path = "/updateOrg")
	public ResponseEntity<Integer> UpdateOrg(@RequestBody Organization org){
		
		int deleteStatus;
		boolean isDetele = departmentService.UpdateOrg(org);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * add a new Organization
	 *
	 */
	@PostMapping(path = "/addOrg")
	public ResponseEntity<Integer> AddOrg(@RequestBody Organization org){
		
		int deleteStatus;
		boolean isDetele = departmentService.AddOrg(org);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * Delete an Organization
	 *
	 */
	@RequestMapping(value = "/deleteOrg/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> DeleteOrg(@PathVariable(required = false) long id){
		
		int deleteStatus;
		boolean isDetele = departmentService.deleteOrg(id);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	

	
	/**
	 * get all structures in an organization
	 *
	 */
	@RequestMapping(value = "/getAllStructures", method = RequestMethod.GET)
	public ResponseEntity<List<Structure>> getAllStructures(){
		
		List<Structure> listStructure = new ArrayList();
		listStructure = structureService.getAllStructures();
		
		return new ResponseEntity<List<Structure>>(listStructure, HttpStatus.OK);
	}
	
	/**
	 * get Organization by Id
	 *
	 */
	@RequestMapping(value = "/getStrById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Structure> GetStrById(@PathVariable(required = false) long id){
		
		Structure str = new Structure();
		str = structureService.getStrById(id);
		
		return new ResponseEntity<Structure>(str, HttpStatus.OK);
	}
	
	/**
	 * update an Organization
	 *
	 */
	@PostMapping(path = "/updateStr")
	public ResponseEntity<Integer> UpdateStr(@RequestBody Structure str){
		
		int deleteStatus;
		boolean isDetele = structureService.UpdateStr(str);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * add a new Organization
	 *
	 */
	@PostMapping(path = "/addStr")
	public ResponseEntity<Integer> AddStr(@RequestBody Structure str){
		
		int deleteStatus;
		boolean isDetele = structureService.AddStr(str);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * Delete an Organization
	 *
	 */
	@RequestMapping(value = "/deleteStr/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> DeleteStr(@PathVariable(required = false) long id){
		
		int deleteStatus;
		boolean isDetele = structureService.deleteStr(id);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * get all getAllCompetencies
	 *
	 */
	@GetMapping(path = "/getAllCompetencies")
	public ResponseEntity<List<Competency>> getAllCompetencies(){
		
		List<Competency> listCompetencies = new ArrayList();
		listCompetencies = compService.GetAllCompetencies();
		
		return new ResponseEntity<List<Competency>>(listCompetencies, HttpStatus.OK);
	}
	
	/**
	 * get Competencies by Id
	 *
	 */
	@RequestMapping(value = "/getCompById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Competency> GetCompById(@PathVariable(required = false) long id){
		
		Competency comp = new Competency();
		comp = compService.GetCompById(id);
		
		return new ResponseEntity<Competency>(comp, HttpStatus.OK);
	}
	
	/**
	 * update Competencies
	 *
	 */
	@PostMapping(path = "/updateComp")
	public ResponseEntity<Integer> UpdateComp(@RequestBody Competency comp){
		
		int deleteStatus;
		boolean isDetele = compService.UpdateComp(comp);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * add Competencies
	 *
	 */
	@PostMapping(path = "/addComp")
	public ResponseEntity<Integer> AddComp(@RequestBody Competency comp){
		
		int deleteStatus;
		boolean isDetele = compService.AddComp(comp);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * Delete Competencies
	 *
	 */
	@RequestMapping(value = "/deleteComp/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> DeleteComp(@PathVariable(required = false) long id){
		
		int deleteStatus;
		boolean isDetele = compService.DeleteComp(id);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * get all get all roles
	 *
	 */
	@GetMapping(path = "/getAllRoles")
	public ResponseEntity<List<Role>> getAllRoles(){
		
		List<Role> listRoles = new ArrayList();
		listRoles = rlService.GetAllRoles();
		
		return new ResponseEntity<List<Role>>(listRoles, HttpStatus.OK);
	}
	
	/**
	 * get Roles by Id
	 *
	 */
	@RequestMapping(value = "/getRoleById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Role> GetRoleById(@PathVariable(required = false) long id){
		
		Role rl = new Role();
		rl = rlService.GetRoleById(id);
		
		return new ResponseEntity<Role>(rl, HttpStatus.OK);
	}
	
	/**
	 * update roles
	 *
	 */
	@PostMapping(path = "/updateRole")
	public ResponseEntity<Integer> UpdateRole(@RequestBody Role rl){
		
		int deleteStatus;
		boolean isDetele = rlService.UpdateRole(rl);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * add Roles
	 *
	 */
	@PostMapping(path = "/addRole")
	public ResponseEntity<Integer> AddRole(@RequestBody Role rl){
		
		int deleteStatus;
		boolean isDetele = rlService.AddRole(rl);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * Delete rlService
	 *
	 */
	@RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> DeleteRole(@PathVariable(required = false) long id){
		
		int deleteStatus;
		boolean isDetele = rlService.DeleteRole(id);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	
	/**
	 * get all get all roles
	 *
	 */
	@GetMapping(path = "/getAllCPs")
	public ResponseEntity<List<CareerPath>> getAllCPs(){
		
		List<CareerPath> listCareerPaths = new ArrayList();
		listCareerPaths = cpService.GetAllCareerpaths();
		
		return new ResponseEntity<List<CareerPath>>(listCareerPaths, HttpStatus.OK);
	}
	
	/**
	 * get Roles by Id
	 *
	 */
	@RequestMapping(value = "/getCPById/{id}", method = RequestMethod.GET)
	public ResponseEntity<CareerPath> GetCPById(@PathVariable(required = false) long id){
		
		CareerPath cp = new CareerPath();
		cp = cpService.GetCPById(id);
		
		return new ResponseEntity<CareerPath>(cp, HttpStatus.OK);
	}
	
	/**
	 * update roles
	 *
	 */
	@PostMapping(path = "/updateCP")
	public ResponseEntity<Integer> UpdateCP(@RequestBody CareerPath cp){
		
		int deleteStatus;
		boolean isDetele = cpService.UpdateCP(cp);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * add Roles
	 *
	 */
	@PostMapping(path = "/addCP")
	public ResponseEntity<Integer> AddCP(@RequestBody CareerPath cp){
		
		int deleteStatus;
		boolean isDetele = cpService.AddCP(cp);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	/**
	 * Delete rlService
	 *
	 */
	@RequestMapping(value = "/deleteCP/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> DeleteCP(@PathVariable(required = false) long id){
		
		int deleteStatus;
		boolean isDetele = cpService.DeleteCP(id);
		if(isDetele) {
			deleteStatus = 1;
		}else {
			deleteStatus = 0;
		}
		
		return new ResponseEntity<Integer>(deleteStatus, HttpStatus.OK);
	}
	
	// Other APIs
	/**
	 * get Organizations by domain Id
	 *
	 */
	@RequestMapping(value = "/getOrgsByDomainId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Organization>> GetOrgsByDomainId(@PathVariable(required = false) long id){
		
		List<Organization> listOrgs = new ArrayList<Organization>();
		
		listOrgs = dmService.GetOrgsByDomainId(id);
		
		return new ResponseEntity<List<Organization>>(listOrgs, HttpStatus.OK);
	}
	
	/**
	 * get positions by org id
	 *
	 */
	@RequestMapping(value = "/getPositionsByOrgId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Position>> GetPositionsByOrgId(@PathVariable(required = false) long id){
		
		List<Position> listPosition = new ArrayList();
		listPosition = positionService.getPositionsByOrgId(id);
		
		return new ResponseEntity<List<Position>>(listPosition, HttpStatus.OK);
	}
	
	/**
	 * get positions by org id
	 *
	 */
	@RequestMapping(value = "/getCompetenciesByDomainId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Competency>> GetCompetenciesByDomainId(@PathVariable(required = false) long id){
		
		List<Competency> listCompetency = new ArrayList();
		listCompetency = compService.GetCompetenciesByDomainId(id);
		
		return new ResponseEntity<List<Competency>>(listCompetency, HttpStatus.OK);
	}
	
}
