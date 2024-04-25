import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-loading-blur',
  standalone: true,
  imports: [],
  template: `
  `,
  styles: `
    :host
    {
      display: none;
      position: fixed;
      width: 100vw;
      height: 100vh;
      top: 0;
      left: 0;
      margin: 0;
      background-color: rgba(255 255 255 / 30% );
      backdrop-filter: blur(10px);
      transition: all .8s ease-in
    }
`
})
export class LoadingBlurComponent {
  private static _loading: boolean;
  public static set loading(val: boolean)
  {
    this._loading = val;
  }

  public static get loading(): boolean
  {
    return this._loading;
  }
}
