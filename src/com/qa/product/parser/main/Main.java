package com.qa.product.parser.main;

import java.util.ArrayList;

import com.qa.product.parser.bean.*;
import com.qa.product.parser.repository.ProductRepository;
import com.qa.product.parser.service.ProductService;

public class Main {

	public static void main(String[] args) {

		ArrayList<Product> allProducts = new ProductRepository().allProducts;
		ProductService service = new ProductService();

		//printing all products from a csv file
		for (Product product : allProducts) {
			service.displayProductDetails(product);
			System.out.println();
		}

		//get product by id
		Product pByID = service.getProductById(1);
		System.out.print("The product with the id of 1 is:");
		System.out.println(pByID);
		System.out.println();

		//get cheapest item
		Product pCheapest = service.getCheapestProduct();
		System.out.print("The cheapest product is: ");
		System.out.println(pCheapest);
		System.out.println();

		//get most expensive item
		Product pMostExpensive = service.getMostExpensiveProduct();
		System.out.print("The most expensive product is: ");
		System.out.println(pMostExpensive);
		System.out.println();

		//get lowest rating item
		Product pLowestRating = service.getLowestRatingProduct();
		System.out.print("The lowest rating product is: ");
		System.out.println(pLowestRating);
		System.out.println();

		//get highest rating item
		Product pHighestRating = service.getHighestRatingProduct();
		System.out.print("The highest rating product is: ");
		System.out.println(pHighestRating);
		System.out.println();

		//get discounted amount for all items
		for(Product p : allProducts) {
			System.out.println("The discounted amount for "+ p + " is: " + service.getDiscountedAmount(p));
			System.out.println();
		}

		//get final price for all items
		for(Product p : allProducts) {
			System.out.println("The final price for "+ p + " is: " + service.getFinalPrice(p));
			System.out.println();

		}
	}
}
