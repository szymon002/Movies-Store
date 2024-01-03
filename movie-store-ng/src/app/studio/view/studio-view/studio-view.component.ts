import {Component, OnInit} from '@angular/core';
import {StudioService} from "../../service/studio.service";
import {ActivatedRoute, Router} from "@angular/router";
import {StudioDetails} from "../../model/studio-details";
import {Studio} from "../../model/studio";
import {Movie} from "../../../movie/model/movie";

@Component({
  selector: 'app-studio-view',
  templateUrl: './studio-view.component.html',
  styleUrl: './studio-view.component.css'
})
export class StudioViewComponent implements OnInit{
    studio: StudioDetails | undefined;

  constructor(private service: StudioService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getStudio(params['uuid'])
        .subscribe(studio => this.studio = studio)

        this.service.getMovies(params['uuid'])
            .subscribe(movies => this.studio!.movies = movies.movies);
    });
  }

  onDelete(movie: Movie): void {
    this.service.deleteMovie(movie.id).subscribe(() => this.ngOnInit());
  }

}
