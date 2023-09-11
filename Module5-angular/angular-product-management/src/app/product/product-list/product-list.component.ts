import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  productList: Product[] = [];
  displayStyle = 'none';
  idProduct: number;
  p = 1;
  product: Product;

  constructor(private _productService: ProductService, private _router: Router) {
  }

  private Swal: any;
  private msg: boolean;

  ngOnInit(): void {
    this._productService.getAllProduct().subscribe(
      products => {
        this.productList = products;
        console.log('Complete');
      }, error => {
        console.log('Error');
      }
    )
  }

  search(inputSearch: HTMLInputElement) {
    this._productService.search(inputSearch.value).subscribe(next => {
      this.productList = next;
      if (this.productList.length === 0) {
        this.msg = true;
      } else {
        this.msg = false;
      }
    });
  }

  openPopup(id: number) {
    this.displayStyle = 'block';
    this.idProduct = id;
  }

  closePopup() {
    this.displayStyle = 'none';
  }

  deleteProduct(id: number) {
    this._productService.delete(id).subscribe(() => {
      console.log(this.idProduct);
      window.location.reload();
    }, error => {
      console.log(this.idProduct);
    });
  }

  getProduct(id: number) {
    this._productService.findProduct(id).subscribe(data => {
      this.product = data;
    });
  }
}
