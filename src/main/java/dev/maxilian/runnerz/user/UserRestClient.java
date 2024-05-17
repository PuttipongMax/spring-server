package dev.maxilian.runnerz.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class UserRestClient {
 private final RestClient restClient;

 public UserRestClient(RestClient.Builder builder){
  this.restClient = builder
   .baseUrl("http://jsonplaceholder.typicode.com/")
   .build();
 }
   List<User> findAll() {
        return restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    User findById(Integer id) {
        return restClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .body(User.class);
    }


}
