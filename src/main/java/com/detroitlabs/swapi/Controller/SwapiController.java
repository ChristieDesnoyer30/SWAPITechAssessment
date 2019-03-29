package com.detroitlabs.swapi.Controller;

import com.detroitlabs.swapi.Model.MovieInfoAPI.Characters;
import com.detroitlabs.swapi.Service.SwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SwapiController {

    @Autowired
    SwapiService swapiService;

    @RequestMapping("/")
    public ModelAndView showIndexPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        ArrayList<String> charactersLink = swapiService.fetchMovieInfo().getCharacters();

         modelAndView.addObject("charactersNames", charactersLink);


        return modelAndView;
    }

}
