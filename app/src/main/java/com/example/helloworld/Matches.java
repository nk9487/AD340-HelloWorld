package com.example.helloworld;

public class Matches {
    private String name;
    //private String description;
    private String imageUrL;
    private boolean liked;
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

   /*public String getDescription() {
        return description;
    }*/

    public String getImageUrL() {
        return imageUrL;
    }

    /*public void setDescription(String description) {
        this.description = description;
    }*/

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
    public void setimageUrL(String imageUrL) {
        this.imageUrL = imageUrL;
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
