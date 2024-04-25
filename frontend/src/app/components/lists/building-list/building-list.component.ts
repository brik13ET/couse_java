import { Component } from '@angular/core';
import { Building } from '../../../model/Building';
import { BuildingService } from '../../../service/building.service';
import { Observable, forkJoin } from 'rxjs';
import { BuildingCardComponent } from '../../cards/building-card/building-card.component';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NgFor } from '@angular/common';
import { LoadingBlurComponent } from '../../misc/loading-blur/loading-blur.component';

@Component({
  selector: 'app-building-list',
  templateUrl: './building-list.component.html',
  styleUrl: './building-list.component.css',
  standalone: true,
  imports: [BuildingCardComponent, RouterLink, RouterOutlet, NgFor]
})
export class BuildingListComponent {
  buildings: [b: Building, rooms: number][] = [];

  constructor(
    private service: BuildingService
  )
  {
    this.update();
  }

  update()
  {
    forkJoin({
      builds: this.service.getAll(),
      cnts: this.service.getRoomsCount()
    }).subscribe({
      next: b => this.buildings = b.builds.map( bld => [bld, b.cnts[bld.id]]),
      error: console.log
    });
  }
}
