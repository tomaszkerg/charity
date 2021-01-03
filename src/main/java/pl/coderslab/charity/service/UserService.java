package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.converter.UserConverter;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class UserService implements UserServiceI{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity save(UserDto userDto) {
        UserEntity userEntity = UserConverter.toEntity(userDto);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public String getFirstNameByEmail(String email) {
            return userRepository.findFirstnameByEmail(email);
    }

    @Override
    public Long getIdByEmail(String email) {
            return userRepository.findUserIdByEmail(email);

    }
}
