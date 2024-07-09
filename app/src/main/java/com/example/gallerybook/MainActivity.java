package com.example.gallerybook;

import android.accounts.Account;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    AlbumsFragment albumsFragment = new AlbumsFragment();
    AccountFragment accountFragment = new AccountFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, albumsFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                final int itemId = item.getItemId();
                if (itemId == R.id.menu_account) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, accountFragment).commit();
                    return true;
                }
                if (itemId == R.id.menu_albums) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, albumsFragment).commit();
                    return true;
                }
                return true;
            }
        });
    }
}