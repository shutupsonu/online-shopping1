package com.nt.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.shoppingbackend.dao.ProductDAO;
import com.nt.shoppingbackend.dto.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * single
	 */
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	

	/*
	 * List of Product
	 * */
	@Override
	public List<Product> list() {
		
			return sessionFactory
					.getCurrentSession()
						.createQuery("FROM Product",Product.class)
							.getResultList();
							
		
	}

	
	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Product product) {
		try {
			 sessionFactory
					.getCurrentSession()
						.persist(product);
			 return true;
							
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	
	
	/*
	 * UPDATE
	 * */
		@Override
	public boolean update(Product product) {
		try {
			 sessionFactory
					.getCurrentSession()
						.update(product);
			 return true;
							
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Product product) {
	try {
		product.setActive(false);
		return this.update(product);
	}catch (Exception e) {
		e.printStackTrace();
	}
	return false;
		
	}
	
	
	
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProduct = "from Product WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProduct,Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String selectActiveProductByCategory = "from Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductByCategory,Product.class)
						.setParameter("active", true)
						.setParameter("categoryId" , categoryId)
							.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String setLatestActiveProduct = "from Product WHERE active =:active ORDER BY id";
		return sessionFactory
				.getCurrentSession()
					.createQuery(setLatestActiveProduct)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}
	
	

}
