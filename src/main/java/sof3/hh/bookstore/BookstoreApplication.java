package sof3.hh.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof3.hh.bookstore.domain.Book;
import sof3.hh.bookstore.domain.BookRepository;
import sof3.hh.bookstore.domain.Category;
import sof3.hh.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category category1 = new Category("Scifi");
			Category category2 = new Category("Comic");
			Category category3 = new Category("Drama");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			Book book1 = new Book("Täydellinen Titteli", "Tekijämies", 2017, 1, 23, category1);
			Book book2 = new Book("Konttorikriisi", "Kirjasalo", 1989, 2, 45, category2);

			bookRepository.save(book1);
			bookRepository.save(book2);

			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			log.info("...");
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			log.info("...");
		};
	}

}
