import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Building } from '../../../model/Building';
import { BuildingService } from '../../../service/building.service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { RoomListComponent } from '../../lists/room-list/room-list.component';
import { AsyncPipe, NgIf } from '@angular/common';
import { EMPTY, Observable } from 'rxjs';
import { Room } from '../../../model/Room';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-building-edit',
  templateUrl: './building-edit.component.html',
  styleUrl: './building-edit.component.css',
  standalone: true,
  imports: [RoomListComponent, AsyncPipe, RouterLink, FormsModule]
})
export class BuildingEditComponent implements OnInit{
  public building: Building = {} as Building;
  public isCreate: boolean = true;
  public room$!: Observable<Room[]>;

  @Output() changed = new EventEmitter();
  
  constructor(
    private route: ActivatedRoute,
    private service: BuildingService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe( params => {
      // console.log(params);
      if (params["id"] && params["id"] != 'all')
        this.service.getById(params["id"])
          .subscribe({
            next:   recv => {
              this.room$ = this.service.getRooms(recv.id);
              this.isCreate = false;
              return this.building = recv;
            },
            error:  console.log
        });
      else
      {
        this.isCreate = true;
        this.building = {} as Building;
        this.room$ = EMPTY;
      }
      
    });
  }

  getRooms()
  {
    return this.room$
  }

  submit() {
    if (this.isCreate)
      this.service.create(this.building).subscribe(() => this.changed.emit());
    else
      this.service.update(this.building).subscribe(() => this.changed.emit());
  }
    
}
