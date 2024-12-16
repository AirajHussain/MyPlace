package com.example.myplace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RealEstateNewListing extends AppCompatActivity {

    private static final int IMAGE_PICK_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_real_estate_new_listing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner provinceSpinner = findViewById(R.id.newProvRE);
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                // Handle item selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle no selection
            }
        });


        //Upload Image
        Button upload = findViewById(R.id.uploadImageRE);
        upload.setOnClickListener(v -> openGallery());

        //Post Renat Listing
        Button postButton = findViewById(R.id.postRE);
        postButton.setOnClickListener(v->saveList());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationViewE);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (id == R.id.navigation_new) {
                showNewListing();
                return true;
            } else if (id == R.id.navigation_profile) {
                startActivity(new Intent(this, UserProfile.class));
                overridePendingTransition(0, 0);
                return true;
            }
            return false;
        });

    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    private void showNewListing() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Listing Type")
                .setItems(new String[]{"Rental", "RealEstate"}, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            startActivity(new Intent(this, RentalNewListing.class));
                            break;
                        case 1:
                            startActivity(new Intent(this, RealEstateNewListing.class));
                            break;
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

    private void saveList(){
        ////Save listing
    }
}