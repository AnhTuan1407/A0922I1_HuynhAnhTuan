import {Injectable} from '@angular/core';
import {Product} from "./product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Product[] = [
    {
      id: 1,
      name: 'IPhone 12',
      category: 'Phone',
      quantity: 1,
      dateRelease: "18/08/2023",
      price: 2400000,
      description: 'New'
    },
    {
      id: 2,
      name: 'IPhone 11',
      category: 'Phone',
      quantity: 1,
      dateRelease: "18/08/2023",
      price: 1560000,
      description: 'Like new'
    },
    {
      id: 3,
      name: 'IPhone X',
      category: 'Phone',
      quantity: 1,
      dateRelease: "18/08/2023",
      price: 968000,
      description: '97%'
    },
    {
      id: 4,
      name: 'IPhone 8',
      category: 'Phone',
      quantity: 1,
      dateRelease: "18/08/2023",
      price: 7540000,
      description: '98%'
    },
    {
      id: 5,
      name: 'IPhone 11 Pro',
      category: 'Phone',
      quantity: 1,
      dateRelease: "18/08/2023",
      price: 1895000,
      description: 'Like new'
    }
  ]


  constructor() {
  }

  getProduct(): Product[] {
    return this.products;
  }

  findById(id: number): Product{
    return this.products.find(obj => obj.id === id);
  }

}
