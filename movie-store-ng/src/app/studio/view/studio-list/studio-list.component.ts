import {Component, OnInit} from '@angular/core';
import { Studios } from "../../model/studios";
import { Studio } from "../../model/studio";
import { StudioService } from "../../service/studio.service";
@Component({
  selector: 'app-studio-list',
  templateUrl: './studio-list.component.html',
  styleUrl: './studio-list.component.css'
})
export class StudioListComponent implements OnInit{

  constructor(private service: StudioService) {
  }

  studios: Studios | undefined;

  ngOnInit(): void {
    this.service.getStudios().subscribe(studios => this.studios = studios);
  }

  onDelete(studio: Studio): void {
    this.service.deleteStudio(studio.id).subscribe(() => this.ngOnInit());
  }



}
