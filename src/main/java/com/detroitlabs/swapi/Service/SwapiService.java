package com.detroitlabs.swapi.Service;


import com.detroitlabs.swapi.Model.CharacterDetails.CharacterInfo;
import com.detroitlabs.swapi.Model.MovieInfoAPI.AllMovieInfo;
import com.detroitlabs.swapi.Model.MovieInfoAPI.Characters;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Component
public class SwapiService {

    public AllMovieInfo fetchMovieInfo(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Spring");

        ResponseEntity<AllMovieInfo> response = restTemplate.exchange("https://swapi.co/api/films/2/?format=json",
                HttpMethod.GET, new HttpEntity<>(headers), AllMovieInfo.class);
        return response.getBody();
    }


    public CharacterInfo fetchCharacterName(ArrayList<String> characterInfoLink) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Spring");

        ResponseEntity<CharacterInfo> response = restTemplate.exchange(characterInfoLink +"?format=json",
                HttpMethod.GET, new HttpEntity<>(headers), CharacterInfo.class);

        return response.getBody();
    }
}
