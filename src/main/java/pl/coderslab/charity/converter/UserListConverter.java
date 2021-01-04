package pl.coderslab.charity.converter;

import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.dto.UserListDto;
import pl.coderslab.charity.dto.UserLoginDto;
import pl.coderslab.charity.entity.UserEntity;

public class UserListConverter {

    public static UserListDto toDto(UserEntity userEntity){
        return UserListDto.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .enabled(userEntity.getEnabled())
                .authProvider(userEntity.getAuthProvider())
                .build();
    }

    public static UserEntity toEntity(UserListDto userListDto){
        return UserEntity.builder()
                .email(userListDto.getEmail())
                .firstName(userListDto.getFirstName())
                .lastName(userListDto.getLastName())
                .enabled(userListDto.getEnabled())
                .password(userListDto.getPassword())
                .authProvider(userListDto.getAuthProvider())
                .build();
    }
}
