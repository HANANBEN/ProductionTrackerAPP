import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ControlPanelComponent } from './control-panel/control-panel.component';
import { EditWorkerComponent } from './edit-worker/edit-worker.component';
import { ListWorkersComponent } from './list-workers/list-workers.component';

const routes: Routes = [
  { path: 'control-panel', component: ControlPanelComponent },
  { path: 'list-workers', component: ListWorkersComponent },
  { path: 'workers/edit/:id', component: EditWorkerComponent },
  { path: '', redirectTo: '/control-panel', pathMatch: 'full' },
  { path: '**', redirectTo: '/control-panel' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
