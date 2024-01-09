import {Component, OnInit} from '@angular/core';
import {StudioDetails} from "../../../studio/model/studio-details";
import {StudioService} from "../../../studio/service/studio.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Movie} from "../../model/movie";
import {MovieDetails} from "../../model/model-details";
import {MovieService} from "../../service/movie-service";

@Component({
  selector: 'app-movie-view',
  templateUrl: './movie-view.component.html',
  styleUrl: './movie-view.component.css'
})
export class MovieViewComponent implements OnInit{
  movie: MovieDetails | undefined;

  constructor(private service: MovieService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getMovie(params['movieId'])
          .subscribe(movie => this.movie = movie)
    });
  }

}
