import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {throwError, Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }
  addProduct(product){
    return this.http.post("http://localhost:9090/login/addProduct",product,{responseType:'text' as 'json'}); 
  }
  getAllProducts() {
    return this.http.get("http://localhost:9090/login/viewAllProducts");
  }
  deleteProduct(productId){
    return this.http.delete("http://localhost:9090/login/deleteProduct/"+productId,{responseType: 'text' as 'json'});
  }
  updateProduct(product){
    return this.http.put("http://localhost:9090/login/updateProduct",product,{responseType:'text' as 'json'});
  }
}
