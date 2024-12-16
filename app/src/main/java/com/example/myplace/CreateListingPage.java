package com.example.myplace;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//WIll BE REPLACED LEAVING IT HERE FOR REFERENCE

public class CreateListingPage extends AppCompatActivity {

    private DBHandler dbHandler; // Variable for the database handler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_listing_page);

        dbHandler = new DBHandler(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText listingName = findViewById(R.id.listingName);
        Button postButton = findViewById(R.id.post);
        postButton.setOnClickListener(v->saveList());

        Spinner provinceSpinner = findViewById(R.id.province);
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Handle item selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle no selection
            }
        });

        Button cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void saveList() {
        // Get references to input fields
        EditText street = findViewById(R.id.street);
        EditText city = findViewById(R.id.city);
        EditText postalcode = findViewById(R.id.postalcode);
        EditText moveinDate = findViewById(R.id.moveinDate);
        EditText rooms = findViewById(R.id.rooms);
        EditText bathrooms = findViewById(R.id.Bathrooms);
        EditText rent = findViewById(R.id.rent);

        // Spinner for Province
        Spinner provinceSpinner = findViewById(R.id.province);
        String e_province = provinceSpinner.getSelectedItem().toString(); // Get selected province

        // Checkboxes for amenities
        CheckBox ac = findViewById(R.id.AC);
        CheckBox laundry = findViewById(R.id.Laundry);
        CheckBox fridge = findViewById(R.id.Fridge);
        CheckBox dishwasher = findViewById(R.id.Dishwasher);

        // Collect data from inputs
        String e_address = street.getText().toString().trim();
        String e_city = city.getText().toString().trim();
        String e_postal = postalcode.getText().toString().trim();
        String e_rent_period = ""; // Define rental period if needed
        String e_move_in = moveinDate.getText().toString().trim();

        int price = 0;
        int e_bedrooms = 0;
        float e_bathrooms = 0;

        // Input validation
        if (e_address.isEmpty()) {
            Toast.makeText(this, "Please enter a street address", Toast.LENGTH_SHORT).show();
            return;
        }
        if (e_city.isEmpty()) {
            Toast.makeText(this, "Please enter a city", Toast.LENGTH_SHORT).show();
            return;
        }
        if (e_province.isEmpty()) {
            Toast.makeText(this, "Please select a province", Toast.LENGTH_SHORT).show();
            return;
        }
        if (e_postal.isEmpty()) {
            Toast.makeText(this, "Please enter a postal code", Toast.LENGTH_SHORT).show();
            return;
        }
        if (e_move_in.isEmpty()) {
            Toast.makeText(this, "Please enter a move-in date", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            price = Integer.parseInt(rent.getText().toString().trim());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid rent amount", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            e_bedrooms = Integer.parseInt(rooms.getText().toString().trim());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number of bedrooms", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            e_bathrooms = Float.parseFloat(bathrooms.getText().toString().trim());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number of bathrooms", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert checkbox values to int (1 for checked, 0 for unchecked)
        int e_ac = ac.isChecked() ? 1 : 0;
        int e_laundry = laundry.isChecked() ? 1 : 0;
        int e_fridge = fridge.isChecked() ? 1 : 0;
        int e_dishwasher = dishwasher.isChecked() ? 1 : 0;

        // Additional fields with assumed default values
        String e_r_type = "apartment"; // Example value
        int e_util_hydro = 0; // 0 or 1, adjust as necessary
        int e_util_heat = 0;
        int e_util_water = 0;
        int e_wifi = 1; // Assume 1 for yes, 0 for no
        int e_parking = 1;
        int e_pets = 0;
        int e_smoking = 0;
        int e_size = 500; // Example size in sq ft
        String e_furnished = "no"; // Assume "yes" or "no"
        int e_oven = 1;
        int e_outdoor = 1;

        // Call the addRental method to save the entry
        long result = dbHandler.addRental(
                0, // ru_id
                e_move_in, // Post date
                price,
                e_rent_period,
                e_address,
                e_city,
                e_province,
                e_postal,
                e_r_type, // Rental type
                e_bedrooms,
                e_bathrooms,
                e_util_hydro,
                e_util_heat,
                e_util_water,
                e_wifi,
                e_parking,
                e_move_in, // Move-in date
                e_pets,
                e_smoking,
                e_size,
                e_furnished,
                e_laundry,
                e_dishwasher,
                e_fridge,
                e_oven,
                e_ac,
                e_outdoor
        );

        if (result == -1) {
            Toast.makeText(this, "Failed to save rental data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Rental data saved successfully", Toast.LENGTH_SHORT).show();
        }
    }




}
