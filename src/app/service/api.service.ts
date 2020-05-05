import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../model/user.model";
import {Observable} from "rxjs/index";
import {ApiResponse} from "../model/api.response";
import { Organization } from '../model/organization';
import { Domain } from '../model/domain';
import { Position } from '../model/position';
import { Competency } from '../model/Competency';
import { Structure } from '../model/structure';
import { Role } from '../model/role';
import { CareerPath } from '../model/careerpath';

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  //baseUrl: string = 'http://localhost:8080/orgchart/api/';
  baseUrl: string = 'http://10.184.93.88:6060/orgchartapis/api/';

  login(loginPayload) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', loginPayload);
  }

  //Domain
  getAllDomain(): Observable<Domain[]> {
    return this.http.get<Domain[]>(this.baseUrl+'getAllDomains/')
  }

  createDomain(domain: Domain): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'addDm/', domain);
  }

  deleteDomain(id: string): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'deleteDm/' + id, null);
  }

  updateDomain(domain: Domain): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'updateDm/', domain);
  }

  getDomainById(id: string): Observable<Domain> {
    return this.http.get<Domain>(this.baseUrl+'getDmById/' + id);
  }

  //Organization
  getOrgs() : Observable<Organization[]> {
    return this.http.get<Organization[]>(this.baseUrl+'getAllOrgs/');
  }

  getOrgsByDomainId(domainId: string) : Observable<Organization[]> {
    return this.http.get<Organization[]>(this.baseUrl+'getOrgsByDomainId/'+domainId);
  }

  getOrgById(id: string): Observable<Organization> {
    return this.http.get<Organization>(this.baseUrl+'getOrgById/' + id);
  }

  createOrg(org: Organization): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'addOrg/', org);
  }

  updateOrg(org: Organization): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'updateOrg/', org);
  }

  deleteOrg(id: string): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'deleteOrg/' + id, null);
  }

  //Position

  getAllPositions() : Observable<Position[]> {
    return this.http.get<Position[]>(this.baseUrl+'getAllPositions/');
  }

  createPosition(pos: Position): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'addPos/', pos);
  }

  getPositionById(id: string): Observable<Position> {
    return this.http.get<Position>(this.baseUrl+'getPosById/' + id);
  }

  updatePosition(pos: Position): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'updatePos/', pos);
  }

  deletePosition(id: string): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'deletePos/' + id, null);
  }

  getPositionsByOrgId(id: string) : Observable<Position[]> {
    return this.http.get<Position[]>(this.baseUrl+'getPositionsByOrgId/' + id);
  }

  //Competency

  getAllCompetencies() : Observable<Competency[]> {
    return this.http.get<Competency[]>(this.baseUrl+'getAllCompetencies/');
  }

  createCompetencies(comp: Competency): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'addComp/', comp);
  }

  deleteCompetency(id: string): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'deleteComp/' + id, null);
  }

  getCompetencyById(id: string): Observable<Competency> {
    return this.http.get<Competency>(this.baseUrl+'getCompById/' + id);
  }

  updateCompetency(comp: Competency): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'updateComp/', comp);
  }

  getCompetencyByDomainId(id: string): Observable<Competency[]> {
    return this.http.get<Competency[]>(this.baseUrl+'getCompetenciesByDomainId/' + id);
  }

  //Structure

  getAllStructures() : Observable<Structure[]> {
    return this.http.get<Structure[]>(this.baseUrl+'getAllStructures/');
  }

  createStructure(structure: Structure): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'addStr/', structure);
  }

  deleteStructure(id: string): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'deleteStr/' + id, null);
  }

  updateStructure(structure: Structure): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'updateStr/', structure);
  }

  getStructureById(id: string): Observable<Structure> {
    return this.http.get<Structure>(this.baseUrl+'getStrById/' + id);
  }

  //Role

  getAllRoles() : Observable<Role[]> {
    return this.http.get<Role[]>(this.baseUrl+'getAllRoles/');
  }

  createRole(role: Role): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'addRole/', role);
  }

  deleteRole(id: string): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'deleteRole/' + id, null);
  }

  updateRole(role: Role): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'updateRole/', role);
  }

  getRoleById(id: string): Observable<Role> {
    return this.http.get<Role>(this.baseUrl+'getRoleById/' + id);
  }

  //Career Path

  getAllCareerPaths() : Observable<CareerPath[]> {
    return this.http.get<CareerPath[]>(this.baseUrl+'getAllCPs/');
  }

  createCareerPath(careerPath: CareerPath): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'addCP/', careerPath);
  }

  deleteCareerPath(id: string): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'deleteCP/' + id, null);
  }

  updateCareerPath(careerPath: CareerPath): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'updateCP/', careerPath);
  }

  getCareerPathById(id: string): Observable<CareerPath> {
    return this.http.get<CareerPath>(this.baseUrl+'getCPById/' + id);
  }

}
