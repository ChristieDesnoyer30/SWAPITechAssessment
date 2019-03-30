package com.detroitlabs.swapi.Service;

import com.detroitlabs.swapi.Model.CharacterDetails.AllCharacterInfo;
import com.detroitlabs.swapi.Model.CharacterDetails.CharacterInfo;
import com.detroitlabs.swapi.Model.CharacterDetails.Results;
import com.detroitlabs.swapi.Model.MovieInfoAPI.AllMovieInfo;
import com.sun.deploy.net.HttpResponse;
import org.apache.coyote.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.IsEqual.equalTo;

public class SwapiServiceTest {

    @Test
    public void shouldFetchMovieInfoForEmpireStrikesBack() {
        SwapiService swapiService = new SwapiService();
        AllMovieInfo allMovieInfo = swapiService.fetchMovieInfo();

        Assert.assertEquals("The Empire Strikes Back", allMovieInfo.getTitle());
    }

@Test
    public void shouldFetchResultsFromCharacters(){
    SwapiService swapiService = new SwapiService();
     Results results = swapiService.fetchInfoByName("Luke Skywalker");
     Assert.assertEquals("male", results.get(0).getGender());
}

    @Test
    public void shouldFetch200Response(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Spring");
        ResponseEntity<AllCharacterInfo> response = restTemplate.exchange("https://swapi.co/api/people/?search=" + "Luke Skywalker",
                HttpMethod.GET, new HttpEntity<>(headers), AllCharacterInfo.class);
       Assert.assertThat(200,equalTo(response.getStatusCodeValue()));
    }

}