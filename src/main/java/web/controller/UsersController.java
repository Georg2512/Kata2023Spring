package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {
    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(defaultValue="5") Integer count, ModelMap model) {
        model.addAttribute("userList", "Test");
        return "users";
    }
}
