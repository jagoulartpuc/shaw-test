package shawtest.github.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shawtest.github.domain.Repository;
import shawtest.github.domain.User;
import shawtest.github.domain.UserDetailed;
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

    @GetMapping("/users/{login}/details")
    public UserDetailed getUserDetails(
            @PathVariable String login
    ) {
        String uri = "https://api.github.com/users/" + login;
        return userService.getGithubUserDetails(uri);
    }

    @GetMapping("/users/{login}/repos")
    public List<Repository> getUserRepos(
            @PathVariable String login
    ) {
        String uri = "https://api.github.com/users/" + login + "/repos";
        return userService.getGithubUserRepositories(uri);
    }

}
