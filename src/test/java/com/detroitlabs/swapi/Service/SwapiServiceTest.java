package com.detroitlabs.swapi.Service;

import com.detroitlabs.swapi.Model.CharacterDetails.CharacterInfo;
import com.detroitlabs.swapi.Model.MovieInfoAPI.AllMovieInfo;
import org.junit.Assert;
import org.junit.Test;

public class SwapiServiceTest {

    @Test
    public void shouldFetchMovieInfoForEmpireStrikesBack() {
        SwapiService swapiService = new SwapiService();
        AllMovieInfo allMovieInfo = swapiService.fetchMovieInfo();

        Assert.assertEquals("The Empire Strikes Back", allMovieInfo.getTitle());
    }

    @Test
    public void shouldDisplayCharactersNames(){
        SwapiService swapiService = new SwapiService();
        CharacterInfo characterInfo = swapiService.fetchCharacterName("https://swapi.co/api/people/1/");
        Assert.assertEquals("Luke Skywalker", characterInfo.getName());

    }
}