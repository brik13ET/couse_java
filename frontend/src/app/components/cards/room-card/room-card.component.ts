import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Room } from '../../../model/Room';
import { RouterLink } from '@angular/router';
import { BuildingService } from '../../../service/building.service';
import { RoomService } from '../../../service/room.service';

@Component({
  selector: 'app-room-card',
  templateUrl: './room-card.component.html',
  styleUrl: './room-card.component.css',
  standalone: true,
  imports: [RouterLink]
})
export class RoomCardComponent {
  @Input() public room!: Room;
  @Output() upd = new EventEmitter();
  constructor(private service: RoomService) { }

  deleteMe() {
    this.service.delete(this.room.id).subscribe(() => this.upd.emit());
  }
}
