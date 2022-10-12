package com.qa.product.parser.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import com.qa.product.parser.bean.Product;
import com.qa.product.parser.repository.ProductRepository;

public class ProductService {
	
	public ArrayList<Product> products;
	
	public ProductService() {
		this.products = new ProductRepository().allProducts;
	}
	public void displayProductDetails(Product p) {
		System.out.println("Id is: " + p.getId());
		System.out.println("name is: " + p.getName());
		System.out.println("price is: " + p.getPrice());
		System.out.println("category is: " + p.getCategory());
		System.out.println("rating is: " + p.getRating());
		System.out.println("discountPercentage is: " + p.getDiscountPercentage());
		System.out.println("isAvailable is: " + p.isAvailable());
	}
	
	public Product getProductById(int id) {
		Product p = new Product();
		for(Product searchedProduct : products) {
			if (searchedProduct.getId() == id) {
				p = searchedProduct;
			}
		}
		return p;
	}
	
	public Product getCheapestProduct() {
		float minPrice = products.get(0).getPrice();
		Product p = products.get(0);
		for(Product searchedProduct : products) {
			if (searchedProduct.getPrice() < minPrice) {
				p = searchedProduct;
				minPrice = searchedProduct.getPrice();
			}
		}
		return p;
	}
	
	public Product getMostExpensiveProduct() {
		float maxPrice = products.get(0).getPrice();
		Product p = products.get(0);
		for(Product searchedProduct : products) {
			if (searchedProduct.getPrice() > maxPrice) {
				p = searchedProduct;
				maxPrice = searchedProduct.getPrice();
			}
		}
		return p;
	}
	
	public Product getLowestRatingProduct() {
		float minRating = products.get(0).getRating();
		Product p = products.get(0);
		for(Product searchedProduct : products) {
			if (searchedProduct.getRating() <= minRating) {
				p = searchedProduct;
				minRating = searchedProduct.getRating();
			}
		}
		return p;
	}
	
	public Product getHighestRatingProduct() {
		float maxRating = products.get(0).getRating();
		Product p = products.get(0);
		for(Product searchedProduct : products) {
			if (searchedProduct.getRating() >= maxRating) {
				p = searchedProduct;
				maxRating = searchedProduct.getRating();
			}
		}
		return p;
	}
	
	public float getFinalPrice(Product p) {
		DecimalFormat df = new DecimalFormat("##.##");
		float finalPrice = Float.parseFloat(df.format(p.getPrice() * (1 - (p.getDiscountPercentage()/100))));
		return finalPrice ;
	}
	
	public float getDiscountedAmount(Product p) {
		DecimalFormat df = new DecimalFormat("##.##");
		float discountedAmount = Float.parseFloat(df.format(p.getPrice() * (p.getDiscountPercentage()/100)));
		return discountedAmount ;
	}
}
