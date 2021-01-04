package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.dto.UserListDto;
import pl.coderslab.charity.dto.UserLoginDto;
import pl.coderslab.charity.entity.UserEntity;

import java.util.List;

public interface UserServiceI {

    UserEntity save(UserDto userDto);
    String getFirstNameByEmail(String email);
    Long getIdByEmail(String email);
    List<UserListDto> getAllUsers();
    UserListDto getUser(Long id);
    UserEntity adminSave(UserListDto userListDto);

}
