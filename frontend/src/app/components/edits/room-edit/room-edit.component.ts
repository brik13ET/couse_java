import { Component, EventEmitter, OnInit, Output, output } from '@angular/core';
import { Room } from '../../../model/Room';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { RoomService } from '../../../service/room.service';
import { SensorListComponent } from '../../lists/sensor-list/sensor-list.component';
import { Observable } from 'rxjs';
import { Sensor } from '../../../model/Sensor';
import { BuildingService } from '../../../service/building.service';
import { AsyncPipe } from '@angular/common';
import { Building } from '../../../model/Building';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-room-edit',
  templateUrl: './room-edit.component.html',
  styleUrl: './room-edit.component.css',
  standalone: true,
  imports: [SensorListComponent,AsyncPipe,RouterLink,FormsModule,SensorListComponent]
})
export class RoomEditComponent implements OnInit {
  room: Room = {} as Room;
  isCreating: boolean = true;
  buildings!: Observable<Building[]>;
  sensors!: Observable<Sensor[]>;
  @Output() upd = new EventEmitter();

  constructor(
    private route: ActivatedRoute,
    private service: RoomService,
    private buildingService: BuildingService
  ) { }

  ngOnInit(): void {
    this.isCreating = true;
    this.route.params.subscribe( params => {
      this.buildings = this.buildingService.getAll();
      if (params["id"] && params['id'] != 'all' && params['id'] != 'new')
        this.service.getById(Number(params["id"]))
          .subscribe({
            next:   recv => {
                this.room = recv;
                this.sensors = this.service.getSensorsById(this.room.id);
                this.isCreating = false;
            },
            error:  console.log
        });
    });

  }

  getSensors()
  {
    return this.sensors;
  }

  getBuildings()
  {
    return this.buildings;
  }

  
  submit() {
    if (this.isCreating)
      this.service.create(this.room).subscribe(() => this.upd.emit());
    else
      this.service.update(this.room).subscribe(() => this.upd.emit());
  }
}
