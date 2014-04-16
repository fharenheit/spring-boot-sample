package org.opencloudengine.samples.spring.boot;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "ProductID")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int prodID;

	@Column(name = "ProductName")
	private String name;

	public Product() {
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product{" +
			"prodID=" + prodID +
			", name='" + name + '\'' +
			'}';
	}
}