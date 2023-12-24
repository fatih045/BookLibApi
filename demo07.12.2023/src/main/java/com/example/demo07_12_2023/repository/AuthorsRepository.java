package com.example.demo07_12_2023.repository;

import com.example.demo07_12_2023.model.Authors;
import com.example.demo07_12_2023.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorsRepository extends JpaRepository<Authors,Integer> {







}
