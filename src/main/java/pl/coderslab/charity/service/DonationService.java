package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.converter.CategoryConverter;
import pl.coderslab.charity.converter.InstitutionConverter;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.entity.DonationEntity;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationService implements DonationServiceI{

    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }


    @Override
    public Integer returnNumberOfDonations() {
        return donationRepository.findAll().size();
    }

    @Override
    public Integer returnNumberOfBags() {
        return donationRepository.findAll().stream()
                .mapToInt(DonationEntity::getQuantity)
                .sum();
    }

    @Override
    public List<CategoryDto> listOfCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstitutionDto> listOfInstitutions() {
        return institutionRepository.findAll().stream()
                .map(InstitutionConverter::toDto)
                .collect(Collectors.toList());
    }
}
