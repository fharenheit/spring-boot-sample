package org.opencloudengine.samples.spring.boot;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("prodDAO")
public class ProductRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Product getProduct(int id) {
		System.out.println("In DAO class");
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Product insert(Product product) {
		this.sessionFactory.getCurrentSession().persist(product);
		return product;
	}
}