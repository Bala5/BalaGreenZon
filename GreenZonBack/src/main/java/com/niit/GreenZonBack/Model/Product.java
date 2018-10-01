package com.niit.GreenZonBack.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product { 
	      @Id
	      @GeneratedValue(strategy=GenerationType.AUTO)
	      private int productid;
	      
	      @Column(nullable=false,unique=true)
	      @NotEmpty(message="Cannot be blank")
	      private String name;
	      
	      
	      @Column(nullable=false)
	      @NotNull(message="Cannot be blank")
	      private int catid;
	      
	      
	      @Column(nullable=false)
	      @NotEmpty(message="Cannot be blank")
	      private String description;
	      
	      @Column(nullable=false)
	      @Min(value=10,message="Minmum price value is Rs.10")	      
	    //  @NotEmpty(message="Cannot be blank")
	      @Value(value="10")
	      private int price;
	      
	      @Column(nullable=false)
	      @Min(value=10,message="Minmum quantity is 10 kg")
	   //   @NotEmpty(message="Cannot be blank")
	      private int quantity;
	      
	      
	      @Transient
	      MultipartFile image;
	      
	      
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getProductid() {
			return productid;
		}
		public void setProductid(int productid) {
			this.productid = productid;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getCatid() {
			return catid;
		}
		public void setCatid(int catid) {
			this.catid = catid;
		}
		public MultipartFile getImage() {
			return image;
		}
		public void setImage(MultipartFile image) {
			this.image = image;
		}
		
		
		
	      

}
