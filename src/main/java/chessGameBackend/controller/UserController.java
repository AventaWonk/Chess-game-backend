package chessGameBackend.controller;

import chessGameBackend.model.User;
import chessGameBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/add")
    public String addUser(User user) {
        if (userService.isUserExists(user.getLogin())) {

        }

        userService.addUser(user);
    }

    @PostMapping(value = "/delete")
    public String deleteUser(int id) {
        userService.deleteUser(id);
    }

    @PostMapping(value = "/update")
    public String updateUser(User user) {
        userService.updateUser(user);
    }

}
