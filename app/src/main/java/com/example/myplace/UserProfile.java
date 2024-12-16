package com.example.myplace;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myplace.ui.profile.ViewAdapterProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class UserProfile extends AppCompatActivity {

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager2 = findViewById(R.id.viewPagerProfile);
        ViewAdapterProfile adapter = new ViewAdapterProfile(this);
        viewPager2.setAdapter(adapter);

        viewPager2.setCurrentItem(0,false);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_profile);

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
                return true;
            }
            return false;
        });
    }

    public void navigateToEditFragment(){
        viewPager2.setCurrentItem(1, true);
    }

    public void navigateToInfoFragment(){
        viewPager2.setCurrentItem(0, true);
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
}