package com.nt.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nt.shoppingbackend.dao.CategoryDAO;
import com.nt.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// first object
		category.setId(1);
		category.setName("Televison");
		category.setDescription("This is description..");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// second object
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is description..");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		// second object
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is description..");
		category.setImageURL("CAT_3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		 
		return categories;
	}

	@Override
	public Category get(int id) {
		//enhanceFor loop
		for(Category category : categories) {
			if(category.getId()==id) {
				return category;
			}
		}
		return null;
		
		
	}

}
