package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.InstitutionService;

@Controller
public class InstitutionController {

    private final InstitutionService institutionService;


    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/admin/institutions")
    public String institutionList(Model model){
        model.addAttribute("institutions",institutionService.listOfInstitutions());
        return "institutionList";
    }
}