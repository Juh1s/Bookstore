package sof3.hh.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value="/booklist", method = RequestMethod.GET)
    public String getBooklist(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        return "booklist";  // booklist.html
    }



}
