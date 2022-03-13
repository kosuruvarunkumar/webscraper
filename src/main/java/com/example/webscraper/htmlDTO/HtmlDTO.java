package com.example.webscraper.htmlDTO;

import java.util.Set;

public class HtmlDTO {
    private String html;
    private Set<String> links;

    public Set<String> getLinks() {
        return links;
    }

    public void setLinks(Set<String> links) {
        this.links = links;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
