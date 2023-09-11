import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private API_URL = 'http://localhost:3000/categories'

  constructor(private _httpClient: HttpClient) { }

  getAllCategories(): Observable<Category[]> {
    return this._httpClient.get<Category[]>(this.API_URL);
  }
}
