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
        connection.cookie("session-id", "131-6890205-4960347");
        connection.cookie("session-id-time", "2195352442");
        connection.cookie("csm-hit", "tb:F62XF56B3GAG7V09APJY+s-EY0A3JZAZ8APCS0N8M6M|1564632317795&t:1564632317795&adb:adblk_no");
        connection.cookie("adblk", "adblk_no");
        connection.cookie("ubid-main", "132-3004378-2673629");
        connection.cookie("uu", "BCYnpKIemyV53F5uVDhmAGNoG-YvMPirGvC4cqxxsZHAw6YUWDEV7x3EHXNBOj7l9Nh9cpUv6LgB%0D%0A6xe-ZES3ZwQT9Dgceuc8I_fFDN9fzwk-1yNGArr-4Eq0gKhWKfjiwb3hJtK41YAgVoSREgrhyrO2%0D%0AmQ%0D%0A");
        connection.referrer("http://google.com");
        connection.header("headersecurity", "xyz123");
        try {
            doc = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /***Selecting with Id ***/
        Elements elements = doc.select(".lister-item");
        for (Element ele : elements) {
            Movie movie = new Movie();
            Elements posterDiv = ele.select(".lister-item-image");
            for (Element element : posterDiv) {
                Elements links = element.select("img");
                movie.setPoster(links.attr("loadlate"));
            }

            Elements mainDiv = ele.select(".lister-item-content");
            for (Element main : mainDiv) {

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
                for (Element element : genreAndTime) {
                    Elements generas = element.select(".genre");
                    for (Element element1 : generas) {
                        movie.setGenera(element1.text().replaceAll(" ", "").split(","));
                    }
                    Elements lengths = element.select(".runtime");
                    for (Element element1 : lengths) {
                        movie.setLength(element1.text());
                    }
                    for (Element element1 : element.select("a[href]")) {
                        movie.setDirector(element1.text());
                        break;
                    }

                }
                Elements plot = main.select("p");
                if (plot.size() > 2) {
                    movie.setPlot(plot.get(1).text());
                }
                list.add(movie);
            }
        }
        return list;
    }
}
