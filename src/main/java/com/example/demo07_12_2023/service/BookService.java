package com.example.demo07_12_2023.service;


import com.example.demo07_12_2023.model.Book;
import com.example.demo07_12_2023.model.User;
import com.example.demo07_12_2023.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    private  final BookRepository bookRepository;

    public BookService (BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }



    public List<Book> getBooks () {
        return  bookRepository.findAll();
    }


    public  Book getBookByName(String name) {
        return
                bookRepository.findByBookName(name);
    }




    public Book saveBook (Book book) {

        return bookRepository.save(book);
    }


    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "Book deleted"+ id;
    }

    public Book updateBook(Book book) {


        Book existingBook =bookRepository.findById(book.bookId).orElse(null);


        existingBook.setBookName(book.getBookName());

        return  bookRepository.save(existingBook);
    }

//    public List<User> getUsersByBookName(String bookName) {
//        Book books = bookRepository.findByBookName(bookName);
//
//
//        if (books != null) {
//            return books.getUsers();
//        } else
//            return  Collections.emptyList();
//    }




    }





