package com.detroitlabs.swapi.Model.MovieInfoAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Characters extends ArrayList<String>{

}
