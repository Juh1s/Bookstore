package sof3.hh.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sof3.hh.bookstore.domain.Book;
import sof3.hh.bookstore.domain.BookRepository;
import sof3.hh.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    // http://localhost:8080/index

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String getIndex(Model model){

        return "index"; // index.html
    }

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    // http://localhost:8080/booklist

    // kaikkien kirjojen listaussivu
    @RequestMapping(value="/booklist", method = RequestMethod.GET)
    public String getBooklist(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        return "booklist";  // booklist.html
    }

    // näytä kaikki kirjat
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }
    
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return bookRepository.findById(bookId);
    }      

    // tyhjän kirjalomakkeen muodostaminen
    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String getAddBook(Model model) {
        model.addAttribute("book", new Book()); // "tyhjä" kirja-olio
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";   // addbook.html
    }

    // tallennetaan uusi kirja ja palataan kirja listalle
    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book) {
        // tallennetaan yhden uuden kirjan tiedot tietokantaan
        bookRepository.save(book);
        return "redirect:/booklist";    // booklist.html
    }

    // poistetaan valittu kirja listasta
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookid) {
        bookRepository.deleteById(bookid);
        return "redirect:/booklist";    // booklist.html
    }

    // muutetaan kirjan tietoja
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookid, Model model) {
        // muutetaan yhden kirjan tietoja tietokannassa
        model.addAttribute("book", bookRepository.findById(bookid));
        return "editbook"; //   editbook.html
    }


}
