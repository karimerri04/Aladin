/**
 *
 */
package com.karimerri.aladin_api.models;

import java.math.BigDecimal;

import com.karimerri.aladin_api.entities.Product;

import lombok.Data;

@Data
public class LineItem {
	private Product product;
	private int quantity;

	public LineItem() {
	}

	public LineItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public BigDecimal getSubTotal() {
		return product.getPrice().multiply(new BigDecimal(quantity));
	}

}
