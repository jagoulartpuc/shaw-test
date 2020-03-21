package shawtest.github;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import shawtest.github.domain.Repository;
import shawtest.github.domain.User;
import shawtest.github.domain.UserDetailed;
import shawtest.github.http.RestClient;
import shawtest.github.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private RestClient restClient;

    @Test
    public void serviceShouldCallGetUsersProperly() {

        List<User> users = new ArrayList<>();
        User u1 = new User();
        User u2 = new User();
        users.add(u1);
        users.add(u2);

        String uri = "uri";

        given(restClient.getGithubUsers(uri)).willReturn(users);

        userService.getGithubUsersSince("uri");

        verify(restClient).getGithubUsers( "uri");
    }

    @Test
    public void serviceShouldCallGetUserDetailsProperly() {

        UserDetailed user = new UserDetailed();

        String uri = "uri";

        given(restClient.getGithubUserDetails(uri)).willReturn(user);

        userService.getGithubUserDetails("uri");

        verify(restClient).getGithubUserDetails( "uri");
    }

    @Test
    public void serviceShouldCallGetUserReposProperly() {

        Repository r1 = new Repository();
        Repository r2 = new Repository();

        List<Repository> repos = new ArrayList<>();
        repos.add(r1);
        repos.add(r2);

        String uri = "uri";

        given(restClient.getGithubUserRepos(uri)).willReturn(repos);

        userService.getGithubUserRepositories("uri");

        verify(restClient).getGithubUserRepos( "uri");
    }
}
