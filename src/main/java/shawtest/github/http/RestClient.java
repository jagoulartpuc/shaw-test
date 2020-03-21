package shawtest.github.http;

import java.util.List;
import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import shawtest.github.domain.User;


@Data
@Component
public class RestClient {

    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClient() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    public List<User> getGithubUsers(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        var type = new ParameterizedTypeReference<List<User>>() {};
        ResponseEntity<List<User>> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, type);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

}
