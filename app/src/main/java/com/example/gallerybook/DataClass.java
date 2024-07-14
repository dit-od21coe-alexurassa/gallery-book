package com.example.gallerybook;

public class DataClass {
    private String caption;
    private String imageUrl;

    public DataClass() {
        // Default constructor required for calls to DataSnapshot.getValue(DataClass.class)
    }

    public DataClass(String caption, String imageUrl) {
        this.caption = caption;
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
