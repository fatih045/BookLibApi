package com.example.demo07_12_2023.controller;

import com.example.demo07_12_2023.model.Authors;
import com.example.demo07_12_2023.model.Book;
import com.example.demo07_12_2023.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private  final AuthorService authorService;


    public AuthorController (AuthorService authorService) {
        this.authorService=authorService;
    }




    @GetMapping("/authors")
    public List<Authors>getAllAuthors () {

        return  authorService.getAllAuthors();
    }


    @DeleteMapping("/authors/delete/{id}")

    public String deleteAuthors( @PathVariable  int id){
      return   authorService.deleteAuthors(id);
    }


    @PostMapping( "authors/add")
    public Authors addAuthors(@RequestBody Authors authors) {

        return authorService.saveAuthors(authors);
    }


    @PutMapping ("authors/update")
    public Authors updateBook(@RequestBody Authors authors)  {

        return  authorService.updateAuthors(authors);
    }




    @GetMapping("authors/authorsBook/{id}")

    public ResponseEntity <List<Book>> getAuthorsBook (  @PathVariable int id) {
        List<Book> authorsbook=authorService.getAuthorsBook(id);


        if (authorsbook.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(authorsbook);
    }




}
