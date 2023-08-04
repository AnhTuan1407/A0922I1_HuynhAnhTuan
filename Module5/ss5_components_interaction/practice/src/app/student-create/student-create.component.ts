import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../student";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Output() newStudent = new EventEmitter<Student>();

  student: Student | undefined;

  create(name: string, gender: string, point: string) {
      this.student = {name: name, gender: +gender, point: +point}
  }

}
