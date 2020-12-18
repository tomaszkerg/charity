package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.converter.InstitutionShowTwoConverter;
import pl.coderslab.charity.dto.InstitutionShowTwoDto;
import pl.coderslab.charity.entity.InstitutionEntity;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

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
}
