package ua.polkovnik.SpringBootApp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String name;
    private String author;
    private String ISBN;
    private String description;

    public Book(String bookName,String bookAuth,String bookISBN,String bookDesc){
        this.name = bookName;
        this.author = bookAuth;
        this.ISBN = bookISBN;
        this.description = bookDesc;
    }

    @Override
    public String toString(){
        return "Name: "+ this.name + ", author: " + this.author + ", ISBN: " + this.ISBN
                +", description: " + this.description;
    }
}
