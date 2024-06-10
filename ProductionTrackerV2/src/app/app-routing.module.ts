import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ControlPanelComponent } from './control-panel/control-panel.component';
import { ListWorkersComponent } from './list-workers/list-workers.component';

const routes: Routes = [
  { path: 'control-panel', component: ControlPanelComponent },
  { path: 'list-workers', component: ListWorkersComponent },

  { path: '', redirectTo: '/control-panel', pathMatch: 'full' },
  { path: '**', redirectTo: '/control-panel' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
