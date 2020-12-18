package pl.coderslab.charity.converter;

import pl.coderslab.charity.dto.InstitutionShowTwoDto;
import pl.coderslab.charity.entity.InstitutionEntity;

public class InstitutionShowTwoConverter {

    public static InstitutionShowTwoDto toDto(InstitutionEntity firstInstitution,InstitutionEntity secondInstitution){
        return InstitutionShowTwoDto.builder()
                .firstName(firstInstitution.getName())
                .secondName(secondInstitution.getName())
                .firstDescription(firstInstitution.getDescription())
                .secondDescription(secondInstitution.getDescription())
                .build();
    }
}
