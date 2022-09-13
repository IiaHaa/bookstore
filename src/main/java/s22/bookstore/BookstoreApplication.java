package s22.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.Category;
import s22.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Crime"));
			
			repository.save(new Book("Seitsemän veljestä", "Aleksis Kivi", 1870, "22020202", 12, crepository.findByName("Crime").get(0)));
			repository.save(new Book("Pikku naisia", "Louisa May Alcott", 1868, "23950002", 15, crepository.findByName("Romance").get(0)));
			
			for (Book book: repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}