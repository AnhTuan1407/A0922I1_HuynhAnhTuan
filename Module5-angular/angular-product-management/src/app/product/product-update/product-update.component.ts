import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../model/category";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productForm: FormGroup;
  product: Product;
  categories: Category[];
  id: number;

  constructor(private _productService: ProductService, private _router: Router, private _activatedRoute: ActivatedRoute, private _categoryService: CategoryService) {
    this._activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.id = +param.get('id');
      this.getProduct(this.id);
    })
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

  private getProduct(id: number) {
    this._productService.findProduct(this.id).subscribe(
      product => {
        this.product = product;
        this.productForm = new FormGroup({
          id: new FormControl(this.product.id),
          nameProduct: new FormControl(this.product.nameProduct),
          category: new FormControl(this.product.category),
          quantity: new FormControl(this.product.quantity),
          dateRelease: new FormControl(this.product.dateRelease),
          price: new FormControl(this.product.price),
          description: new FormControl(this.product.description),
        })
        console.log('Complete');
      }, error => {
        console.log('Error');
      }
    )
  }


  updateProduct(id: number) {
    const productUpdate = this.productForm.value;
    this._productService.update(id, productUpdate).subscribe(
      () => {
        console.log('Complete Update');
        this.productForm.reset();
        this._router.navigate(['/product/list']);
        alert('Complete');
      }, error => {
        console.log('Error');
      }
    )
  }

  compareWithId(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }
}


