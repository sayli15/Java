package com.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Products {
	@Id
	@GeneratedValue
	@Column(length=15,name="pid")
	int proid;
	@Column(length=15,name="pname")
	String prodname;
	@Column(length=15)
	String category;
	@Column(length=15)
	int quantity;
	@Column(length=15)
	double price;
	
	
	public Products(int proid, String prodname, String category, int quantity, double price) {
		this.proid = proid;
		this.prodname = prodname;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
	}


	public Products() {
	}


	public Products(String prodname, String category, int quantity, double price) {
		this.prodname = prodname;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
	}


	public int getProid() {
		return proid;
	}


	public void setProid(int proid) {
		this.proid = proid;
	}


	public String getProdname() {
		return prodname;
	}


	public void setProdname(String prodname) {
		this.prodname = prodname;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Products [proid=" + proid + ", prodname=" + prodname + ", category=" + category + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
	
	
}
