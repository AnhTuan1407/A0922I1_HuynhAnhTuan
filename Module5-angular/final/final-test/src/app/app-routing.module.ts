import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BdsListComponent} from "./bat-dong-san/bds-list/bds-list.component";
import {BdsCreateComponent} from "./bat-dong-san/bds-create/bds-create.component";


const routes: Routes = [
  {path: 'bds/list', component: BdsListComponent},
  {path: 'bds/create', component: BdsCreateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
