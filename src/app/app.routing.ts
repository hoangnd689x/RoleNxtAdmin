import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AddOrgComponent} from "./org/add-org/add-org.component";
import {ListOrgComponent} from "./org/list-org/list-org.component";
import {EditOrgComponent} from "./org/edit-org/edit-org.component";

const routes: Routes = [
  { path: 'add-org', component: AddOrgComponent },
  { path: 'list-org', component: ListOrgComponent },
  { path: 'edit-org/:id', component: EditOrgComponent },
  {path : '', component : ListOrgComponent}
];

export const routing = RouterModule.forRoot(routes);
