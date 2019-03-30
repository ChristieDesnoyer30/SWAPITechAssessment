package com.detroitlabs.swapi.Model.CharacterDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results extends ArrayList<CharacterInfo> {
}
