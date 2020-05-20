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
import { Connection } from '../model/connection';

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/orgchart/api/';
  //baseUrl: string = 'http://10.184.93.88:6060/orgchartapis/api/';

  login(loginPayload) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', loginPayload);
  }

  //Domain
  getAllDomain(): Observable<Domain[]> {
    return this.http.get<Domain[]>(this.baseUrl+'domain/get-all')
  }

  createDomain(domain: Domain): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'domain/add', domain);
  }

  deleteDomain(domain: Domain): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'domain/delete', domain);
  }

  updateDomain(domain: Domain): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'domain/update', domain);
  }

  getDomainById(id: string): Observable<Domain> {
    return this.http.get<Domain>(this.baseUrl+'domain/get-by-id/' + id);
  }

  //Organization
  getOrgs() : Observable<Organization[]> {
    return this.http.get<Organization[]>(this.baseUrl+'org/get-all');
  }

  getOrgsByDomainId(domainId: string) : Observable<Organization[]> {
    return this.http.get<Organization[]>(this.baseUrl+'org/get-by-domain/'+domainId);
  }

  getOrgById(id: string): Observable<Organization> {
    return this.http.get<Organization>(this.baseUrl+'org/get-by-id/' + id);
  }

  createOrg(org: Organization): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'org/add', org);
  }

  updateOrg(org: Organization): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'org/update', org);
  }

  deleteOrg(org: Organization): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'org/delete', org);
  }

  //Position

  getAllPositions() : Observable<Position[]> {
    return this.http.get<Position[]>(this.baseUrl+'position/get-all');
  }

  createPosition(pos: Position): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'position/add', pos);
  }

  getPositionById(id: string): Observable<Position> {
    return this.http.get<Position>(this.baseUrl+'position/get-by-id/' + id);
  }

  updatePosition(pos: Position): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'position/update', pos);
  }

  deletePosition(pos: Position): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'position/delete', pos);
  }

  getPositionsByOrgId(id: string) : Observable<Position[]> {
    return this.http.get<Position[]>(this.baseUrl+'position/get-by-org/' + id);
  }

  //Competency

  getAllCompetencies() : Observable<Competency[]> {
    return this.http.get<Competency[]>(this.baseUrl+'competency/get-all');
  }

  createCompetencies(comp: Competency): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'competency/add', comp);
  }

  deleteCompetency(comp: Competency): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'competency/delete/', comp);
  }

  getCompetencyById(id: string): Observable<Competency> {
    return this.http.get<Competency>(this.baseUrl+'competency/get-by-id/' + id);
  }

  updateCompetency(comp: Competency): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'competency/update', comp);
  }

  getCompetencyByDomainId(id: string): Observable<Competency[]> {
    return this.http.get<Competency[]>(this.baseUrl+'competency/get-by-domain/' + id);
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
    return this.http.get<Role[]>(this.baseUrl+'role/get-all');
  }

  createRole(role: Role): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'role/add', role);
  }

  deleteRole(role: Role): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'role/delete', role);
  }

  updateRole(role: Role): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'role/update', role);
  }

  getRoleById(id: string): Observable<Role> {
    return this.http.get<Role>(this.baseUrl+'role/get-by-id/' + id);
  }

  //Career Path

  getAllCareerPaths() : Observable<CareerPath[]> {
    return this.http.get<CareerPath[]>(this.baseUrl+'career-path/get-all');
  }

  createCareerPath(careerPath: CareerPath): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'career-path/add', careerPath);
  }

  deleteCareerPath(careerPath: CareerPath): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'career-path/delete', careerPath);
  }

  updateCareerPath(careerPath: CareerPath): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'career-path/update', careerPath);
  }

  getCareerPathById(id: string): Observable<CareerPath> {
    return this.http.get<CareerPath>(this.baseUrl+'career-path/get-by-id/' + id);
  }

  //Connection

  getAllConnections() : Observable<Connection[]> {
    return this.http.get<Connection[]>(this.baseUrl+'connection/get-all');
  }

  createConnection(con: Connection): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'connection/add', con);
  }

  deleteConnection(con: Connection): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'connection/delete', con);
  }

  updateConnection(con: Connection): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'connection/update', con);
  }

  getConnectionById(id: string): Observable<Connection> {
    return this.http.get<Connection>(this.baseUrl+'connection/get-by-id/' + id);
  }

}
