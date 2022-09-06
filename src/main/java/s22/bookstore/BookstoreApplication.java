package s22.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Seitsemän veljestä", "Aleksis Kivi", 1870, "22020202", 12));
			repository.save(new Book("Pikku naisia", "Louisa May Alcott", 1868, "23950002", 15));
			
			for (Book book: repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}