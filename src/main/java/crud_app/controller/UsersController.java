package crud_app.controller;

import crud_app.model.User;
import crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private UserService userService;


    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    @GetMapping( "/users")
    public String showAllUsers(Model model){

        model.addAttribute("allUsers", userService.getAllUsers());

        return "/users/list";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("newUser",new User());
        return "/users/new";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("newUser") User user){
        userService.addUser(user);
        return "redirect:/users";
    }
}
