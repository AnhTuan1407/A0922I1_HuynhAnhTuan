import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../model/category";
import Swal from "sweetalert2";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categories: Category[];

  productForm: FormGroup = new FormGroup({
    nameProduct: new FormControl('', [Validators.required, Validators.minLength(9)]),
    category: new FormControl('', [Validators.required]),
    quantity: new FormControl('', [Validators.required]),
    dateRelease: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
  });

  constructor(private _productService: ProductService, private _router: Router, private _categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this._categoryService.getAllCategories().subscribe(
      categories => {
        this.categories = categories;
        console.log('Complete');
      }, error => {
        console.log('Error');
      }
    )
  }

  submit() {
    const product = this.productForm.value;
    console.log(product);
    this._productService.save(product).subscribe(() => {
        this.productForm.reset();
        this._router.navigate(['/product/list']);
        Swal.fire('Thành công');
      }, error => {
        console.log('Error');
        alert('Error');
        console.log(product);
      }
    )
  }
}
