package com.example.myplace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RentalViewListing extends AppCompatActivity {

    private EditText name;
    private EditText street;
    private EditText city;
    private Spinner prov;
    private EditText postal;
    private EditText rent;
    private EditText period;
    private EditText movein;
    private EditText bed;
    private EditText bath;
    private Spinner furnish;
    private CheckBox dish;
    private CheckBox fridge;
    private CheckBox oven;
    private CheckBox laundry;
    private CheckBox hydro;
    private CheckBox heat;
    private CheckBox water;
    private CheckBox ac;
    private CheckBox smoking;
    private CheckBox pet;
    private CheckBox wifi;
    private CheckBox parking;
    private Button editSave;

    public boolean isViewMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rental_view_listing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name =  findViewById(R.id.viewRentalName);
        street =  findViewById(R.id.viewStreetRental);
        city =  findViewById(R.id.viewCityRental);
        prov =  findViewById(R.id.viewProvRental);
        postal =  findViewById(R.id.viewPostalRental);
        rent =  findViewById(R.id.viewRentalAmount);
        period =  findViewById(R.id.viewRentalPeriod);
        movein =  findViewById(R.id.viewMoveInRental);
        bed =  findViewById(R.id.viewRoomsRental);
        bath =  findViewById(R.id.viewBathroomsRental);
        furnish =  findViewById(R.id.viewFurnishRental);
        dish =  findViewById(R.id.DishwasherRentalview);
        fridge =  findViewById(R.id.FridgeRentalview);
        oven =  findViewById(R.id.OvenRentalview);
        laundry =  findViewById(R.id.LaundryRentalview);
        hydro =  findViewById(R.id.HydroRentalview);
        heat =  findViewById(R.id.HeatRentalview);
        water =  findViewById(R.id.WaterRentalview);
        ac =  findViewById(R.id.ACRentalview);
        smoking =  findViewById(R.id.smokingRentalview);
        pet =  findViewById(R.id.PetRentalview);
        wifi =  findViewById(R.id.WifiRentalview);
        parking =  findViewById(R.id.ParkingRentalview);
        editSave = findViewById(R.id.edit_save_Rental);

        setViewOnlyMode();

        editSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isViewMode){
                    setEditMode();
                } else {
                    saveChanges();
                    setViewOnlyMode();
                }
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationViewR);

        bottomNavigationView.setOnItemSelectedListener(item ->{
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0, 0);
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

    private void setEditable(EditText editText, boolean isEditable) {
        editText.setFocusable(isEditable);
        editText.setFocusableInTouchMode(isEditable);
        editText.setClickable(isEditable);
    }

    private void setViewOnlyMode(){

        setEditable(name, false);
        setEditable(street, false);
        setEditable(city, false);
        prov.setEnabled(false);
        setEditable(postal, false);
        setEditable(rent, false);
        setEditable(period, false);
        setEditable(movein, false);
        setEditable(bed, false);
        setEditable(bath, false);
        furnish.setEnabled(false);
        dish.setEnabled(false);
        fridge.setEnabled(false);
        oven.setEnabled(false);
        laundry.setEnabled(false);
        hydro.setEnabled(false);
        heat.setEnabled(false);
        water.setEnabled(false);
        ac.setEnabled(false);
        smoking.setEnabled(false);
        pet.setEnabled(false);
        wifi.setEnabled(false);
        parking.setEnabled(false);

        editSave.setText("Edit");
    }

    private void setEditMode(){
        setEditable(name, true);
        setEditable(street, true);
        setEditable(city, true);
        prov.setEnabled(true);
        setEditable(postal, true);
        setEditable(rent, true);
        setEditable(period, true);
        setEditable(movein, true);
        setEditable(bed, true);
        setEditable(bath, true);
        furnish.setEnabled(true);
        dish.setEnabled(true);
        fridge.setEnabled(true);
        oven.setEnabled(true);
        laundry.setEnabled(true);
        hydro.setEnabled(true);
        heat.setEnabled(true);
        water.setEnabled(true);
        ac.setEnabled(true);
        smoking.setEnabled(true);
        pet.setEnabled(true);
        wifi.setEnabled(true);
        parking.setEnabled(true);

        editSave.setText("Save");
    }

    private void saveChanges(){

        //save changes to DB

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