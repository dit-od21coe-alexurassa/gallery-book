package com.example.gallerybook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton uploadFabBtn;
    private GridView gridView;
    private ArrayList<DataClass> dataList;
    private GridAdapter adapter;
    private DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init firebase
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        // redirect to login if not authenticated
        if (user == null) {
            redirectToLogin();
        } else {
            // init views
            uploadFabBtn = findViewById(R.id.upload_fab_btn);
            gridView = findViewById(R.id.gridView);
            dataList = new ArrayList<>();
            adapter = new GridAdapter(dataList, this);
            gridView.setAdapter(adapter);

            // init database reference
            databaseReference = FirebaseDatabase.getInstance().getReference(user.getUid());

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    dataList.clear(); // clear the previous list
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DataClass dataClass = dataSnapshot.getValue(DataClass.class);
                        if (dataClass != null) {
                            dataList.add(dataClass);
                        }
                    }
                    adapter.notifyDataSetChanged(); // notify the adapter after data change
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // handle database error
                }
            });

            // click upload fab
            uploadFabBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                    startActivity(intent);
                }
            });

            // click gridItem
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    DataClass selectedData = dataList.get(position);
                    Intent intent = new Intent(MainActivity.this, GalleryDetailsActivity.class);
                    intent.putExtra("caption", selectedData.getCaption());
                    intent.putExtra("imageUrl", selectedData.getImageUrl());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_nav_menu, menu);
        // hide logout menu if user is not authenticated
        MenuItem userMenuItem = menu.findItem(R.id.menu_user);
        MenuItem logoutMenuItem = menu.findItem(R.id.menu_logout);

        if (user != null) {
            // set user display name
            userMenuItem.setVisible(true);
            userMenuItem.setTitle("Hi, " + user.getDisplayName());

            // set logout menu as visible
            logoutMenuItem.setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_logout) {
            // sign-out current user
            firebaseAuth.signOut();
            redirectToLogin();
        }
        return super.onOptionsItemSelected(item);
    }

    private void redirectToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
