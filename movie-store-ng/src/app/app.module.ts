import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { StudioListComponent } from './studio/view/studio-list/studio-list.component';
import { HttpClientModule } from "@angular/common/http";
import { StudioService } from "./studio/service/studio.service";
import { FormsModule } from "@angular/forms";
import {StudioCreateComponent} from "./studio/view/studio-create/studio-create.component";
import {StudioEditComponent} from "./studio/view/studio-edit/studio-edit.component";
import {StudioViewComponent} from "./studio/view/studio-view/studio-view.component";
import {MovieCreateComponent} from "./movie/view/movie-create/movie-create.component";
import {MovieService} from "./movie/service/movie-service";
import {MovieEditComponent} from "./movie/view/movie-edit/movie-edit.component";
import {MovieViewComponent} from "./movie/view/movie-view/movie-view.component";



@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    StudioListComponent,
    StudioCreateComponent,
    StudioEditComponent,
    StudioViewComponent,
    MovieCreateComponent,
    MovieEditComponent,
    MovieViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    MovieService,
    StudioService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
