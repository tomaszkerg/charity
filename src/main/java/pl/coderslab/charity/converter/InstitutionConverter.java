package pl.coderslab.charity.converter;

import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.entity.InstitutionEntity;

public class InstitutionConverter {

    public static InstitutionDto toDto(InstitutionEntity institution){
        return InstitutionDto.builder()
                .id(institution.getId())
                .name(institution.getName())
                .description(institution.getDescription())
                .enabled(institution.getEnabled())
                .build();
    }
    public static InstitutionEntity toEntity(InstitutionDto institutionDto){
        InstitutionEntity institution = new InstitutionEntity();
        institution.setId(institutionDto.getId());
        institution.setName(institutionDto.getName());
        institution.setDescription(institutionDto.getDescription());
        institution.setEnabled(institutionDto.getEnabled());
        return institution;
    }
}
