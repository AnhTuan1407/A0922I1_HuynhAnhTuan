import {Component, OnInit} from '@angular/core';
import {ProductService} from "../product.service";
import {Product} from "../../module/product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  productList: Product[] = [];

  constructor(private _productService: ProductService) {
  }

  ngOnInit(): void {
    this._productService.getAllProducts().subscribe(
      products => {
        this.productList = products;
        console.log('Lấy dữ liệu sản phẩm thành công!');
      }, error => {
        console.log('Lấy dữ liệu sản phẩm thất bại!');
      }
    )
  }

}
