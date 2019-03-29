package Service;

import Model.AllMovieInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
}
