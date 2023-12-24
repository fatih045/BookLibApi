package com.example.demo07_12_2023.service;


import com.example.demo07_12_2023.UserMapper;
import com.example.demo07_12_2023.model.Book;
import com.example.demo07_12_2023.model.User;
import com.example.demo07_12_2023.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;



    public UserService (UserRepository userRepository, UserMapper userMapper) {
        this.userRepository=userRepository;

    }
    public List <User> denek(){

        return userRepository.findAll();
    }





    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserwithName(String name){

        return  userRepository.findByUserName(name);
    }

    public User saveUser(User user) {

        return  userRepository.save(user);

    }

    public String deleteById(int id) {
        userRepository.deleteById(id);
        return "User Deleted"+ id;
    }

    public List<Book> getUserBooks(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getBooks();

        } else {
            // Kullanıcı bulunamadı veya kitapları yoksa boş liste dönebilirsiniz.
            return Collections.emptyList();
        }
    }


    public int getUserBookNumber (int id) {

      return   getUserBooks(id).size();
    }

    public User updateUser(User user) {

        User existingUser=userRepository.findById(user.getId()).orElse(null);

        existingUser.setUserName(user.getUserName());

       existingUser.setUserPassword(user.getUserPassword());

       existingUser.setUserEmail((user.getUserEmail()));

       return existingUser;

    }
}
