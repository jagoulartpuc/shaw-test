package shawtest.github.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shawtest.github.domain.User;
import shawtest.github.http.RestClient;

@Service
public class UserService {

    @Autowired
    private RestClient restClient;

    public List<User> getGithubUsersSince(String uri) {
        return  restClient.getGithubUsers(uri);
    }

    private User getUserById(long id, List<User> users) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public User getGithubUserDetails(String login) { return new User();}

    private User getUserByLogin(String login, List<User> users) {
        return users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElseThrow();
    }
}