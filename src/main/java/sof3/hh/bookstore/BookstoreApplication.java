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
import sof3.hh.bookstore.domain.User;
import sof3.hh.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
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

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "email1", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "email2", "ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);

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
