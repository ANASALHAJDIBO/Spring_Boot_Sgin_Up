package com.Login.User.Repository;

import com.Login.User.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User , Integer> {

    List<User> findByEmail(String Email);
}
