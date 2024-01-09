import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Studios } from "../model/studios";
import { StudioEditForm } from "../model/studio-edit-form";
import { StudioForm} from "../model/studio-form";
import {Movies} from "../../movie/model/movies";

@Injectable()
export class StudioService {

  constructor(private http: HttpClient) {

  }

  getStudios(): Observable<Studios> {
    return this.http.get<Studios>('/api/studios');
  }

  getStudio(uuid: string): Observable<any> {
    return this.http.get<StudioEditForm>('/api/studios/' + uuid)
  }

  getMovies(uuid: string): Observable<any> {
    return this.http.get<Movies>('/api/studios/' + uuid + '/movies')
  }

  deleteStudio(uuid: string): Observable<any> {
    return this.http.delete('/api/studios/' + uuid);
  }

  putStudio(uuid: string, request: StudioForm): Observable<any> {
    return this.http.put('/api/studios/' + uuid, request);
  }

  patchStudio(uuid: string, request: StudioForm): Observable<any> {
    return this.http.patch('/api/studios/' + uuid, request);
  }

  deleteMovie(uuid: string): Observable<any> {
    return this.http.delete('/api/movies/' + uuid);
  }
}
