import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../entity/Product';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  product: Product= new Product(0,"","","",0,0,0);
  message:any;
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
  }
  public addProduct(product){
    let add=this.productService.addProduct(product);
    add.subscribe(
      (data)=>{
       
        if (data) {
          alert(data)
        }
      
      },

      error => {
        if (error.status === 400) {
          alert("Product ID already exists")
        }else if (error.status === 403) {
          alert("Product ID must be of minimum 4 digits")
        
        }
      }
    )
  }
}
