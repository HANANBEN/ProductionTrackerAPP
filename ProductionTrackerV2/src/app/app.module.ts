import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ControlPanelComponent } from './control-panel/control-panel.component';
import { ListWorkersService } from './list-workers.service';
import { ListWorkersComponent } from './list-workers/list-workers.component';
@NgModule({
  declarations: [
    AppComponent,
    ControlPanelComponent,
    ListWorkersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
  ],
  providers: [
    provideHttpClient(),

      ListWorkersService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
