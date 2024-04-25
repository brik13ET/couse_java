import { Component } from '@angular/core';
import { RoomEditComponent } from '../../edits/room-edit/room-edit.component';
import { RoomListComponent } from '../../lists/room-list/room-list.component';

@Component({
  selector: 'app-room-wrapper',
  standalone: true,
  imports: [RoomEditComponent, RoomListComponent],
  template: `
        <div class="row">
            <div class=" col-4 px-3">
            <app-room-list #list></app-room-list>
            </div>
            <div class="col-8 px-3">
            <app-room-edit (upd)="list.update()"></app-room-edit>
            </div>
        </div>
  `,
  styles: `
    :host .row div
    {
      overflow-y: auto;
      height: 100%;
      max-height: calc( 100vh - 4rem)
    }
  `
})
export class RoomWrapperComponent {

}
