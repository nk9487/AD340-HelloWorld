package com.example.helloworld;

public class Matches {
    private String name;
    //private String description;
    private boolean liked;
    private String imageUrl;

    private String lat;
    private String longitude;
    private String uid;

    public Matches() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrL() {
        return imageUrl;
    }

    public void setImageUrL(String imageUrL) {
        this.imageUrl = imageUrL;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }





}
