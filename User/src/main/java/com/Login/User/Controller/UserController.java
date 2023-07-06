package com.Login.User.Controller;

import com.Login.User.Model.Dto.UserDto;
import com.Login.User.Model.Entity.User;
import com.Login.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/pry")
    public String print(){
        System.out.println("abas");
        return "555";
    }

    @GetMapping("/get-user/{id}")
    public UserDto getUser(@PathVariable Integer id){
        return UserDto.toDto(userService.getUser(id));
    }

    @PostMapping("/save-user")
    public void getUser(@RequestBody UserDto uDto){
        userService.save(UserDto.toEntity(uDto));
    }

    @GetMapping("/get-all-user")
    public List<UserDto> getAllUser(){
        return userService.getAll().stream().map(UserDto::toDto).collect(Collectors.toList());
    }

    @GetMapping("/find-email/{email}")
    public Boolean getByEmail(@PathVariable String email){
         return userService.getByEmail(email);
    }

}
