package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.converter.UserConverter;
import pl.coderslab.charity.converter.UserListConverter;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.dto.UserListDto;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserListDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserListConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserListDto getUser(Long id) {
        return UserListConverter.toDto(userRepository.getOne(id));
    }

    @Override
    public UserEntity adminSave(UserListDto userListDto) {
        if(userListDto.getId()==null){
            return userRepository.save(UserListConverter.toEntity(userListDto));
        }else{
            UserEntity userEntity = userRepository.getOne(userListDto.getId());
            userEntity.setEmail(userEntity.getEmail());
            userEntity.setFirstName(userListDto.getFirstName());
            userEntity.setLastName(userListDto.getLastName());
            userEntity.setEnabled(userListDto.getEnabled());
            userEntity.setAuthProvider(userListDto.getAuthProvider());
            return userRepository.save(userEntity);
        }
    }
}
