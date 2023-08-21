import {Component, OnInit} from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../product.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[];

  constructor(private _productService: ProductService, private _router: Router, private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.products = this._productService.getProduct();
  }
}
