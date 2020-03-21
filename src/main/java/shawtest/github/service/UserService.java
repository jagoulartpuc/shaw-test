package shawtest.github.service;
;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shawtest.github.domain.Repository;
import shawtest.github.domain.User;
import shawtest.github.domain.UserDetailed;
import shawtest.github.http.RestClient;

@Service
public class UserService {

    @Autowired
    private RestClient restClient;

    public List<User> getGithubUsersSince(String uri) {
        return  restClient.getGithubUsers(uri);
    }

    public UserDetailed getGithubUserDetails(String uri) {
        return restClient.getGithubUserDetails(uri);
    }

    public List<Repository> getGithubUserRepositories(String uri) {
        return restClient.getGithubUserRepos(uri);
    }
}