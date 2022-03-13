package com.example.webscraper.controllers;

import com.example.webscraper.htmlDTO.HtmlDTO;
import com.example.webscraper.services.ScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ScrapingController {

    @Autowired
    ScrapingService scrapingService;

    @GetMapping("/scrape")
    public ResponseEntity<?> getHtml(@RequestParam String url) {
        String html = scrapingService.getHtml(url);
        Set<String> links = scrapingService.geLinks(url);
        HtmlDTO htmlDTO = new HtmlDTO();
        htmlDTO.setHtml(html);
        htmlDTO.setLinks(links);
        return new ResponseEntity<HtmlDTO>(htmlDTO,HttpStatus.OK);
    }
}
