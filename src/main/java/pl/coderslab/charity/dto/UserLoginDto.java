package pl.coderslab.charity.dto;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDto {

    private Long userId;
    private String firstName;


}
