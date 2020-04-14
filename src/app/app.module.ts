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

@NgModule({
  declarations: [
    AppComponent,
    ListOrgComponent,
    LoginComponent,
    AddOrgComponent,
    EditOrgComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ApiService, {provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
