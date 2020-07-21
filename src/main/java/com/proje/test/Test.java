package com.proje.test;



import java.sql.Date;
import java.util.List;

import com.proje.Service.BrandService;
import com.proje.model.Brand;
import com.proje.serviceImplement.BrandServiceImplement;


public class Test {
public static void main(String[] args) {
	
	BrandService brandService =new BrandServiceImplement();

	
//User user =new User(1, "suleyman", "karacavus", new Date(new java.util.Date().getTime()), "suleym  ankaracavus", null);
//	userService.saveUser(user);
//	Product product= new Product(1, "Asus", 1800, 1, new java.util.Date(), null, null, null);
	
//  List<Brand> brands = brandService.findBrands();
//  for (Brand brand : brands) { 
//	  System.out.println(brand.getBrandId()+"--"+brand.getBrandName() );
//  }
	
Brand brand =brandService.findBrandById(2); 
System.out.println(brand.getBrandName() );

//	List <Category> categories= categoryService.findCategories();
//	for (Category category : categories) {
//  System.out.println(category.getCategoryId()+"-----"+category.getCategoryName());
//	Category category=categoryService.findCategoryById(1);
//	System.out.println(category.getCategoryName());
//	List<Product> products=new ProductServiceImplement().findProducts();
//	for (Product product : products) {
//		System.out.println(product.getProductId()+"--"+product.getAvaliable()+"--"+product.getUnitPrice()+"--"+product.getAddDate()+"--"
//	+product.getUpdateDate()+"--"+product.getCategory().getCategoryName()+"--"+product.getBrand().getBrandName());
	
//	List<User> users=userService.findUsers();
//for (User user : users) {
//	System.out.println(user.getUserId()+"--"+user.getFirstName()+"--"+user.getLastname()+""+user.getBirthofDate()+"--"+user.getUsername());}


}}

		

