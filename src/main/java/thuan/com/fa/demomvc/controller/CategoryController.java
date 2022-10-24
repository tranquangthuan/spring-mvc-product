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
import thuan.com.fa.demomvc.page.PageAble;
import thuan.com.fa.demomvc.service.CategoryServiceImpl;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<Category> categories = categoryServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("categories", categories);
		model.addAttribute("totalPages", categoryServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/category/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("categoryForm", new Category());
		return "/category/new";
	}

	@PostMapping("/save")
	public String addNewCategory(@ModelAttribute(name = "categoryForm") @Valid Category Category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/category/new";
		}
		categoryServiceImpl.saveOrUpdate(Category);
		return "redirect:/category/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") long CategoryId) {
		categoryServiceImpl.delete(CategoryId);
		return "redirect:/category/list";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable(name = "id") long CategoryId, Model model) {
		Category category = categoryServiceImpl.findById(CategoryId);
		model.addAttribute("categoryForm", category);
		return "/category/new";
	}

}
