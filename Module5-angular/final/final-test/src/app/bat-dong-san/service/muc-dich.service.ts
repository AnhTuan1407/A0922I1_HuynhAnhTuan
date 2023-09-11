import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TinhTrang} from "../model/tinh-trang";
import {MucDich} from "../model/muc-dich";

@Injectable({
  providedIn: 'root'
})
export class MucDichService {
  private API_URL = 'http://localhost:3000/mucDich'

  constructor(private _httpClient: HttpClient) { }

  getAllMucDich(): Observable<MucDich[]> {
    return this._httpClient.get<MucDich[]>(this.API_URL);
  }
}
