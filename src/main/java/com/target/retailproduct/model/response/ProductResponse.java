package com.target.retailproduct.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {

	@JsonProperty("product_composite_response")
	private ProductCompositeResponse productCompositeResponse ;

	public ProductCompositeResponse getProductCompositeResponse() {
		return productCompositeResponse;
	}

	public void setProductCompositeResponse(ProductCompositeResponse productCompositeResponse) {
		this.productCompositeResponse = productCompositeResponse;
	} 
}
