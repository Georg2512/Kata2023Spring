package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.services.UserService;


@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("user", userService.getAllUsers());
        return "view/user";
    }

    @ModelAttribute("newUser")
    public User getUser(){
        return new User();
    }
    @GetMapping("/user")
	public String index(Model model){
    	model.addAttribute("user", userService.getAllUsers());
    	return "view/user";
	}

    @PostMapping("/user")
    public String listUsers(@ModelAttribute("newUser") User user,
                        BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("user", userService.getAllUsers());
            return "view/user";
        }
        userService.saveUser(user);
    	return "redirect:/user";
    }

    @DeleteMapping("/user/{id}")
    public String deletePerson(@PathVariable("id") int id){
        userService.removeUserById(id);
        return "redirect:/user";
    }
    @GetMapping("/user/{id}/edit")
    public String editUser (@ModelAttribute("id") int id,Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "view/edit";
    }

    @PatchMapping("/user/{id}")
    public String updateUser(@ModelAttribute("user") User updateUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "view/edit";
        }
        userService.updateUser(updateUser);
        return "redirect:/user";
    }
}