import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Huong} from "../../model/huong";

@Injectable({
  providedIn: 'root'
})
export class HuongService {
  private API_URL = 'http://localhost:3000/huong'

  constructor(private _httpClient: HttpClient) { }

  getAllHuong(): Observable<Huong[]> {
    return this._httpClient.get<Huong[]>(this.API_URL);
  }
}
