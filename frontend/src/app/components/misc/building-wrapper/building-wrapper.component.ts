import { AfterViewChecked, Component, OnInit } from '@angular/core';
import { BuildingListComponent } from '../../lists/building-list/building-list.component';
import { BuildingEditComponent } from '../../edits/building-edit/building-edit.component';
import { LoadingBlurComponent } from '../loading-blur/loading-blur.component';

@Component({
  selector: 'app-building-wrapper',
  standalone: true,
  imports: [BuildingEditComponent, BuildingListComponent],
  template: `
        <div class="row">
            <div class="col-4 px-3 h-100">
              <app-building-list #bar ></app-building-list>
            </div>
            <div class="col-8 px-3 h-100">
              <app-building-edit (changed)="bar.update()"></app-building-edit>
            </div>
        </div>
  `,
  styles: `
    :host .row div
    {
      overflow-y: auto;
      height: 100%;
      max-height: calc( 100vh - 4rem);
    }
  `
})
export class BuildingWrapperComponent implements OnInit, AfterViewChecked{

  ngOnInit(): void {
    LoadingBlurComponent.loading = true;
  }
  ngAfterViewChecked(): void {
    LoadingBlurComponent.loading = false;
  }

}
