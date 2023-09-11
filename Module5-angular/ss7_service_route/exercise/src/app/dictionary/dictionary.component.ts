import { Component, OnInit } from '@angular/core';
import {DictionaryService} from '../dictionary.service';
import {Dictionary} from '../dictionary';

@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {
  words: Dictionary[];

  // tslint:disable-next-line:variable-name
  constructor(private _dictionaryService: DictionaryService) { }

  ngOnInit(): void {
    this.words = this._dictionaryService.getWord();
  }

}
