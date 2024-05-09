package br.com.allanflm.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisode(@JsonAlias("Title") String title,
                          @JsonAlias("Episode") Integer episode,
                          @JsonAlias("imdebRating") String imdbRating,
                          @JsonAlias("Released") String releaseDate) {
}
