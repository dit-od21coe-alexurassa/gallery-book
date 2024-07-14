package com.example.gallerybook;

public class DataClass {
    private String imageUrl;
    private String caption;

    // Default constructor required for calls to DataSnapshot.getValue(DataClass.class)
    public DataClass() {
    }

    public DataClass(String imageUrl, String caption) {
        this.imageUrl = imageUrl;
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
