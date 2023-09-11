import {Component, OnInit} from '@angular/core';
import {Student} from "../student";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  studentDetail: Student | undefined;

  students: Student[] = [
    {name: 'Nguyen Van A', gender: 1, point: 100},
    {name: 'Nguyen Van B', gender: 0, point: 75},
    {name: 'Nguyen Van C', gender: 2, point: 69},
    {name: 'Nguyen Van D', gender: 1, point: 45},
  ]

  showDetail(item: Student) {
    this.studentDetail = item;
  }

  getNewStudent(student: Student) {
    this.students.unshift(student);
  }
}
