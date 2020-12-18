package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationServiceI;
import pl.coderslab.charity.service.InstitutionServiceI;


@Controller
public class HomeController {

    private InstitutionServiceI institutionService;
    private DonationServiceI donationService;


    @Autowired
    public HomeController(InstitutionServiceI institutionService,
                          DonationServiceI donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions",institutionService.homePageInstitutions());
        model.addAttribute("numOfDonations",donationService.returnNumberOfDonations());
        model.addAttribute("numOfBags",donationService.returnNumberOfBags());
        return "index";
    }
}
