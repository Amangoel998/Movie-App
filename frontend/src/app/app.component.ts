import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddComponent } from './add/add.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Movie App';
  constructor(public dialog: MatDialog){
  }
  addDialog(){
    this.dialog.open(AddComponent, {
      width: '300px',
      height: '400px',
    });
  }
}
