import { AfterViewChecked, Component, OnChanges, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './components/misc/navbar/navbar.component';
import { LoadingBlurComponent } from './components/misc/loading-blur/loading-blur.component';
import { NgStyle } from '@angular/common';
import { environment } from './environments/environment.development';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, LoadingBlurComponent, NgStyle],
  template: `
    <app-navbar></app-navbar>
    <div class="mx-0 position-relative start-0 bottom-0 " style="overflow-x: hidden">
      <router-outlet></router-outlet>
    </div>
    <app-loading-blur [ngStyle]="{ display: loading ? 'block' : 'none'}"></app-loading-blur>
  `,
  styles: [],
})
export class AppComponent{
  title = 'frontend2';

  
  public get loading(){
    return LoadingBlurComponent.loading;
  }
  
}
