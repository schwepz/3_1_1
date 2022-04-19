package kata.academy.Springboot.controller;

import kata.academy.Springboot.model.User;
import kata.academy.Springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



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

    @PostMapping
    public String add(@ModelAttribute("index") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
