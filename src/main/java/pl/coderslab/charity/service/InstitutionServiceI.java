package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.dto.InstitutionShowTwoDto;

import java.util.List;

public interface InstitutionServiceI {

    public int multiply(int number);
    List<InstitutionShowTwoDto> homePageInstitutions();
    List<InstitutionDto> listOfInstitutions();
}