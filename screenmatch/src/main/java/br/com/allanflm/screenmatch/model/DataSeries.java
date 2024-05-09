package br.com.allanflm.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeries(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons") Integer seasons,
                         @JsonAlias("imdbRating") String rating) {
}