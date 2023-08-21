import {Component, OnInit} from '@angular/core';
import {Product} from "../product";
import {ProductService} from "../product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit {
  product: Product;
  sub: Subscription;
  id: number;

  constructor(private _productService: ProductService, private _activatedRoute: ActivatedRoute, private _router: Router) {
  }

  ngOnInit(): void {
    // this.sub = this._activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
    //   const productId = Number(paramMap.get('id'));
    //   this.product = this._productService.findById(Number(productId));
    // });

    this._activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.product = this._productService.findById(this.id);
    });
  }
}
