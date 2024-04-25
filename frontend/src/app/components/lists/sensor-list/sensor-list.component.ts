import { Component, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { Sensor } from '../../../model/Sensor';
import { SensorService } from '../../../service/sensor.service';
import { SensorCardComponent } from '../../cards/sensor-card/sensor-card.component';
import { AsyncPipe, NgFor } from '@angular/common';

@Component({
  selector: 'app-sensor-list',
  templateUrl: './sensor-list.component.html',
  styleUrl: './sensor-list.component.css',
  standalone: true,
  imports: [SensorCardComponent, NgFor, AsyncPipe]
})
export class SensorListComponent {
  @Input() public sensor$!: Observable<Sensor[]>;

  constructor(
    private service: SensorService
  )
  {
    this.sensor$ = service.getAll();
  }
}
