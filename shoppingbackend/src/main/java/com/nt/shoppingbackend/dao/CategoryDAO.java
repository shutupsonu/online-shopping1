package com.nt.shoppingbackend.dao;

import java.util.List;

import com.nt.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
}
