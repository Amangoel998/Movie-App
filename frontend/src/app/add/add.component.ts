import { Component, OnInit } from '@angular/core';
import { MoviedataService } from '../moviedata.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Genres } from '../models';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
})
export class AddComponent implements OnInit {
  allgenres = Object.keys(Genres);
  form: FormGroup;
  errormsg: string;
  constructor(private moviedata: MoviedataService,
    private snackBar: MatSnackBar) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl('', [Validators.minLength(2), Validators.required]),
      rating: new FormControl('', [
        Validators.min(0.1),
        Validators.max(10),
        Validators.required,
      ]),
      releasedate: new FormControl('', [Validators.required]),
      genre: new FormControl('', [Validators.required]),
    });
  }
  get name() {
    return this.form.controls['name']
  }
  get rating() {
    return this.form.controls['rating']
  }
  get releasedate() {
    return this.form.controls['releasedate']
  }
  get genre() {
    return this.form.controls['genre']
  }
  openSnackBar(message: string) {
    this.snackBar.open(message, "OK", {
      duration: 20000,
      panelClass: ['dark-snakbar']
    });
  }
  onSubmit() {
    this.errormsg = '';
    if (!this.form.valid) {
      this.openSnackBar("Invalid Form Data")
      throw new Error(this.errormsg);
    }
    const newmovie = {
      movieName: this.form.value.name,
      movieReleasedate: this.form.value.releasedate.toISOString().slice(0,10),
      movieRating: this.form.value.rating,
      movieGenre: Genres[this.form.value.genre],
    };
    var res;
    this.moviedata.addMovie(newmovie).subscribe((e) => res);
  }
}
