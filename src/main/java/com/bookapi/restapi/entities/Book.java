package com.bookapi.restapi.entities;

// import com.bookapi.restapi.entities.Author;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;


@Entity
@Table(name = "books")
public class Book {
   
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;
    
    @Column(name = "book_title")
    private String title;

    //@cascade when we save the book entity containing author field, the associated Author entity will also be saved automatically
    @OneToOne(cascade = CascadeType.ALL)
    //create an object of author and its refernce is managed by JsonBackReference which will give it the Book object
    @JsonManagedReference
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }   
    
    
}
