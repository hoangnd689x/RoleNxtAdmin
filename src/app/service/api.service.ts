import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../model/user.model";
import {Observable} from "rxjs/index";
import {ApiResponse} from "../model/api.response";
import { Organization } from '../model/organization';

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  //baseUrl: string = 'http://localhost:8080/orgchart/api/';
  baseUrl: string = 'http://10.184.93.88:6060/orgchart/api/';

  login(loginPayload) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', loginPayload);
  }

  getOrgs() : Observable<Organization[]> {
    return this.http.get<Organization[]>(this.baseUrl+'getAllOrgs/');
  }

  getOrgById(id: number): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'getOrgById/' + id,"");
  }

  createOrg(org: Organization): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'addOrg/', org);
  }

  updateOrg(org: Organization): Observable<Number> {
    return this.http.post<Number>(this.baseUrl+'updateOrg/', org);
  }

  deleteOrg(id: string): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl+'deleteOrg/' + id);
  }
}
