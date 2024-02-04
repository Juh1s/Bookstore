package domain;

public class Book {

    //attribuutit
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
