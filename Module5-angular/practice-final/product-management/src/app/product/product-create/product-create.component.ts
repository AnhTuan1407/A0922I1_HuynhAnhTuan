import {Component, OnInit} from '@angular/core';
import {ProductService} from "../product.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    idProduct: new FormControl(),
    nameProduct: new FormControl(),
    category: new FormControl(),
    quantity: new FormControl(),
    dateRelease: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  })

  constructor(private _productService: ProductService, private _router: Router) {
  }

  ngOnInit(): void {
  }

  submit() {
    const product = this.productForm.value;
    this._productService.createNewProduct(product).subscribe(
      () => {
        this.productForm.reset();
        this._router.navigate(['/product/list']);
        alert('Thêm mới thành công');
      }, error => {
        alert('Lỗi');
      }
    )
  }
}
