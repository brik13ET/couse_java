import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Sensor } from '../../../model/Sensor';
import { SensorService } from '../../../service/sensor.service';

@Component({
  selector: 'app-sensor-edit',
  templateUrl: './sensor-edit.component.html',
  styleUrl: './sensor-edit.component.css',
  standalone: true
})
export class SensorEditComponent {
  
  sensor!: Sensor;

  constructor(
    private route: ActivatedRoute,
    private service: SensorService
  )
  {
    route.params.subscribe( params => {
      if (params["id"] && params["id"] != 'all')
        service.getById(params["id"])
          .subscribe({
            next:   recv => this.sensor = recv,
            error:  console.log
        });
    });
  }
}
