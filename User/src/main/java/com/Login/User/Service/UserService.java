package com.Login.User.Service;

import com.Login.User.Model.Entity.User;
import com.Login.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    //find user by id
    public User getUser(Integer id) {
        Optional<User> u = userRepo.findById(id);
        return u.orElse(null);
    }

    //create new user
    public void save(User u){
        System.out.println(u);
        userRepo.save(u);
    }

    // get all user
    public List<User> getAll() {
        return userRepo.findAll();
    }

    //find user by email
    public Boolean getByEmail(String email) {
        if(userRepo.findByEmail(email).isEmpty()){
            return false;
        }
        return true;
    }
}
