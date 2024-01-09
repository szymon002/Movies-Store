import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MovieForm} from "../../model/movie-form";
import {MovieService} from "../../service/movie-service";
import {MovieEdit} from "../../model/movie-edit";
import {Studio} from "../../../studio/model/studio";
import {StudioService} from "../../../studio/service/studio.service";
import {Studios} from "../../../studio/model/studios";

@Component({
  selector: 'app-movie-edit',
  templateUrl: './movie-edit.component.html',
  styleUrl: './movie-edit.component.css'
})
export class MovieEditComponent implements OnInit{
  uuid: string | undefined;

  movie: MovieEdit | undefined;

  original: MovieEdit | undefined;

  studios: Studios | undefined;

  constructor(
      private movieService: MovieService,
      private studioService: StudioService,
      private route: ActivatedRoute,
      private router: Router
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.studioService.getStudios()
          .subscribe(studios => this.studios = studios);

      this.movieService.getMovie(params['movieId'])
          .subscribe(movie => {
            this.uuid = movie.id
            this.movie = {
              title: movie.title,
              director: movie.director,
              publisher: movie.publisher,
              yearOfPublication: movie.yearOfPublication,
              studio: movie.studio.id
            };
            this.original = {...this.movie};
          });
    });

  }

  onSubmit(): void {
    this.movieService.patchMovie(this.uuid!, this.movie!)
        .subscribe(() => this.router.navigate(['/studios', this.movie!.studio]));
  }
}
