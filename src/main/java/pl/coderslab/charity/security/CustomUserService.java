package pl.coderslab.charity.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.charity.repository.UserRepository;

import java.util.stream.Collectors;

@Slf4j
public class CustomUserService implements UserDetailsService {

    private UserRepository userRepository;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("searching for user by username '{}'", email);
        return userRepository.findByEmail(email)
                .map(user -> LoggedUser.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .active(user.getEnabled())
                        .authorities(user.getRoles()
                                .stream()
                                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                                .collect(Collectors.toSet()))
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono użytkownika: " + email));
    }
}
