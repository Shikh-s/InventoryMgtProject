import { Component, OnInit } from '@angular/core';
import { Product } from '../entity/Product';
import { ProductService } from '../service/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  product: Product= new Product(0,"","","",0,0,0);
  message:any;
  constructor(private productService:ProductService,private router:Router) { }
  ngOnInit(): void {
  }
  updateProduct(product){
    let update=this.productService.updateProduct(product);
    update.subscribe((data)=>{
      if(data){
        alert(data)
      }
    },
    error => {
      if (error.status === 404) {
        alert("Product not found")
      }else if (error.status === 403) {
        alert("Product ID must be of minimum 4 digits")
      
      }
    }
  )
}
}

