package sof3.hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof3.hh.bookstore.domain.Book;
import sof3.hh.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {

			Book book1 = new Book("Täydellinen Titteli", "Tekijämies", 2017, 1, 23);
			Book book2 = new Book("Konttorikriisi", "Kirjasalo", 1989, 2, 47);

			bookRepository.save(book1);
			bookRepository.save(book2);
		};
	}

}
