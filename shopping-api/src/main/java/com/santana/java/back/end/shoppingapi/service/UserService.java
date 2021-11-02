package com.santana.java.back.end.shoppingapi.service;

import com.santana.java.back.end.client.model.dto.UserDTO;
import com.santana.java.back.end.shoppingapi.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    @Value("${USER_API_URL:http://localhost:8080/user}")
    private String userApiUrl;

    public UserDTO getUserByCpf(String cpf, String key){
        try {
            RestTemplate restTemplate = new RestTemplate();

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userApiUrl + "/cpf/" + cpf);
            builder.queryParam("key", key);

            ResponseEntity<UserDTO> response = restTemplate.getForEntity(builder.toUriString(), UserDTO.class);
            return response.getBody();
        } catch(HttpClientErrorException.NotFound ex){
            throw new UserNotFoundException();
        }
    }
}
