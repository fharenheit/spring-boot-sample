package org.opencloudengine.samples.spring.boot;

import org.springframework.stereotype.Component;

@Component("prodDAO")
public class ProductRepository extends BaseRepository {

	public Product getProduct(int id) {
		System.out.println("In DAO class");
		return null;
	}

	public Product insert(Product product) {
		this.getSession().persist(product);
		return product;
	}
}