package ua.polkovnik.SpringBootApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.polkovnik.SpringBootApp.models.Book;
import ua.polkovnik.SpringBootApp.models.MockDB;

@Controller
public class BookController {

    @GetMapping("/")
    public String homePage(Model model){ return "main"; }

    @GetMapping("/error")
    public String error(Model model){
        return"error";
    }


}
