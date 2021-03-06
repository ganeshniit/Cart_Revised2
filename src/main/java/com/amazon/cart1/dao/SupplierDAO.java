package com.amazon.cart1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazon.cart1.model.Supplier;

@Repository
public interface SupplierDAO {
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String id);
    public List<Supplier> list();

}
