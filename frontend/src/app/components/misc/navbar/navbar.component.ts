import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { UserService } from '../../../service/user.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink],
  template: `
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  
    <div class="collapse navbar-collapse" id="navbar">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" routerLink="/building">Здания</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" routerLink="/room">Комнаты</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" routerLink="/sensor/all">Датчики</a>
        </li>
      </ul>
    <div class="my-2 my-lg-0">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
        @if (isLogged()) {
          Выйти
        }
        @else {
          Войти
        }
      </button>
    </div>
    </div>
  </nav>
  `,
  styles: `
  nav {
    top: 0;
    padding: .5rem 3rem;
  }
  `
})
export class NavbarComponent {
  constructor(private service: UserService) { }

  isLogged()
  {
    return this.service.isLoggedIn();
  }
}
