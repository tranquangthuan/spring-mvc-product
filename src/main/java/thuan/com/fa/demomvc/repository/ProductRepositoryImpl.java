package thuan.com.fa.demomvc.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thuan.com.fa.demomvc.entity.Product;
import thuan.com.fa.demomvc.page.PageAble;

@Repository
public class ProductRepositoryImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
		return products;
	}

	public void saveOrUpdate(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}

	public void delete(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
	}

	public Product findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Product.class, id);
	}

	public List<Product> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return products;
	}

	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM Product p", Long.class).getSingleResult();
	}

	public List<Product> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> createQuery = session.createQuery("SELECT p FROM Product p where p.name like :searchKey",
				Product.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<Product> products = createQuery.getResultList();
		return products;
	}

	public boolean existSerial(String serial) {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		Query<Long> createQuery = session.createQuery("SELECT COUNT(*) FROM Product p WHERE p.serial=:serial",
				Long.class);
		createQuery.setParameter("serial", serial);
		long totalRecord = createQuery.getSingleResult();
		System.out.println("Total record with serial = " + totalRecord + " serial = " + serial);

		return totalRecord > 0;
	}
}
