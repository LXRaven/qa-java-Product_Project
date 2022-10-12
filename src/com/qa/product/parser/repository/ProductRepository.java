package com.qa.product.parser.repository;

import java.util.ArrayList;

import com.qa.product.parser.bean.Product;
import com.qa.product.parser.util.CSVReader;

public class ProductRepository {
	
	public ArrayList<Product> allProducts;
	
	public ProductRepository() {
		try {
			CSVReader reader = new CSVReader();
			this.allProducts = reader.readFilesFromCSV("C:\\Users\\Alex TJ\\Desktop\\desktop\\QA Bootcamp 2022\\Java Fundamentals\\java.products\\products.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
