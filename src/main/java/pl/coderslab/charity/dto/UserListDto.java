package pl.coderslab.charity.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserListDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String authProvider;
    private Boolean enabled;
    private String password;
}
