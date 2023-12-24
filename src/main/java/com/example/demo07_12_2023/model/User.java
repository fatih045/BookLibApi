package com.example.demo07_12_2023.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Getter
    @Setter
     int id;

    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String userEmail;

    @Getter
    @Setter
    private String userPassword;



    @JoinTable(
            name = "user_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
   // @JsonIgnore
    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> books ;

    ;

}
