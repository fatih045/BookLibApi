package com.example.demo07_12_2023.repository;

import com.example.demo07_12_2023.model.Book;
import com.example.demo07_12_2023.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


   Book findByBookName(String bookName);






}
