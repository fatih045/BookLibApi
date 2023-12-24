package com.example.demo07_12_2023.controller;

import com.example.demo07_12_2023.model.Book;
import com.example.demo07_12_2023.model.User;
import com.example.demo07_12_2023.service.BookService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


    private final BookService bookService ;

    public BookController (BookService bookService ){
        this.bookService=bookService;
    }





    @GetMapping("/books/all")
    public List<Book> getAllBook() {

        return bookService.getBooks();
    }

    @GetMapping("/book/getByName/{name}")
    public Book getBookByName ( @PathVariable String name) {
        return  bookService.getBookByName(name);
    }

    @PostMapping("book/save")
    public Book addBook(@RequestBody Book book ){

        return  bookService.saveBook(book);
    }


    @DeleteMapping("/book/delete/{id}")

    public  String deleteBook(@PathVariable int id) {


        return  bookService.deleteBook(id);
    }



    @PutMapping ("/book/Update" )
    public  Book updateBook ( @RequestBody Book book) {

        return   bookService.updateBook(book);
    }

    @GetMapping("book/users/{id}")
    public ResponseEntity <List<User>> getUserByBook(@PathVariable int id){

        List<User> userList =bookService.getUserByBookId(id);

        if (userList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(userList);

    }





}
