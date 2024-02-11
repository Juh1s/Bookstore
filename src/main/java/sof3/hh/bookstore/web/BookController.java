package sof3.hh.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof3.hh.bookstore.domain.Book;
import sof3.hh.bookstore.domain.BookRepository;

@Controller
public class BookController {

    // http://localhost:8080/index

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String getIndex(Model model){

        return "index"; // index.html
    }

    @Autowired
    private BookRepository bookRepository;
    
    // http://localhost:8080/booklist

    // kaikkien kirjojen listaussivu
    @RequestMapping(value="/booklist", method = RequestMethod.GET)
    public String getBooklist(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        return "booklist";  // booklist.html
    }

    // tyhjän kirjalomakkeen muodostaminen
    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String getAddBook(Model model) {
        model.addAttribute("book", new Book()); // "tyhjä" kirja-olio
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
    public String deleteBook(@PathVariable("id") Integer bookid) {
        bookRepository.deleteById(bookid);
        return "redirect:/booklist";    // booklist.html
    }

    // muutetaan kirjan tietoja
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Integer bookid, Model model) {
        // muutetaan yhden kirjan tietoja tietokannassa
        model.addAttribute("book", bookRepository.findById(bookid));
        return "editbook"; //   editbook.html
    }


}
