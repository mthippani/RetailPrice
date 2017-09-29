package com.target.retailproduct.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.target.retailproduct.model.Product;
import com.target.retailproduct.model.Result;
import com.target.retailproduct.service.ProductService;

@RestController
public class ProductsResource {

	@Autowired
	private ProductService productService;

	@RequestMapping(path="/products/{id}",method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int  id) throws Exception{
		return productService.getProductById(id);
	}
	
	@RequestMapping(path="/products/{id}",method = RequestMethod.PUT)
	public Result savePrice(@PathVariable("id") int  id,
			@RequestBody Product product){
		if( productService.updatePrice(id,product.getCurrentPrice())){
			return new Result("successfully updated");
		}else{
			return new Result("failed to update");
		}
	}
	
}
