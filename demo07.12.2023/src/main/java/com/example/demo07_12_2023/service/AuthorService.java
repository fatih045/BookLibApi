package com.example.demo07_12_2023.service;

import com.example.demo07_12_2023.model.Authors;
import com.example.demo07_12_2023.model.Book;
import com.example.demo07_12_2023.model.User;
import com.example.demo07_12_2023.repository.AuthorsRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {


    private final AuthorsRepository authorsRepository;

    public AuthorService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }


    public List<Authors> getAllAuthors() {

        return authorsRepository.findAll();
    }

    public Authors saveAuthors(Authors authors) {
        return authorsRepository.save(authors);
    }

    public String deleteAuthors(int id) {
        authorsRepository.deleteById(id);
        return "authors deleted" + id;
    }


    // HATALI Alltaki

    public Authors updateAuthors(Authors authors) {

        Authors existing = authorsRepository.findById(authors.getAuthorId()).orElse(null);


        if (existing != null) {
            existing.setAuthorsName(authors.getAuthorsName());
        }

        return existing;

    }


    public List<Book> getAuthorsBook(int id) {

        Optional<Authors> authorsOptional = authorsRepository.findById(id);
        if (authorsOptional.isPresent()) {
            Authors authors = authorsOptional.get();
            return authors.getBooks();
        } else
            return Collections.emptyList();


    }

}
