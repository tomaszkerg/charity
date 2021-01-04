package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.converter.InstitutionConverter;
import pl.coderslab.charity.converter.InstitutionShowTwoConverter;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.dto.InstitutionShowTwoDto;
import pl.coderslab.charity.entity.InstitutionEntity;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitutionService implements InstitutionServiceI{

    private final InstitutionRepository institutionRepository;

    @Autowired
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }


    @Override
    public int multiply(int number){
        return number*number;
    }

    @Override
    public List<InstitutionShowTwoDto> homePageInstitutions() {
        List<InstitutionEntity> institutions = institutionRepository.findAll();
        List<InstitutionShowTwoDto> twoInstitutions = new ArrayList<>();
        for (int i = 0; i < institutions.size()-1; i=i+2) {
            twoInstitutions.add(InstitutionShowTwoConverter.toDto(institutions.get(i),institutions.get(i+1)));
        }
        return twoInstitutions;
    }

    @Override
    public List<InstitutionDto> listOfInstitutions() {
        return institutionRepository.findAll().stream()
                .map(InstitutionConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public InstitutionEntity saveInstitution(InstitutionDto institutionDto) {
        if(institutionDto.getId()==null){
            return institutionRepository.save(InstitutionConverter.toEntity(institutionDto));

        }else {
            InstitutionEntity institution = institutionRepository.getOne(institutionDto.getId());
            institution.setEnabled(institutionDto.getEnabled());
            institution.setName(institutionDto.getName());
            institution.setDescription(institutionDto.getDescription());
            return institutionRepository.save(institution);
        }
    }

    @Override
    public InstitutionDto getInstitution(Long id) {
        return InstitutionConverter.toDto(institutionRepository.getOne(id));
    }

}