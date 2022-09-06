package s22.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private Long bookyear;
	private Long price;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, long bookyear, String isbn, long price) {
		super();
		this.title = title;
		this.author = author;
		this.bookyear = bookyear;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public long getPyear() {
		return bookyear;
	}

	public void setPyear(long pyear) {
		this.bookyear = pyear;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + bookyear + ", price=" + price
				+ "]";
	}

}
