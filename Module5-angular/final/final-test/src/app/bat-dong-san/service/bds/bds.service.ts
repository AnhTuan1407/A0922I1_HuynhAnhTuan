import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Bds} from "../../model/bds";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BdsService {
  private API_URL = 'http://localhost:3000/bds';
  constructor(private _httpClient: HttpClient) { }

  getAllBds(): Observable<Bds[]> {
    return this._httpClient.get<Bds[]>(this.API_URL);
  }

  findById(id: number): Observable<Bds> {
    return this._httpClient.get<Bds>(`${this.API_URL}/${id}`);
  }

  save(bds): Observable<Bds> {
    return this._httpClient.post<Bds>(this.API_URL, bds);
  }

  searchPrice(input: string): Observable<Bds[]> {
    return this._httpClient.get<Bds[]>(this.API_URL + '?gia_like=' + input);
  }

  searchHuong(input: string): Observable<Bds[]> {
    return this._httpClient.get<Bds[]>(this.API_URL + '?huong_like=' + input);
  }

  searchArea(input: string): Observable<Bds[]> {
    return this._httpClient.get<Bds[]>(this.API_URL + '?dienTich_like=' + input);
  }

  searchAll(value: string, value2: string) {
    return this._httpClient.get<Bds[]>(this.API_URL + '?dienTich_like=' + value + '&gia_like=' + value2);
  }
}
