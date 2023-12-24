package com.example.demo07_12_2023.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Getter
     @Setter
    public  int  bookId;


     @Getter
      @Setter
     public String bookName;



    @JsonIgnore
    @Getter
    @Setter
    @ManyToMany(mappedBy = "books")
    private List<User> users;


     @JsonIgnore
    @Getter
    @Setter
    @ManyToMany(mappedBy = "books")
    private List<Authors> authors;


}
