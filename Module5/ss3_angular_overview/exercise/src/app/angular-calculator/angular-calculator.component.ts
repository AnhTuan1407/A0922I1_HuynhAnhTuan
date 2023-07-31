import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-angular-calculator',
  templateUrl: './angular-calculator.component.html',
  styleUrls: ['./angular-calculator.component.css']
})
export class AngularCalculatorComponent implements OnInit {
  firstNumber = 0;
  secondNumber = 0;
  result: any;


  constructor() {
  }

  ngOnInit(): void {
  }

  calculation(option: string): any {
    switch (option) {
      case 'add':
        return this.result = Number(this.firstNumber) + Number(this.secondNumber);
        break;
      case 'sub':
        return this.result = Number(this.firstNumber) - Number(this.secondNumber);
        break;
      case 'mul':
        return this.result = Number(this.firstNumber) * Number(this.secondNumber);
        break;
      case 'div':
        if (this.secondNumber === 0) {
          return this.result = 'Không thể chia cho 0';
        }
        return this.result = Number(this.firstNumber) / Number(this.secondNumber);
        break;
    }
  }
}
