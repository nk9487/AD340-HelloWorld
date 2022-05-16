package com.example.helloworld;

public class Matches {
    private String name;
    private String description;
    private String imageURL;
    private boolean liked;

    public Matches(String name, String description, boolean liked, String imageURL) {
        this.name = name;
        this.description = description;
        this.liked = liked;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
