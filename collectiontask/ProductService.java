package com.ey.collectiontask;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
	
	static List<Product> plist=new ArrayList<>();
	
	public String addProduct(Product p) {
		if (plist.contains(p)) {
            return "Product already exists.";
        }
        plist.add(p);
        return "Product added successfully.";
		
	}
	public String deleteProduct(Product p) { //to be  implement
		if (plist.contains(p)) {
            plist.remove(p);
            return "Product deleted successfully.";
        }
        return "Product not found.";
	}
	public String updateProduct(Product p) {//to be  implement
		for (int i = 0; i < plist.size(); i++) {
            if (plist.get(i).getId() == p.getId()) {
                plist.set(i, p);
                return "Product updated successfully.";
            }
        }
        return "Product not found.";
	}
	
	public void  listProducts(){
		plist.forEach(x->System.out.println(x));
	}
	
	public Product getProduct(Integer id) {//to be  implement
		for (Product product : plist) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
	}
}
