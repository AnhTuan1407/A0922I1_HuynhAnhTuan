import {Injectable} from '@angular/core';
import {Student} from './student/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private students: Student[] = [
    {
      name: 'Huynh Anh Tuan',
      gender: 1,
      className: 'A0922I1',
      point: 96,
      phone: '0369705323',
      address: 'Quang Nam'
    },
    {
      name: 'Vu Phuc Thang',
      gender: 1,
      className: 'A0922I1',
      point: 69,
      phone: '0934797799',
      address: 'Da Nang'
    },
    {
      name: 'Tran Huu Loi',
      gender: 1,
      className: 'A0922I1',
      point: 96,
      phone: '0328710340',
      address: 'Quang Nam'
    },
    {
      name: 'Nguyen Thu Ha Nhi',
      gender: 0,
      className: 'A0922I1',
      point: 96,
      phone: '0834088540',
      address: 'Quang Nam'
    },
    {
      name: 'Nguyen Phuong Hoai Nam',
      gender: 0,
      className: 'A0922I1',
      point: 96,
      phone: '0912832391',
      address: 'Quang Binh'
    }
  ];

  constructor() {
  }

  findAll(): Student[] {
    return this.students;
  }

  save(student: Student): void {
    this.students.unshift(student);
  }
}
