import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Studios } from "../model/studios";
import { StudioDetails } from "../model/studio-details";
import { StudioForm} from "../model/studio-form";

@Injectable()
export class StudioService {

  constructor(private http: HttpClient) {

  }

  getStudios(): Observable<Studios> {
    return this.http.get<Studios>('/api/studios');
  }

  getStudio(uuid: string): Observable<any> {
    return this.http.get<StudioDetails>('/api/studios/' + uuid)
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

}
