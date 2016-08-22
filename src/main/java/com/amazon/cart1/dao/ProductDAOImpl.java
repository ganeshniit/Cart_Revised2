package com.amazon.cart1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.cart1.model.Product;

@EnableTransactionManagement

@Repository(value="productDAO")
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
public boolean save(Product product){
	try {
		sessionFactory.getCurrentSession().save(product);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;}
	}
	@Transactional
	public boolean update(Product product){
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;}
		}
		@Transactional
		public boolean delete(Product product){
			try {
				sessionFactory.getCurrentSession().delete(product);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
}
		@Transactional
public Product get(String id)
{
	String hql="from Product where id="+"'"+id+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<Product> list=query.list();
			if(list==null || list.isEmpty()){
				return null;
			}
			else{
				return list.get(0);
				
			}
}
		@Transactional
public	List<Product> list(){
	String hql="from Product";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
		
	}
}


