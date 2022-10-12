package com.qa.product.parser.util;
import com.qa.product.parser.bean.Product;

import java.io.*;
import java.util.ArrayList;

public class CSVReader {

	public ArrayList<Product> readFilesFromCSV(String filePath) {
		ArrayList<Product> products = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))){
			
			br.readLine();//headers
			String productInfo = br.readLine();
			while(productInfo!=null) {
				Product product = new Product();
				String[] splitList = productInfo.split(",");
				int id = Integer.parseInt(splitList[0]);
				product.setId(id);
				String name = splitList[1];
				product.setName(name);
				float price = Float.parseFloat(splitList[2]);
				product.setPrice(price);
				String category = splitList[3];
				product.setCategory(category);
				float rating = Float.parseFloat(splitList[4]);
				product.setRating(rating);
				float discountPercentage = Float.parseFloat(splitList[5]);
				product.setDiscountPercentage(discountPercentage);
				boolean isAvailable = Boolean.parseBoolean(splitList[6]);
				product.setAvailable(isAvailable);
				products.add(product);
				productInfo = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return products;
		
	}
}
