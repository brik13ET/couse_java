import { Component, Input, OnInit, input } from '@angular/core';
import { Room } from '../../../model/Room';
import { RoomService } from '../../../service/room.service';
import { Observable } from 'rxjs';
import { AsyncPipe, NgFor } from '@angular/common';
import { ActivatedRoute, RouterLink, RouterModule } from '@angular/router';
import { RoomCardComponent } from '../../cards/room-card/room-card.component';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrl: './room-list.component.css',
  standalone: true,
  imports: [NgFor, RouterLink, RoomCardComponent, AsyncPipe]
})
export class RoomListComponent{
  @Input() public room: Room[] = [];
  @Input() public filtered: boolean = false; 
  constructor(
    private route: ActivatedRoute,
    private service: RoomService
  )
  { this.update(); }
  
  update(): void {
    if (!this.filtered)
      this.service.getAll().subscribe({
        next: rs => this.room = rs,
        error: console.log
    })
  }
}
