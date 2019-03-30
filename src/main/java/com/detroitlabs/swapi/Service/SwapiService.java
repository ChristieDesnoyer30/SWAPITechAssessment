package com.detroitlabs.swapi.Service;


import com.detroitlabs.swapi.Model.CharacterDetails.AllCharacterInfo;
import com.detroitlabs.swapi.Model.CharacterDetails.CharacterInfo;
import com.detroitlabs.swapi.Model.CharacterDetails.Results;
import com.detroitlabs.swapi.Model.MovieInfoAPI.AllMovieInfo;
import com.detroitlabs.swapi.Model.MovieInfoAPI.Characters;
import com.detroitlabs.swapi.Model.PlanetAPIInfo.PlanetInfo;
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


    public CharacterInfo fetchCharacterName(String characterInfo) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Spring");
        ResponseEntity<CharacterInfo> response = restTemplate.exchange(characterInfo +"?format=json",
                HttpMethod.GET, new HttpEntity<>(headers), CharacterInfo.class);
        return response.getBody();
    }

    public Results fetchInfoByName(String characterName) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Spring");
        ResponseEntity<AllCharacterInfo> response = restTemplate.exchange("https://swapi.co/api/people/?search=" + characterName,
                HttpMethod.GET, new HttpEntity<>(headers), AllCharacterInfo.class);
       return response.getBody().getResults();
    }

    public PlanetInfo fetchPlanetName(String planetAPICall){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Spring");
        ResponseEntity<PlanetInfo> response = restTemplate.exchange( planetAPICall+ "?format=json",
                HttpMethod.GET, new HttpEntity<>(headers), PlanetInfo.class);
        return response.getBody();
    }

}
