package com.ey.collectiontask;

import java.util.List;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {  //rest, run, ui,
		ProductService ps=new ProductService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("...Welcome to the World of Products...");
		System.out.println("Please select The Menu : ");
		

		//menu should be displayed, take user choice to perform operation, 1...5
		
//		Product product=new Product(10,"box");
//		Product product1=new Product(11,"box1");
		
		/*String result=ps.addProduct(product);
		String result1=ps.addProduct(product1);
		
		
		System.out.println(result);
		System.out.println(result1);*/
		
		while (true) {
			System.out.println(" ");
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Update Product");
            System.out.println("4. Get Product by ID");
            System.out.println("5. List All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    Product productToAdd = new Product(id, name);
                    System.out.println(ps.addProduct(productToAdd));
                    break;
                case 2:
                    System.out.print("Enter product ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Product productToDelete = new Product(idToDelete, "");
                    System.out.println(ps.deleteProduct(productToDelete));
                    break;
                case 3:
                    System.out.print("Enter product ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter updated product name: ");
                    String updatedName = scanner.nextLine();
                    Product updatedProduct = new Product(idToUpdate, updatedName);
                    System.out.println(ps.updateProduct(updatedProduct));
                    break;
                case 4:
                    System.out.print("Enter product ID to get: ");
                    int idToGet = scanner.nextInt();
                    Product retrievedProduct = ps.getProduct(idToGet);
                    if (retrievedProduct != null) {
                        System.out.println("Product found: " + retrievedProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 5:
                    ps.listProducts();
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

	}

}
