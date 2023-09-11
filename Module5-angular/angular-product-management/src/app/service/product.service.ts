import { Injectable } from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private API_URL = 'http://localhost:3000/products';
  constructor(private _httpClient: HttpClient) { }

  getAllProduct(): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL);
  }

  findProduct(id: number): Observable<Product> {
    return this._httpClient.get<Product>(`${this.API_URL}/${id}`);
  }

  save(product): Observable<Product> {
    return this._httpClient.post<Product>(this.API_URL, product);
  }

  update(id: number, product): Observable<Product> {
    return this._httpClient.put<Product>(this.API_URL + '/' + id, product);
  }

  delete(id: number): Observable<Product> {
    return this._httpClient.delete<Product>(this.API_URL + '/' + id);
  }

  search(input: string): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL + '?nameProduct_like=' + input);
  }


}
