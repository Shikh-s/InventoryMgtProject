import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddProductComponent} from './add-product/add-product.component';
import {ProductListComponent} from './product-list/product-list.component';
import { UpdateProductComponent } from './update-product/update-product.component';

const routes: Routes = [
  {path:"",redirectTo:"/viewAllProducts",pathMatch:"full"},
  {path:"addProduct",component:AddProductComponent},
  {path:"viewAllProducts",component:ProductListComponent},
  {path:"updateProduct",component:UpdateProductComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
