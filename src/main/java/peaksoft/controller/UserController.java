package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.User;
import peaksoft.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/userMain")
    public String getMainPage(){
        return "user/userMain";
    }
    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "user/users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "user/saveUser";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user")User user){
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/updateUser")
    public String updateUser(@PathVariable("id")Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("userUpdate",user);
        return "user/userUpdate";
    }
    @PostMapping("/{id}")
    public String saveUserUpdate(@PathVariable("id")Long id,@ModelAttribute("userUpdate")User user){
        userService.updateUser(id,user);
        return "redirect:/users";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id")Long id){
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }
}
