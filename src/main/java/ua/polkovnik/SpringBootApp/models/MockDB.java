package ua.polkovnik.SpringBootApp.models;

import java.util.*;


public class MockDB {
    private static List<Book> books = new ArrayList<>();

    public static boolean insert(Book book){
       return books.add(book);
    }

    public static List<Book> getBooks(){
        return books;
    }

}
