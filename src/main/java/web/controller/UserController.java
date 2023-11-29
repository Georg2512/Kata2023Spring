package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;


@Controller
public class UserController {
    private final UserDao userDao;
    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @ModelAttribute("newUser")
    public User getPerson(){
        return new User();
    }
    @GetMapping("/user")
	public String index(Model model){
    	model.addAttribute("user",userDao.getAllUsers());
    	return "view/user";
	}

    @PostMapping("/user")
    public String listUsers(@ModelAttribute("newUser") User user,
                        BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("user",userDao.getAllUsers());
            return "view/user";
        }
        userDao.saveUser(user);
    	return "redirect:/user";
    }

    @DeleteMapping("/user/{id}")
    public String deletePerson(@PathVariable("id") int id){
        userDao.removeUserById(id);
        return "redirect:/user";
    }
    @GetMapping("/user/{id}/edit")
    public String editUser (@ModelAttribute("id") int id,Model model){
        model.addAttribute("user",userDao.getUserById(id));
        return "view/edit";
    }

    @PatchMapping("/user/{id}")
    public String updateUser(@ModelAttribute("user") User updateUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "view/edit";
        }
        userDao.updateUser(updateUser);
        return "redirect:/user";
    }
}