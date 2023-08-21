import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductComponent} from "./product/product.component";
import {DetailProductComponent} from "./detail-product/detail-product.component";
import {CreateProductComponent} from "./create-product/create-product.component";
import {UpdateProductComponent} from "./update-product/update-product.component";
import {DeleteProductComponent} from "./delete-product/delete-product.component";


const routes: Routes = [
  {path: 'product', component: ProductComponent},
  {path: 'product/detail/:id', component: DetailProductComponent},
  {path: 'product/create', component: CreateProductComponent},
  {path: 'product/update/:id', component: UpdateProductComponent},
  {path: 'product/delete/:id', component: DeleteProductComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
