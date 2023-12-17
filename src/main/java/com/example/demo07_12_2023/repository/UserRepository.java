package com.example.demo07_12_2023.repository;

import com.example.demo07_12_2023.model.Book;
import com.example.demo07_12_2023.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {




   User findByUserName(String name);


   List<Book> findBooksById(int userId);



}
