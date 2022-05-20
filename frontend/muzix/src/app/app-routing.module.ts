import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { AuthGuard } from './guard/auth.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MovieInfoComponent } from './movie-info/movie-info.component';
import { RecommedationComponent } from './recommedation/recommedation.component';
import { RegisterComponent } from './register/register.component';
import { SearchItemsComponent } from './search-items/search-items.component';
import { SidebarComponent } from './sidebar/sidebar.component';

const routes: Routes = [
  {
    path: "auth",
    component: SidebarComponent,
    children: [
      {
        path: "login",
        component: LoginComponent
      },
      {
        path: "register",
        component: RegisterComponent
      }
    ]
  },
  {
    path: "dashboard",
    component: DashboardComponent,
    children: [
      {
        path: "home",
        component: HomeComponent
      },
      {
        path: "search-items/:text",
        component: SearchItemsComponent
      },
      {
        path: "recommended",
        canActivate: [AuthGuard],
        component: RecommedationComponent
      },
      {
        path: "movie-info",
        canActivate: [AuthGuard],
        component: MovieInfoComponent
      },
      {
        path: "favourite",
        canActivate: [AuthGuard],
        component: FavouriteComponent
      }
    ]
  },
  {
    path: "",
    redirectTo: "dashboard/home",
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
