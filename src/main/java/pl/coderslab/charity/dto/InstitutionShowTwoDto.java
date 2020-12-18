package pl.coderslab.charity.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstitutionShowTwoDto {

    private String firstName;
    private String secondName;
    private String firstDescription;
    private String secondDescription;
}
