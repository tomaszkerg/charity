package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.CategoryServiceI;
import pl.coderslab.charity.service.DonationServiceI;
import pl.coderslab.charity.service.InstitutionServiceI;

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
    public String getForm(){
        return "form";
    }


}
