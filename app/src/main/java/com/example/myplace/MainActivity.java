package com.example.myplace;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myplace.ui.mainpage.ViewAdapterMainPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager2 = findViewById(R.id.viewPagerMain);
        ViewAdapterMainPage viewAdapterMainPage = new ViewAdapterMainPage(this);
        viewPager2.setAdapter(viewAdapterMainPage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        bottomNavigationView.setOnItemSelectedListener(item ->{
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                return true;
            } else if (id == R.id.navigation_new) {
                showNewListing();
                return true;
            } else if (id == R.id.navigation_profile){
                    startActivity(new Intent(this, UserProfile.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
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