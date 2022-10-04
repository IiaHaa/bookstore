package s22.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s22.bookstore.domain.ApplicationUserRepository;
import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.Category;
import s22.bookstore.domain.CategoryRepository;

@DataJpaTest
class RepositoryTests {
	
	@Autowired
	ApplicationUserRepository userRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	public void findBook() {
		Book book = bookRepository.findById((long) 4).get();
		System.out.println("Haetaan id:llä 4 " + book);
		assertEquals(book.getTitle(), "Seitsemän veljestä");
	}
	
	@Test
	public void addBook() {
		Book book = new Book("Da Vinci -koodi", "Dan Brown", 2003, "43435642", 25, new Category("Adventure"));
		bookRepository.save(book);
		assertNotNull(book.getId());
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = bookRepository.findByTitle("Seitsemän veljestä");
		Book book = books.get(0);
		bookRepository.delete(book);
		List<Book> newBooks = bookRepository.findByTitle("Seitsemän veljestä");
		assertThat(newBooks).hasSize(0);
	}
	
	@Test
	public void findCategory() {
		Category category = categoryRepository.findById((long) 1).get();
		System.out.println("Haetaan id:llä 1 " + category);
		assertEquals(category.getName(), "Romance");
	}
}