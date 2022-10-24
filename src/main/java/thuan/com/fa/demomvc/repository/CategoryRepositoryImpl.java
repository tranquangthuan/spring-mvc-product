package thuan.com.fa.demomvc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thuan.com.fa.demomvc.entity.Category;
import thuan.com.fa.demomvc.page.PageAble;

@Repository
public class CategoryRepositoryImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Category> Categorys = session.createQuery("SELECT p FROM Category p", Category.class).getResultList();
		return Categorys;
	}

	public void saveOrUpdate(Category Category) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(Category);
	}

	public void delete(Category Category) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(Category);
	}

	public Category findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Category.class, id);
	}

	public List<Category> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<Category> Categorys = session.createQuery("SELECT p FROM Category p", Category.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return Categorys;
	}

	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM Category p", Long.class).getSingleResult();
	}
}
