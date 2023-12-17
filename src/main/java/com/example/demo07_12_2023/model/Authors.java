package com.example.demo07_12_2023.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    int authorId;


    @Getter
    @Setter
    @Column(name = "authors_name")
    private  String AuthorsName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )

    @Getter
    @Setter
    private List<Book> books;
    // Getters and setters, constructors, vb.



}
