import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudioListComponent } from "./studio/view/studio-list/studio-list.component";
import { StudioCreateComponent} from "./studio/view/studio-create/studio-create.component";
import { StudioEditComponent} from "./studio/view/studio-edit/studio-edit.component";
import {StudioViewComponent} from "./studio/view/studio-view/studio-view.component";
import {MovieCreateComponent} from "./movie/view/movie-create/movie-create.component";
import {MovieEditComponent} from "./movie/view/movie-edit/movie-edit.component";
import {MovieViewComponent} from "./movie/view/movie-view/movie-view.component";
//import { CharacterListComponent } from "./character/view/character-list/character-list.component";
//import { CharacterViewComponent } from "./character/view/character-view/character-view.component";
//import { CharacterEditComponent } from "./character/view/character-edit/character-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: StudioListComponent,
    path: "studios"
  },
  {
    component: StudioCreateComponent,
    path: "studios/create"
  },
  {
    component: StudioEditComponent,
    path: "studios/:uuid/edit"
  },
  {
    component: StudioViewComponent,
    path: "studios/:uuid"
  },
  {
    component: MovieCreateComponent,
    path: "studios/:uuid/movies/create"
  },
  {
    component: MovieEditComponent,
    path: "studios/:studioId/movies/:movieId/edit"
  },
  {
    component: MovieViewComponent,
    path: "studios/:studioId/movies/:movieId"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
