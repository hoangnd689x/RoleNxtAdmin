import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AddOrgComponent} from "./org/add-org/add-org.component";
import {ListOrgComponent} from "./org/list-org/list-org.component";
import {EditOrgComponent} from "./org/edit-org/edit-org.component";
import { AddStructureComponent } from './structure/add-structure/add-structure.component';
import { EditStructureComponent } from './structure/edit-structure/edit-structure.component';
import { ListStructureComponent } from './structure/list-structure/list-structure.component';
import { AddRoleComponent } from './role/add-role/add-role.component';
import { EditRoleComponent } from './role/edit-role/edit-role.component';
import { AddPositionComponent } from './position/add-position/add-position.component';
import { EditPositionComponent } from './position/edit-position/edit-position.component';
import { ListPositionComponent } from './position/list-position/list-position.component';
import { ListRoleComponent } from './role/list-role/list-role.component';
import { AddCompetencyComponent } from './competency/add-competency/add-competency.component';
import { EditCompetencyComponent } from './competency/edit-competency/edit-competency.component';
import { ListCompetencyComponent } from './competency/list-competency/list-competency.component';
import { AddDomainComponent } from './domain/add-domain/add-domain.component';
import { EditDomainComponent } from './domain/edit-domain/edit-domain.component';
import { ListDomainComponent } from './domain/list-domain/list-domain.component';
import { AddCareerpathComponent } from './careerpath/add-careerpath/add-careerpath.component';
import { EditCareerpathComponent } from './careerpath/edit-careerpath/edit-careerpath.component';
import { ListCareerpathComponent } from './careerpath/list-careerpath/list-careerpath.component';

const routes: Routes = [
  { path: 'add-org', component: AddOrgComponent },
  { path: 'list-org', component: ListOrgComponent },
  { path: 'edit-org/:id', component: EditOrgComponent },
  { path: 'add-structure', component: AddStructureComponent },
  { path: 'edit-structure/:id', component: EditStructureComponent },
  { path: 'list-structure', component: ListStructureComponent },
  { path: 'add-role', component: AddRoleComponent },
  { path: 'edit-role/:id', component: EditRoleComponent },
  { path: 'add-position', component: AddPositionComponent },
  { path: 'edit-position/:id', component: EditPositionComponent },
  { path: 'list-position', component: ListPositionComponent },
  { path: 'list-role', component: ListRoleComponent },
  { path: 'add-com', component: AddCompetencyComponent },
  { path: 'edit-com/:id', component: EditCompetencyComponent },
  { path: 'list-com', component: ListCompetencyComponent },
  { path: 'add-domain', component: AddDomainComponent },
  { path: 'edit-domain/:id', component: EditDomainComponent },
  { path: 'list-domain', component: ListDomainComponent },
  { path: 'add-cp', component: AddCareerpathComponent },
  { path: 'edit-cp/:id', component: EditCareerpathComponent },
  { path: 'list-cp', component: ListCareerpathComponent },
  {path : '', component : ListDomainComponent}
];

export const routing = RouterModule.forRoot(routes);
