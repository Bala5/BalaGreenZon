package com.niit.GreenZonBack.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.GreenZonBack.Model.Category;

@Repository("cd")
@Transactional
public class CategoryDAOImp implements CategoryDAO {
	@Autowired
	SessionFactory sf;

	public boolean addCategory(Category category) {
		try {
			sf.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Category> showAllCategory() {
		try {
			List<Category> category =(List<Category>) sf.getCurrentSession().createQuery("From Category").list();
			return category;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean deleteCategory(int id) {
		try {
			sf.getCurrentSession().delete(showCategory(id));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Category showCategory(int id) {
		try {
			Category category = (Category) sf.getCurrentSession()
					.createQuery("From  Category where catid="+id).uniqueResult();
			return category;
		} catch (Exception e) {
			return null;
		}

	}

}
