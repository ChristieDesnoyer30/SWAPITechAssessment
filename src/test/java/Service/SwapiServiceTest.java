package Service;

import Model.AllMovieInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class SwapiServiceTest {

    @Test
    public void shouldFetchMovieInfoForEmpireStrikesBack() {
        SwapiService swapiService = new SwapiService();
        AllMovieInfo allMovieInfo = swapiService.fetchMovieInfo();

        Assert.assertEquals("The Empire Strikes Back", allMovieInfo.getTitle());
    }
}