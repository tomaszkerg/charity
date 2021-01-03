package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.InstitutionDto;

import java.util.List;

public interface DonationServiceI {

    Integer returnNumberOfDonations();
    Integer returnNumberOfBags();
    List<CategoryDto> listOfCategories();
    List<InstitutionDto> listOfInstitutions();
}
