package com.detroitlabs.swapi.Controller;

import com.detroitlabs.swapi.Model.CharacterDetails.Results;
import com.detroitlabs.swapi.Model.MovieInfoAPI.Characters;
import com.detroitlabs.swapi.Service.SwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SwapiController {

    @Autowired
    SwapiService swapiService;

    @RequestMapping("/")
    public ModelAndView showIndexPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        Characters characters = swapiService.fetchMovieInfo().getCharacters();
        ArrayList<String> characterName = new ArrayList<>();
        for(String charactersInfo : characters){
            characterName.add(swapiService.fetchCharacterName(charactersInfo).getName());
        }
        modelAndView.addObject("characters", characterName);
        modelAndView.addObject("movietitle",swapiService.fetchMovieInfo().getTitle());
        return modelAndView;
    }

    @RequestMapping("showCharacterResults")
    public ModelAndView showResults(ModelAndView mv, @RequestParam("characterName")String starWarsCharacterName){
        mv.setViewName("results");

        Results result = swapiService.fetchInfoByName(starWarsCharacterName);

        mv.addObject("characterInfo", result.get(0));
        mv.addObject("homeplanet", swapiService.fetchPlanetName(result.get(0).getHomeworld()).getName());
        mv.addObject("pageTitle", result.get(0).getName());

        return mv;
    }

}
