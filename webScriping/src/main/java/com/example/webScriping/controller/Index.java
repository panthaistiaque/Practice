package com.example.webScriping.controller;

import com.example.webScriping.model.Movie;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad Istiaque Hossain (DS00688) on 31/Jul/2019.
 */
@RestController
public class Index {
    @RequestMapping("/index")
    public List index() {
        List<Movie> list = new ArrayList<>();
        String url = "https://www.imdb.com/list/ls058813655/";
        Document doc = null;
        Connection connection = Jsoup.connect(url);
        connection.userAgent("Mozilla");
        connection.timeout(5000);
        connection.cookie("cookiename", "val234");
        connection.cookie("cookiename", "val234");
        connection.referrer("http://google.com");
        connection.header("headersecurity", "xyz123");
        try {
            doc = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /***Selecting with Id ***/
        Elements mainDiv = doc.select(".lister-item-content");
        for (Element main : mainDiv) {
            Movie movie = new Movie();
            Elements breadCrumbs = main.select(".lister-item-header");
            for (Element breadCrumb : breadCrumbs) {
                Elements ranks = breadCrumb.select(".lister-item-index");
                for (Element element : ranks) {
                    movie.setRank(Integer.parseInt(element.text().replaceAll("[^\\d]", "")));
                }
                Elements names = breadCrumb.select("a[href]");
                for (Element element : names) {
                    movie.setName(element.text());
                }
                Elements years = breadCrumb.select(".lister-item-year");
                for (Element element : years) {
                    movie.setReleaseYear(Integer.parseInt(element.text().replaceAll("[^\\d.]", "")));
                }
            }

            Elements genreAndTime = main.select(".text-muted");
            for (Element element:genreAndTime) {
                Elements generas = element.select(".genre");
                for (Element element1:generas) {
                    movie.setGenera(element1.text().replaceAll(" ","").split(","));
                }
                Elements lengths = element.select(".runtime");
                for (Element element1:lengths) {
                    movie.setLength(element1.text());
                }
                for (Element element1:element.select("a[href]")){
                    movie.setDirector(element1.text());
                    break;
                }

            }
            Elements plot = main.select("p");
            list.add(movie);
        }
        return list;
    }
}
