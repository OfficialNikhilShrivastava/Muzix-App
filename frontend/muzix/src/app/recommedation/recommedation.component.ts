import { Component, OnInit } from '@angular/core';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-recommedation',
  templateUrl: './recommedation.component.html',
  styleUrls: ['./recommedation.component.css']
})
export class RecommedationComponent implements OnInit {
  titleMovie: string | undefined;
  recommendedMovies: any;
  allRecommendedMovies: any;
  constructor(private service: MovieService) {
    this.titleMovie = this.service.movieName;
  }
  ngOnInit(): void {
    this.service.getAllRecommendedMovies(this.service.recommendedMovieId).subscribe(res => {
      this.recommendedMovies = res;
      this.allRecommendedMovies = this.recommendedMovies.results;
      console.log("this is the recommended movies");
      console.log(this.allRecommendedMovies);
    });
  }
  movieDetails(data: any) {
    this.service.selectedMovie(data);
  }

}
