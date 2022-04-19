package kata.academy.Springboot.controller;

import kata.academy.Springboot.model.User;
import kata.academy.Springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printUsers(ModelMap model) {
        model.addAttribute(userService.listUsers());
        return "index";
    }

    @GetMapping("/user-create")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @PostMapping
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-update";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user,  @PathVariable("id") long id) {
        userService.updateUser(user);
        return "redirect:/";
    }
}