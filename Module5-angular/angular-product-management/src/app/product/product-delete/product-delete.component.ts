import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  id: number;
  productForm: FormGroup;
  product: Product;
  displayStyle = 'none';

  constructor(private _productService: ProductService, private _activatedRoute: ActivatedRoute, private _router: Router) {
    this._activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.id = +param.get('id');
      this.getProduct(this.id);
    })
  }

  ngOnInit(): void {
  }

  private getProduct(id: number) {
    this._productService.findProduct(id).subscribe(product => {
      this.product = product;

      this.productForm = new FormGroup({
        id: new FormControl(this.product.id),
        nameProduct: new FormControl(this.product.nameProduct),
        quantity: new FormControl(this.product.quantity),
        dateRelease: new FormControl(this.product.dateRelease),
        price: new FormControl(this.product.price),
        description: new FormControl(this.product.description),
      })
      console.log('Complete');
    }, error => {
      console.log('Error');
    })
  }

  deleteProduct(id: number) {
    this._productService.delete(id).subscribe(
      () => {
        console.log('Complete Delete');
        window.location.reload();
        alert('Complete');
      }, error => {
        console.log('Error');
      }
    )
  }

  openPopup() {
    this.displayStyle = 'block';
  }

  closePopup() {
    // this.displayStyle = 'none';
    this._productService.delete(this.id).subscribe(() => {
      this._router.navigate(['/product/list']);
    });
  }
}
