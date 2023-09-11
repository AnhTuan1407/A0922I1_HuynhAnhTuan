import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../module/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private API_URL = 'http://localhost:3000/products';

  constructor(private _httpClient: HttpClient) {
  }

  getAllProducts(): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL);
  }

  findProduct(id: number): Observable<Product> {
    return this._httpClient.get<Product>(`${this.API_URL}/${id}`);
  }

  createNewProduct(product): Observable<Product> {
    return this._httpClient.post<Product>(this.API_URL, product);
  }

  updateProduct(id: number, product): Observable<Product> {
    return this._httpClient.put<Product>(`${this.API_URL}/${id}`, product);
  }

  deleteProduct(id: number): Observable<Product> {
    return this._httpClient.delete<Product>(`${this.API_URL}/${id}`);
  }
}
