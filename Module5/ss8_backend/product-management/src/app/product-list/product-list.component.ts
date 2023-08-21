import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {error} from '@angular/compiler/src/util';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  private subcription: Subscription;
  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.subcription = this.productService.getAll().subscribe(
      data => {
        this.products = data;
        // tslint:disable-next-line:no-shadowed-variable
      }, error => {
          console.log('Lấy thông tin sản phẩm thất bại!');
      }
    );
  }
}
