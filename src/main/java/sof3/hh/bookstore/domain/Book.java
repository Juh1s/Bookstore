package sof3.hh.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    //attribuutit
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "bookid")
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private Integer isbn;
    private Integer price;
    //konstruktorit
    // parametrillinen konstruktori
    public Book(
        String title,
        String author,
        Integer publicationYear,
        Integer isbn,
        Integer price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
    // parametriton konstruktori
    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = 0;
        this.price = 0;
    }

    //setterit
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    //getterit
    public Long getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Integer getPublicationYear() {
        return publicationYear;
    }
    public Integer getIsbn() {
        return isbn;
    }
    public Integer getPrice() {
        return price;
    }

}
