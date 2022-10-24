package thuan.com.fa.demomvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thuan.com.fa.demomvc.entity.Category;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.repository.CategoryRepositoryImpl;

@Service
public class CategoryServiceImpl {

	@Autowired
	private CategoryRepositoryImpl categoryRepositoryImpl;

	@Transactional
	public List<Category> findAll() {
		return categoryRepositoryImpl.findAll();
	}

	@Transactional
	public void saveOrUpdate(Category Category) {
		categoryRepositoryImpl.saveOrUpdate(Category);
	}

	@Transactional
	public void delete(long id) {
		Category Category = findById(id);
		if (Category != null) {
			categoryRepositoryImpl.delete(Category);
		}
	}

	@Transactional
	public Category findById(long id) {
		return categoryRepositoryImpl.findById(id);
	}

	@Transactional
	public List<Category> findWithPageAble(PageAble pageAble) {
		return categoryRepositoryImpl.findWithPageAble(pageAble);
	}

	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = categoryRepositoryImpl.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

}
