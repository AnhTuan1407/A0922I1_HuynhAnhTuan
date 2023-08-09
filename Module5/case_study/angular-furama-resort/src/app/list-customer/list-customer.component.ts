import { Component, OnInit } from '@angular/core';
import {Customer} from './customer';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  constructor() { }

  customers: Customer[] = [
    {
      customerId: 'G2355',
      customerName: 'Andrew',
      customerBirthDay: '04/02/2002',
      customerIdentityCard: '012345678901',
      customerPhone: '+84123456789',
      customerEmail: 'nguyenvana@example.com',
      customerType: 'Gold',
      customerDayCreate: '21 Sep, 2021',
      customerNationality: 'VietNam'
    },
    {
      customerId: 'P3468',
      customerName: 'Bella',
      customerBirthDay: '01/02/2004',
      customerIdentityCard: '012345678903',
      customerPhone: '+84123456715',
      customerEmail: 'nguyenvanb@example.com',
      customerType: 'Platinum',
      customerDayCreate: '21 Sep, 2021',
      customerNationality: 'Mexico'
    },
    {
      customerId: 'S1486',
      customerName: 'Coronel',
      customerBirthDay: '17/10/2003',
      customerIdentityCard: '012345678904',
      customerPhone: '+84123456722',
      customerEmail: 'nguyenvanc@example.com',
      customerType: 'Silver',
      customerDayCreate: '21 Sep, 2021',
      customerNationality: 'Mexico'
    },
    {
      customerId: 'D0574',
      customerName: 'D',
      customerBirthDay: '31/08/2003',
      customerIdentityCard: '012345678905',
      customerPhone: '+84123456744',
      customerEmail: 'nguyenvand@example.com',
      customerType: 'Diamond',
      customerDayCreate: '21 Sep, 2021',
      customerNationality: 'Mexico'
    },
  ]

  ngOnInit(): void {
  }
}
