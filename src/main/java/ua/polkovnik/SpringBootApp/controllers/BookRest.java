package ua.polkovnik.SpringBootApp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.polkovnik.SpringBootApp.models.Book;
import ua.polkovnik.SpringBootApp.models.MockDB;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookRest {

    @GetMapping("/getBook")
    Object getBooks(){
        return MockDB.getBooks();
    }
    @GetMapping("/getOneBook/{param}")
    List<Book> getOneBook(@PathVariable String param){
        List<Book> books = MockDB.getBooks();
        List<Book> b = new ArrayList<Book>();
        for(Book book : books){
         if(book.getName().equals(param) || book.getISBN().equals(param)){
             b.add(book);
             return b;
         }
        }
        return null;
    }

    @PostMapping("/addBook")
    public @ResponseBody Book addBook(@RequestBody Book bookReq){
        Book book = new Book(bookReq.getName(),
                bookReq.getAuthor(),
                bookReq.getISBN(),
                bookReq.getDescription());
        boolean hasBook = MockDB.insert(book);
       if(hasBook){
        return book;
       }
       return null;
    }
}
