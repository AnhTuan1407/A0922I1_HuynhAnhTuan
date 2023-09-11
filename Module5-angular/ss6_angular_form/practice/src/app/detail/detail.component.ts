import {Component, Input, OnInit} from '@angular/core';
import {Student} from '../student/student';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  @Input('inputStudent') student: Student | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
