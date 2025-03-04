package edu.miu.waa.homework.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserDto {
    long id;
    String name;
    String Username;
    public UserDto() {
    }
}
