package s22.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s22.bookstore.domain.Category;
import s22.bookstore.domain.CategoryRepository;

@RestController
public class CategoryRestController {
	
	@Autowired
	private CategoryRepository repository;

	// RESTful service to get all books
	@GetMapping("/categories")
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) repository.findAll();
	}
}