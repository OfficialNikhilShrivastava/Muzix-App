import { Component, Input, OnInit } from '@angular/core';
import { MovieService } from '../service/movie.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {
  
  @Input() movies:any;
  constructor(private movieS: MovieService) { }

  ngOnInit(): void {
  }
  movieDetails(movie:any){
    console.log(movie);
    this.movieS.selectedMovie(movie);
  }
}
