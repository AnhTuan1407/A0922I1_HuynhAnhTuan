import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {VaiTro} from "../model/vai-tro";
import {TinhTrang} from "../model/tinh-trang";

@Injectable({
  providedIn: 'root'
})
export class TinhTrangService {
  private API_URL = 'http://localhost:3000/tinhTrang'

  constructor(private _httpClient: HttpClient) { }

  getAllTinhTrang(): Observable<TinhTrang[]> {
    return this._httpClient.get<TinhTrang[]>(this.API_URL);
  }
}
