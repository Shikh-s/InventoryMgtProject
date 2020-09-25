import { Component, OnInit } from '@angular/core';
import {Product} from '../entity/Product';
import {ProductService} from '../service/product.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: any = new Product(0,"","","",0,0,0);
  productId: number;
  message: any;
  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe(data=> {this.products = data},
      error=>{
        if(error.status==503){
          alert("Product List is Empty")
        }
      });
  }
  deleteProduct(productId){
    let confirmation=confirm("Are you sure you want to delete the product?")
    if(confirmation){
    let del= this.productService.deleteProduct(productId);
    del.subscribe((data)=>{
       if(data){
         alert(data)
       }
    })
  }else
   this.router.navigate['viewAllProducts']
  }
  
}
