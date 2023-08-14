import {Injectable} from '@angular/core';
import {Dictionary} from './dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words: Dictionary[] = [
    {eng: 'blue', vie: 'because i love u everyday'},
    {eng: 'red', vie: 'Màu đỏ'},
    {eng: 'white', vie: 'Màu trắng'},
    {eng: 'yellow', vie: 'Màu vàng'},
    {eng: 'black', vie: 'Màu đen'},
  ];

  constructor() {
  }

  getWord(): Dictionary[] {
    return this.words;
  }

  findByIWord(eng: string): Dictionary {
    return this.words.find(obj => obj.eng === eng);
  }
}
