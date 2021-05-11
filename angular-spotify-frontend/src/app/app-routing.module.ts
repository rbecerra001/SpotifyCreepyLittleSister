import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { GenresComponent } from './genres/genres.component';
import { SignupComponent } from './signup/signup.component';
import { LogoutComponent} from './logout/logout.component';
import { GenreComponent } from "./genre/genre.component";

const routes: Routes = [
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'logout',
    component: LogoutComponent
  },
  {
    path: 'genres',
    component: GenresComponent
  },
  {
    path: 'genres/:id',
    component: GenreComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
