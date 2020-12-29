package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.UserEntity;

public interface UserServiceI {

    UserEntity save(UserDto userDto);
}
