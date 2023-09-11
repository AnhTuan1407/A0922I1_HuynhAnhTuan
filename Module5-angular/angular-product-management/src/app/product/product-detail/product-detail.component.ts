import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  product: Product;
  id: number;

  constructor(private _productService: ProductService, private _activatedRoute: ActivatedRoute, private _router: Router) {
    this._activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    })
  }

  ngOnInit(): void {
  }

  getProduct(id: number) {
    return this._productService.findProduct(id).subscribe(product => {
      this.product = product;
      console.log(product);
    }, error => {
      console.log('Error');
    })
  }

  // getProduct(id: number) {
  //   return this._productService.findProduct(id).subscribe(product => {
  //     this.productForm = new FormGroup({
  //       idProduct: new FormControl(product.idProduct),
  //       nameProduct: new FormControl(product.nameProduct),
  //       quantity: new FormControl(product.quantity),
  //       dateRelease: new FormControl(product.dateRelease),
  //       price: new FormControl(product.price),
  //       description: new FormControl(product.description),
  //     });
  //   });
  // }
}
