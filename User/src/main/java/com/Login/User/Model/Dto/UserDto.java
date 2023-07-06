package com.Login.User.Model.Dto;

import com.Login.User.Model.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;

    public static UserDto toDto(User entity){
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    public static User toEntity(UserDto Dto){
        return User.builder()
                .id(Dto.getId())
                .name(Dto.getName())
                .email(Dto.getEmail())
                .password(Dto.getPassword())
                .build();
    }
}
