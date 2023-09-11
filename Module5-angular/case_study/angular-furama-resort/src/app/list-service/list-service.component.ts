import {Component, OnInit} from '@angular/core';
// @ts-ignore
import {Service} from './facility';

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {

  constructor() {
  }

  services: Service[] = [
    {
      serviceName: 'Double Room',
      serviceArea: 2000,
      serviceFloor: 4,
      serviceCapacity: 4,
      serviceCost: 2000,
      serviceRentType: 'Month',
      serviceStatus: 'USE'
    },
    {
      serviceName: 'Villa',
      serviceArea: 4000,
      serviceFloor: 1,
      serviceCapacity: 8,
      serviceCost: 12000,
      serviceRentType: 'Year',
      serviceStatus: 'NOT USE'
    },
    {
      serviceName: 'Single Room',
      serviceArea: 1000,
      serviceFloor: 5,
      serviceCapacity: 2,
      serviceCost: 500,
      serviceRentType: 'Day',
      serviceStatus: 'USE'
    },
    {
      serviceName: 'Presidential House',
      serviceArea: 5000,
      serviceFloor: 2,
      serviceCapacity: 3,
      serviceCost: 3500,
      serviceRentType: 'Hour',
      serviceStatus: 'NOT USE'
    }
  ];

  ngOnInit(): void {
  }
}
