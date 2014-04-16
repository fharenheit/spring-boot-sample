package org.opencloudengine.samples.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("prodSvc")
public class ProductService {

	@Autowired
	private ProductRepository dao;

	public void setDao(ProductRepository dao) {
		this.dao = dao;
	}

	public Product getProduct(int id) {
		System.out.println("In Service class...will call DAO");
		return dao.getProduct(id);
	}

	public Product addProduct(Product product) {
		System.out.println("In Service class...will call DAO");
		return dao.insert(product);
	}
}