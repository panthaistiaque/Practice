package com.example.webScriping.model;

/**
 * Created by Mohammad Istiaque Hossain (DS00688) on 31/Jul/2019.
 */
public class Movie {
    private Integer rank;
    private String name;
    private String director;
    private Integer releaseYear;
    private String length;
    private String[] genera;
    private String plot;

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String[] getGenera() {
        return genera;
    }

    public void setGenera(String[] genera) {
        this.genera = genera;
    }
}
