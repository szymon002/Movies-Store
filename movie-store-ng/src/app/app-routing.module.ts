import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudioListComponent } from "./studio/view/studio-list/studio-list.component";
import { StudioCreateComponent} from "./studio/view/studio-create/studio-create.component";
import { StudioEditComponent} from "./studio/view/studio-edit/studio-edit.component";
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
  }
 /* {
    component: CharacterListComponent,
    path: "characters"
  },
  {
    component: CharacterViewComponent,
    path: "characters/:uuid"
  }
  ,
  {
    component: CharacterEditComponent,
    path: "characters/:uuid/edit"
  } */
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
