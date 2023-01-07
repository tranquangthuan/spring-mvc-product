package thuan.com.fa.demomvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thuan.com.fa.demomvc.entity.Product;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.repository.ProductRepositoryImpl;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductRepositoryImpl productRepository;

	@Transactional
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional
	public void saveOrUpdate(Product product) {
		productRepository.saveOrUpdate(product);
	}

	@Transactional
	public void delete(long id) {
		Product product = findById(id);
		if (product != null) {
			productRepository.delete(product);
		}
	}

	@Transactional
	public Product findById(long id) {
		return productRepository.findById(id);
	}

	@Transactional
	public List<Product> findWithPageAble(PageAble pageAble) {
		List<Product> products = productRepository.findWithPageAble(pageAble);
		return products;
	}

	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = productRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

	@Transactional
	public List<Product> search(String searchKey) {
		return productRepository.search(searchKey);
	}

	@Transactional
	public boolean existSerial(String serial) {
		return productRepository.existSerial(serial);
	}
}
