package com.itMentor.Task8.controller;

import com.itMentor.Task8.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.itMentor.Task8.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users1", userService.listUsers());
        return "users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable(value = "id") Long id, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        user.setId(id);
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newUser";
    }

}
