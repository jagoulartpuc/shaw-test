package shawtest.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shawtest.github.domain.User;
import shawtest.github.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(
            @RequestParam String since
    ) {
        String uri = "https://api.github.com/users?since=" + since;
        return userService.getGithubUsersSince(uri);
    }

    @GetMapping("/users/{login}")
    public User getUserDetails(
            @PathVariable String login
    ) {
        return userService.getGithubUserDetails(login);
    }

}
