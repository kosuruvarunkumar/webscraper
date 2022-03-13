package com.example.webscraper.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ScrapingService {

    public String getHtml(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (document != null)? document.html() : "An error occurred";
    }

    public Set<String> geLinks(String url) {
        Set<String> links = new HashSet<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("a[href]");
            for(Element element : elements) {
                String link = element.attr("href");
                if(link.length() > 6 && link.substring(0,5).equals("https")) {
                    links.add(link);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }
}
