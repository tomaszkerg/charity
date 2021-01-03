package pl.coderslab.charity.converter;

import pl.coderslab.charity.dto.UserLoginDto;
import pl.coderslab.charity.entity.UserEntity;

public class UserLoginConverter {

    public static UserLoginDto toDto(UserEntity userEntity){
        return UserLoginDto.builder()
                .userId(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .build();
    }
}
