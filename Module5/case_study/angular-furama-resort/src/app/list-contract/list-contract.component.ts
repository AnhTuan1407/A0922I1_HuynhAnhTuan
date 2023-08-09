import { Component, OnInit } from '@angular/core';
import {Contract} from './contract';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {

  constructor() { }

  contracts: Contract[] = [
    {
      customerName: 'Nguyễn Thị Yến',
      serviceName: 'Room',
      contractDayStart: '04/02/2002',
      contractDayEnd: '04/12/2002',
      contractDeposit: 2.000,
      contractTotalCost: 4.000
    },
    {
      customerName: 'Nguyễn Phan Anh',
      serviceName: 'Villa',
      contractDayStart: '01/02/2004',
      contractDayEnd: '01/12/2004',
      contractDeposit: 4.000,
      contractTotalCost: 16.000
    },
    {
      customerName: 'Trần Thị Mỹ',
      serviceName: 'House',
      contractDayStart: '17/10/2003',
      contractDayEnd: '17/10/2004',
      contractDeposit: 6.000,
      contractTotalCost: 24.000
    },
    {
      customerName: 'Phạm Thị Ngọc',
      serviceName: 'Villa',
      contractDayStart: '31/08/2003',
      contractDayEnd: '31/08/2004',
      contractDeposit: 8.000,
      contractTotalCost: 32.000
    },
  ];

  ngOnInit(): void {
  }
}
