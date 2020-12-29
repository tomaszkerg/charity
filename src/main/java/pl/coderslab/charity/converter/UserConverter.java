package pl.coderslab.charity.converter;

import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.UserEntity;

public class UserConverter {

    public static UserEntity toEntity(UserDto userDto){
        return UserEntity.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .enabled(true)
                .password(userDto.getPassword())
                .authProvider("site")
                .build();
    }
}
