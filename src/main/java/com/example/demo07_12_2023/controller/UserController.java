package com.example.demo07_12_2023.controller;

import com.example.demo07_12_2023.model.Book;
import com.example.demo07_12_2023.model.User;
import com.example.demo07_12_2023.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController

public class UserController {


    private final UserService userService ;

    public UserController (UserService userService) {
        this.userService=userService;
    }




    @GetMapping("/getUserWithName/{name}")
    public  User getUserWithName( @PathVariable String name) {

        return userService.getUserwithName(name);
    }

    @GetMapping("/allUsers")
    public List<User> findallUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public  User addUser(@RequestBody User user) {
        return  userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteById(id);
    }

    // üstekiler çalışıyor


    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {

        return userService.updateUser(user);
    }



    //

    @GetMapping("/{userId}/books")
    public ResponseEntity<List<Book>> getUserBooks(@PathVariable int userId) {
        List<Book> userBooks = userService.getUserBooks(userId);

        if (userBooks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(userBooks);
    }


}
