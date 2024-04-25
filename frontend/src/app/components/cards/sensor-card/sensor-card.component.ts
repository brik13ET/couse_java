import { Component, Input } from '@angular/core';
import { Sensor } from '../../../model/Sensor';
import { RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'app-sensor-card',
  templateUrl: './sensor-card.component.html',
  styleUrl: './sensor-card.component.css',
  standalone: true,
  imports: [RouterModule, RouterLink]
})
export class SensorCardComponent {
  @Input() sensor!: Sensor;
}
