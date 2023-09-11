import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Huong} from "../model/huong";
import {VungMien} from "../model/vung-mien";

@Injectable({
  providedIn: 'root'
})
export class VungMienService {
  private API_URL = 'http://localhost:3000/vungMien'

  constructor(private _httpClient: HttpClient) { }

  getAllVungMien(): Observable<VungMien[]> {
    return this._httpClient.get<VungMien[]>(this.API_URL);
  }
}
