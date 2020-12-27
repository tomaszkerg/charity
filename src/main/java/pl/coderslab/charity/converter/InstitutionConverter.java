package pl.coderslab.charity.converter;

import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.entity.InstitutionEntity;

public class InstitutionConverter {

    public static InstitutionDto toDto(InstitutionEntity institution){
        return InstitutionDto.builder()
                .id(institution.getId())
                .name(institution.getName())
                .description(institution.getDescription())
                .build();
    }
}
