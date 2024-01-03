import { Component } from '@angular/core';
import {StudioForm} from "../../model/studio-form";
import {ActivatedRoute, Router} from "@angular/router";
import {StudioService} from "../../service/studio.service";


@Component({
  selector: 'app-studio-create',
  templateUrl: './studio-create.component.html',
  styleUrl: './studio-create.component.css'
})
export class StudioCreateComponent {
  studio: StudioForm = {
    name: '',
    owner: '',
    numberOfWorkers: 0,
    yearsOfExperience: 0
  };

  uuid: string = 'f5875513-bf7b-4ae1-b8a5-5b70a1b90e33';

  constructor(
    private studioService: StudioService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  onSubmit(): void {
      this.studioService.putStudio(this.uuid!, this.studio!)
        .subscribe(() => this.router.navigate(['/studios']));
    }
}
