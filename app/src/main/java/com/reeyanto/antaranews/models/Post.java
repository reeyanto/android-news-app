package com.reeyanto.antaranews.models;

public class Post {

    String link, title, pubDate, description, thumbnail;

    public Post(String link, String title, String pubDate, String description, String thumbnail) {
        this.link = link;
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
