import { Component, OnInit } from '@angular/core';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  movies: any = []
  allMovies: any = []
  currentPg:number=1;
  constructor(private movieS: MovieService) {
    this.getMovies();
  }

  ngOnInit(): void {
  }
  getMovies() {
    this.movieS.getAllMovies(this.currentPg).subscribe(res => {
      this.movies = res;
      console.log(this.movies);
      this.allMovies = this.movies.results;
      console.log(this.allMovies);
    })
  }
  movieDetails(data: any) {
    console.log(data);
    this.movieS.selectedMovie(data);
  }
  decreasePage(){
    this.currentPg--;
    this.getMovies();
  }
  increasePage(){
    this.currentPg++;
    this.getMovies();
  }

}
