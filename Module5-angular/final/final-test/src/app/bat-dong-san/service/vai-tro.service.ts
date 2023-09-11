import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {VungMien} from "../model/vung-mien";
import {VaiTro} from "../model/vai-tro";

@Injectable({
  providedIn: 'root'
})
export class VaiTroService {
  private API_URL = 'http://localhost:3000/vaiTro'

  constructor(private _httpClient: HttpClient) { }

  getAllVaiTro(): Observable<VaiTro[]> {
    return this._httpClient.get<VaiTro[]>(this.API_URL);
  }
}
