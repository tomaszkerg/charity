package pl.coderslab.charity.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.coderslab.charity.security.CustomUserService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Bean
    public CustomUserService customerUserService() {
        return new CustomUserService();
    }

//    @Bean
//    public CustomOAuth2UserService customOAuth2UserService() {
//        return new CustomOAuth2UserService();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customerUserService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/logout").authenticated()
                .antMatchers("/account", "/account/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/user", "/user/**").hasRole("USER")
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/form")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .clearAuthentication(true);
//                .and()
//                .httpBasic()
//                .disable()
//                .oauth2Login()
//                .loginPage("/login")
//                .defaultSuccessUrl("/", true);
//                .userInfoEndpoint();
//                .userService(customOAuth2UserService());
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/vendor/**","/fonts/**","/error");
    }

}
