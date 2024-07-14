package com.example.gallerybook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryDetailsActivity extends AppCompatActivity {

    private TextView captionTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_details);

        setTitle("Gallery details");

        // init views
        captionTextView = findViewById(R.id.captionTextView);
        imageView = findViewById(R.id.imageView);

        // get data from intent
        String caption = getIntent().getStringExtra("caption");
        String imageUrl = getIntent().getStringExtra("imageUrl");

        // set data to views
        captionTextView.setText(caption);
        Glide.with(this).load(imageUrl).into(imageView);
    }
}
