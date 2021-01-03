package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.entity.DonationEntity;
import pl.coderslab.charity.service.CategoryServiceI;
import pl.coderslab.charity.service.DonationServiceI;
import pl.coderslab.charity.service.InstitutionServiceI;

import java.util.List;

@Controller
public class DonationController {

    private DonationServiceI donationService;
    private CategoryServiceI categoryService;
    private InstitutionServiceI institutionService;

    public DonationController(DonationServiceI donationService, CategoryServiceI categoryService, InstitutionServiceI institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("donation",new DonationEntity());
        return "form";
    }


    @ModelAttribute("categories")
    public List<CategoryDto> loadCategories(){
        return donationService.listOfCategories();
    }

    @ModelAttribute("institutions")
    public List<InstitutionDto> loadInstitutions(){
        return donationService.listOfInstitutions();
    }

}
