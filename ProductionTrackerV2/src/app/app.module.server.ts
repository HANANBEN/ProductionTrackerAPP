import { NgModule } from '@angular/core';
import { ServerModule } from '@angular/platform-server';

import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AppModule } from './app.module';


@NgModule({
  imports: [
    AppModule,
    ServerModule,
    HttpClientModule,
  ],
  bootstrap: [AppComponent],
})
export class AppServerModule {}
