import { Component } from '@angular/core';
import { SensorEditComponent } from '../../edits/sensor-edit/sensor-edit.component';
import { SensorListComponent } from '../../lists/sensor-list/sensor-list.component';

@Component({
  selector: 'app-sensor-wrapper',
  standalone: true,
  imports: [SensorEditComponent, SensorListComponent],
  template: `
        <div class="row">
            <div class="col-3 px-3" style="overflow-y: auto; height: 100%; max-height: calc( 100vh - 4rem)">
              <app-sensor-list></app-sensor-list>
            </div>
            <div class="col-9 px-3">
              <app-sensor-edit></app-sensor-edit>
            </div>
        </div>
  `,
  styles: ``
})
export class SensorWrapperComponent {

}
