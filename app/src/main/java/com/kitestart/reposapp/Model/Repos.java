



package com.kitestart.reposapp.Model;

import java.util.ArrayList;

public class Repos {

    private String name;
    private String description;
    private String html_url;

    public Repos(String name, String description, String html_url) {
        this.name = name;
        this.description = description;
        this.html_url = html_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
