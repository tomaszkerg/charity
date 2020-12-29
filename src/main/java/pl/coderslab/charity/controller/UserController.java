package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        return "/login";
    }

    @GetMapping("/register")
    public String getFrom(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "/register";
    }
    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute(name = "userDto") UserDto userDto,
                             Model model, BindingResult result){
        if(result.hasErrors()){
            return "/register";
        }
        userService.save(userDto);
        return "redirect:";
    }
}
