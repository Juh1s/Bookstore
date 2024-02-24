package sof3.hh.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof3.hh.bookstore.domain.Category;
import sof3.hh.bookstore.domain.CategoryRepository;


@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // http://localhost:8080/

    @RequestMapping(value="/categorylist", method=RequestMethod.GET)
    public String getCategorylist(Model model){

        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; // categorylist.html
    }

    @RequestMapping(value = "/addcategory", method=RequestMethod.GET)
    public String getAddCategory(Model model) {

        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    @RequestMapping(value = "/savecategory", method=RequestMethod.POST)
    public String saveCategoryList(@ModelAttribute Category category) {

        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
    
}
