import {Component, Input, OnInit} from '@angular/core';
import {Student} from "../student";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input('student') studentDetail: Student;
}
