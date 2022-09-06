package s22.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/index")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
	return "booklist";
	}
	
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addstudent";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

}