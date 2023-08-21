import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private API_URL = 'http://localhost:3000/products';
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API_URL);
  }

  saveProduct(product): Observable<Product> {
    // this.products.push(product);
    return this.httpClient.post<Product>(this.API_URL + '/product', product);
  }

  findById(id: number): Observable<Product> {
    // return this.products.find(product => product.id === id);
    return this.httpClient.get<Product>(`${this.API_URL}/product/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    // for (let i = 0; i < this.products.length; i++) {
    //   if (this.products[i].id === id) {
    //     this.products[i] = product;
    //   }
    // }
    return this.httpClient.put<Product>(`${this.API_URL}/product/${id}`, product);
  }

  deleteProduct(id: number): Observable<Product> {
    // this.products = this.products.filter(product => {
    //   return product.id !== id;
    // });
    return this.httpClient.delete<Product>(`${this.API_URL}/product/${id}`);
  }
}
