package thuan.com.fa.demomvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thuan.com.fa.demomvc.entity.Category;
import thuan.com.fa.demomvc.entity.Product;
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.service.CategoryServiceImpl;
import thuan.com.fa.demomvc.service.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@GetMapping("/list")
	public String getAllProductWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<Product> products = productServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("products", products);
		model.addAttribute("totalPages", productServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/product/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("productForm", new Product());
		return "/product/new";
	}

	@PostMapping("/save")
	public String addNewProduct(@ModelAttribute(name = "productForm") @Valid Product product, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "/product/new";
		}
		productServiceImpl.saveOrUpdate(product);
		return "redirect:/product/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") long productId, @RequestParam(name = "age") long age) {
		System.out.println(" id = " + productId + "age = " + age);
		// localhost:xxx/product/delete?id=10&age=20&address=DN
		productServiceImpl.delete(productId);
		return "redirect:/product/list";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable(name = "id") long productId, Model model) {
		Product product = productServiceImpl.findById(productId);
		model.addAttribute("productForm", product);
		return "/product/update";
	}

	@PostMapping("/update")
	public String updateProduct(@ModelAttribute(name = "productForm") @Valid Product product, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "/product/update";
		}
		productServiceImpl.saveOrUpdate(product);
		model.addAttribute("msgUpdate", "Update product success");
		return "/product/update";
	}

	@ModelAttribute("categories")
	public List<Category> initCategories() {
		return categoryServiceImpl.findAll();
	}

	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<Product> products = productServiceImpl.search(searchKey);
		model.addAttribute("products", products);
		model.addAttribute("searchKey", searchKey);

		return "/product/search";
	}
}
