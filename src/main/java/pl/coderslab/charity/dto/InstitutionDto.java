package pl.coderslab.charity.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstitutionDto {
    private Long id;
    private String name;
    private String description;
}
