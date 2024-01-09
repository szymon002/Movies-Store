import {Component, OnInit} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MovieForm} from "../../model/movie-form";
import {StudioService} from "../../../studio/service/studio.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MovieService} from "../../service/movie-service";

@Component({
  selector: 'app-movie-create',
  templateUrl: './movie-create.component.html',
  styleUrl: './movie-create.component.css'
})
export class MovieCreateComponent implements OnInit{
    movie: MovieForm = {
        title: '',
        director: '',
        yearOfPublication: 0,
        publisher: '',
        studio: ''
    };

    uuid: string = 'f5875513-bf7b-4ae1-b8a5-5b70a1b90e33';

    constructor(
        private movieService: MovieService,
        private route: ActivatedRoute,
        private router: Router
    ) {
    }

    onSubmit(): void {
        this.movieService.putMovie(this.uuid!, this.movie!)
            .subscribe(() => this.router.navigate(['/studios', this.movie.studio]));
    }

    ngOnInit(): void {
        this.route.params.subscribe(params => {
            this.movie.studio = params['uuid']
        });
    }
}
