import {Component, OnInit} from '@angular/core';
import {Student} from './student';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students: Student[] = [];

  studentDetail: Student | undefined;

  // tslint:disable-next-line:variable-name
  constructor(private _studentService: StudentService) {
  }

  ngOnInit(): void {
    this.students = this._studentService.findAll();
  }

  showDetail(item: Student) {
    this.studentDetail = item;
  }

  getNewStudent(value: Student) {
    this.students.unshift(value);
  }
}
