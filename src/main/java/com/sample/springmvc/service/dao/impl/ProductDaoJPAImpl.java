package com.sample.springmvc.service.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.springmvc.domain.Product;
import com.sample.springmvc.service.dao.ProductDao;

//Tiene efecto sobre la transaccionalidad automática
@Repository
public class ProductDaoJPAImpl implements ProductDao {

	private EntityManager entityManager = null;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// readOnly = true : Ejecucion Transaccional, ademas permite la ejecución de
	// diversas consultas de lectura en paralelo.
	@Transactional(readOnly = true)
	public List<Product> getProductList() {
		// CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		// Root<Product> c = cq.from(Product.class);
		// cq.select(c);
		// TypedQuery<Product> query = entityManager.createQuery(cq);
		// List<Product> results = query.getResultList();

		TypedQuery<Product> tq = this.entityManager.createQuery("from Product p  where p.price > :price order by p.id", Product.class);
		tq.setParameter("price", 0.0);
		List<Product> results = tq.getResultList();

		return results;
	}

	// readOnly = false : Ejecucion Transaccional
	@Transactional(readOnly = false)
	public void saveProduct(Product prod) {
		this.entityManager.merge(prod);
	}

}
