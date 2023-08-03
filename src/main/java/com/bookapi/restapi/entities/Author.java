package com.bookapi.restapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;

// import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    private String firstName;

    private String lastName;

    private String language;

    //mappedBy - both tables will not manitain foriegn key this key will be managed by author field of related table
    @OneToOne(mappedBy = "author")
    //avoid looping of book into author 
    //doesn't create a object of book again inside author takes it from the parent Book class which has this author object
    @JsonBackReference
    private Book book;


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

     public Author(int authorId, String firstName, String lastName, String language, Book book) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.book = book;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
                + language + ", book=" + book + "]";
    }
    
    
}
