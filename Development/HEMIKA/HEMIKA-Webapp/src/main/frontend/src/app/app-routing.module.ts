import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import {HomeComponent} from "./modules/home/home.component";

const routes: Routes = [
  {path: '', component: FullLayoutComponent, children:[
      {path:'home', component:HomeComponent}
    ]},
  {path:'', component: SimpleLayoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
