package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.InstitutionDto;
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
    @GetMapping("/admin/institution/{id}")
    public String formInstitution(@PathVariable Long id, Model model){
        model.addAttribute("institution",institutionService.getInstitution(id));
        return "formInstitution";
    }

    @GetMapping("/admin/institution")
    public String addInstitution(Model model){
        model.addAttribute("institution",new InstitutionDto());
        return "formInstitution";
    }
    @PostMapping("/admin/institution")
    public String submitInstitution(InstitutionDto institutionDto){
        institutionService.saveInstitution(institutionDto);
        return "redirect:/admin/institutions";
    }
}