import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {StudioForm} from "../../studio/model/studio-form";
import {MovieForm} from "../model/movie-form";
import {Movie} from "../model/movie";
import {MovieEdit} from "../model/movie-edit";

@Injectable()
export class MovieService {

    constructor(private http: HttpClient) {

    }

    putMovie(uuid: string, request: MovieForm): Observable<any> {
        return this.http.put('/api/movies/' + uuid, request);
    }

    getMovie(uuid: string): Observable<any> {
        return this.http.get('/api/movies/' + uuid);
    }

    patchMovie(uuid: string, request: MovieEdit): Observable<any> {
        return this.http.patch('/api/movies/' + uuid, request);
    }
}
