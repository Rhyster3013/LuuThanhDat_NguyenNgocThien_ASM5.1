package com.example.asm51.models;

public class News {
    private int id;
    private String title;
    private String link;
    private String image;

    public News() {
    }

    public News(String title, String link, String image) {
        this.title = title;
        this.link = link;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
