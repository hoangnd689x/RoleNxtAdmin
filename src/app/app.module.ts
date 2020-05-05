import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListOrgComponent } from './org/list-org/list-org.component';
import { LoginComponent } from './login/login.component';
import { AddOrgComponent } from './org/add-org/add-org.component';
import { EditOrgComponent } from './org/edit-org/edit-org.component';
import {routing} from "./app.routing";
import {ReactiveFormsModule} from "@angular/forms";
import {ApiService} from "./service/api.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {TokenInterceptor} from "./core/interceptor";
import { AddStructureComponent } from './structure/add-structure/add-structure.component';
import { EditStructureComponent } from './structure/edit-structure/edit-structure.component';
import { AddPositionComponent } from './position/add-position/add-position.component';
import { EditPositionComponent } from './position/edit-position/edit-position.component';
import { AddRoleComponent } from './role/add-role/add-role.component';
import { EditRoleComponent } from './role/edit-role/edit-role.component';
import { ListStructureComponent } from './structure/list-structure/list-structure.component';
import { ListRoleComponent } from './role/list-role/list-role.component';
import { ListPositionComponent } from './position/list-position/list-position.component';
import { AddCompetencyComponent } from './competency/add-competency/add-competency.component';
import { EditCompetencyComponent } from './competency/edit-competency/edit-competency.component';
import { ListCompetencyComponent } from './competency/list-competency/list-competency.component';
import { AddCareerpathComponent } from './careerpath/add-careerpath/add-careerpath.component';
import { EditCareerpathComponent } from './careerpath/edit-careerpath/edit-careerpath.component';
import { ListCareerpathComponent } from './careerpath/list-careerpath/list-careerpath.component';
import { AddDomainComponent } from './domain/add-domain/add-domain.component';
import { EditDomainComponent } from './domain/edit-domain/edit-domain.component';
import { ListDomainComponent } from './domain/list-domain/list-domain.component';
import { ColorPickerModule } from './color-picker/color-picker.module';


@NgModule({
  declarations: [
    AppComponent,
    ListOrgComponent,
    LoginComponent,
    AddOrgComponent,
    EditOrgComponent,
    AddStructureComponent,
    EditStructureComponent,
    AddPositionComponent,
    EditPositionComponent,
    AddRoleComponent,
    EditRoleComponent,
    ListStructureComponent,
    ListRoleComponent,
    ListPositionComponent,
    AddCompetencyComponent,
    EditCompetencyComponent,
    ListCompetencyComponent,
    AddCareerpathComponent,
    EditCareerpathComponent,
    ListCareerpathComponent,
    AddDomainComponent,
    EditDomainComponent,
    ListDomainComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule,
    ColorPickerModule,
  ],
  providers: [ApiService, {provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
