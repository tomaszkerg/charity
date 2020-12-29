package pl.coderslab.charity.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
