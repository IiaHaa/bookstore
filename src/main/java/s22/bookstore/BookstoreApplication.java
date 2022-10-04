package s22.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.Category;
import s22.bookstore.domain.CategoryRepository;
import s22.bookstore.domain.ApplicationUser;
import s22.bookstore.domain.ApplicationUserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	BookRepository repository;
	@Autowired
	CategoryRepository crepository;
	@Autowired
	ApplicationUserRepository urepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, ApplicationUserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Crime"));
			
			repository.save(new Book("Seitsemän veljestä", "Aleksis Kivi", 1870, "22020202", 12, crepository.findByName("Crime").get(0)));
			repository.save(new Book("Pikku naisia", "Louisa May Alcott", 1868, "23950002", 15, crepository.findByName("Romance").get(0)));
			
			urepository.save(new ApplicationUser("Iia", "Haa", "ADMIN", "admin", "$2a$10$ClOfj7Z96AWF7kWGX3YCoOdMteIJ7XZf76GNiWX9Nnf8WPvUNdg.S"));
			urepository.save(new ApplicationUser("Mikko", "Mallikas", "USER", "user", "$2a$10$JNBqsCAUCxKJd2E2sYqRGu6S9HiAeyAjtrRG2vS/ElisVV44FUf8i"));
			
			for (Book book: repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}