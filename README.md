package com.ey.autowiring.model;
public class Product {
	Integer id;
	String name;
	public Product() {
 
	}
	public Product(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
}


package com.ey.autowiring.repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

import com.ey.autowiring.model.Product;
@Component
public class ProductRepo {
  static	List<Product> plist=new ArrayList<>();
	
	static {
	  plist.add(new Product(10,"pen"));
	 plist.add(new Product(20,"bag"));
	 plist.add(new Product(30,"tin"));
	}
	public void addProduct(Product product) {
		plist.add(product);
	//	System.out.println(plist);
	}
	//update, delete,list,list1 product
	
	public Product getProduct(Integer id) {  //to get single product
		Product p1=new Product();
		for(Product p:plist) {
			if(p.getId()==id) {
				p1.setId(p.getId());
			    p1.setName(p.getName());
			}
		}
		return p1;
	}
	
	public List<Product> getAllProducts(){
		
	 return plist;
	}
}


package com.ey.autowiring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ey.autowiring.model.Product;
import com.ey.autowiring.repository.ProductRepo;

@Component
public class ProductService  {
	@Autowired  //automatic di, field di ,constructor di
	ProductRepo productRepo;
	/*
	  @Autowired 
	  public ProductService(ProductRepo productRepo) 
	  { this.productRepo = productRepo; 
	  }
	 */
	public ProductRepo getProductRepo() {
		return productRepo;
	}
  //  @Autowired
	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	public void addProduct(Product product) {
		//ProductRepo productRepo=new ProductRepo();
		productRepo.addProduct(product);
		System.out.println("product added..."+product.getId());
	}
	public List<Product> getAllProducts(){
		return productRepo.getAllProducts();
	}

	  public Product getProduct(Integer id) {
		  return productRepo.getProduct(id);
	  }
}


package com.ey.autowiring.test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ey.autowiring.service", "com.ey.autowiring.repository"})
public class AutowiringConfig {

}


package com.ey.autowiring.test;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ey.autowiring.model.Product;
import com.ey.autowiring.service.ProductService;

public class ProductTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AutowiringConfig.class);
		ProductService productService=(ProductService)context.getBean(ProductService.class);
		
	//	ProductService ps=new ProductService();//

		Product product=new Product(40,"box");
	
		productService.addProduct(product);
		
		System.out.println(" Listing all products....");
		
	List<Product> plist=productService.getAllProducts();
		plist.stream().forEach(x->System.out.println(x));
	
		System.out.println(" get single product");
		System.out.println(productService.getProduct(10));
		
	}
}



<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.ey</groupId>
  <artifactId>SpringAutowiring</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>SpringAutowiring</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>17</java.version>
  </properties>

  <dependencies>
      
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.0.10.RELEASE</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.0.10.RELEASE</version>
</dependency>
  </dependencies>
</project>
