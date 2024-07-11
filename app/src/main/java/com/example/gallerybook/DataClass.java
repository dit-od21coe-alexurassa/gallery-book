package com.example.gallerybook;

public class DataClass {
    private String imageUrl, caption;

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

    public DataClass(String imageUrl, String caption) {
        this.imageUrl = imageUrl;
        this.caption = caption;
    }
}
