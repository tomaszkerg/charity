package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.converter.UserConverter;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class UserService implements UserServiceI{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity save(UserDto userDto) {
        UserEntity userEntity = UserConverter.toEntity(userDto);
        return userRepository.save(userEntity);
    }
}
