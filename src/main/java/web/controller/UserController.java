package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;
    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("usersList", userDao.index());

        return "users/index";
    }

    @GetMapping("/edit")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userDao.show(id));

        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "users/new";
    }

    @PostMapping
    public String creat(@ModelAttribute("user") User user) {
        userDao.save(user);

        return "redirect:/users";
    }
}
