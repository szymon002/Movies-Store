import {Component, OnInit} from '@angular/core';
import {StudioForm} from "../../model/studio-form";
import {StudioService} from "../../service/studio.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-studio-edit',
  templateUrl: './studio-edit.component.html',
  styleUrl: './studio-edit.component.css'
})
export class StudioEditComponent implements OnInit{
  uuid: string | undefined;

  studio: StudioForm | undefined;

  original: StudioForm | undefined;

  constructor(
    private studioService: StudioService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }


  ngOnInit(): void {
    this.route.params.subscribe(params => {

      this.studioService.getStudio(params['uuid'])
        .subscribe(studio => {
          this.uuid = studio.id;
          this.studio = {
            name: studio.name,
            owner: studio.owner,
            yearsOfExperience: studio.yearsOfExperience,
            numberOfWorkers: studio.numberOfWorkers
          };
          this.original = {...this.studio};
        });
    });

  }

  onSubmit(): void {
    this.studioService.patchStudio(this.uuid!, this.studio!)
      .subscribe(() => this.router.navigate(['/studios']));
  }


}
