package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.dto.UserListDto;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.utils.UserUtils;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/admin")
    public String adminPanel(Model model) {
        return "adminPanel";
    }

    @ModelAttribute("firstName")
    public String loadFirstName(){
        return userService.getFirstNameByEmail(UserUtils.username());
    }

    @ModelAttribute("userId")
    public Long loadUserId(){
        return userService.getIdByEmail(UserUtils.username());
    }

    @GetMapping("/admin/userList")
    public String userList(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "userList";
    }
    @GetMapping("/admin/user/{id}")
    public String editUser(@PathVariable Long id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "formUser";
    }
    @GetMapping("/admin/user")
    public String addUser(Model model){
        model.addAttribute("user",new UserListDto());
        return "formUser";
    }

    @PostMapping("/admin/user")
    public String submitUser(UserListDto userListDto){
        userService.adminSave(userListDto);
        return "userList";
    }
}
