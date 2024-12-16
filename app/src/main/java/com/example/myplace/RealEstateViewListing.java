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

public class RealEstateViewListing extends AppCompatActivity {

    private EditText name;
    private EditText street;
    private EditText city;
    private Spinner prov;
    private EditText postal;
    private EditText type;
    private EditText bed;
    private EditText bath;
    private EditText indoor;
    private EditText outdoor;
    private EditText garage;
    private EditText movein;
    private CheckBox dish;
    private CheckBox laundry;
    private CheckBox fridge;
    private CheckBox heat;
    private CheckBox oven;
    private CheckBox cooling;
    private Button editSave;

    public boolean isViewMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_real_estate_view_listing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.viewNameRE);
        street = findViewById(R.id.viewStreetRE);
        city = findViewById(R.id.viewCityRE);
        prov = findViewById(R.id.viewProvRE);
        postal = findViewById(R.id.viewPostalRE);
        type = findViewById(R.id.viewREType);
        bed = findViewById(R.id.viewRoomsRE);
        bath = findViewById(R.id.viewBathroomsRE);
        indoor = findViewById(R.id.viewSizeRE);
        outdoor = findViewById(R.id.viewOutSizeRE);
        garage = findViewById(R.id.viewGarageRE);
        movein = findViewById(R.id.viewMoveInRE);
        dish = findViewById(R.id.DishwasherREview);
        laundry = findViewById(R.id.LaundryREview);
        fridge = findViewById(R.id.FridgeREview);
        heat = findViewById(R.id.HeatREview);
        oven = findViewById(R.id.OvenREview);
        cooling = findViewById(R.id.CoolREview);
        editSave =  findViewById(R.id.edit_save_RE);

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

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationViewE);

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

    private void setViewOnlyMode() {
        isViewMode = true;

        setEditable(name, false);
        setEditable(street, false);
        setEditable(city, false);
        prov.setEnabled(false);
        setEditable(postal, false);
        setEditable(type, false);
        setEditable(bed, false);
        setEditable(bath, false);
        setEditable(indoor, false);
        setEditable(outdoor, false);
        setEditable(garage, false);
        setEditable(movein, false);
        dish.setEnabled(false);
        laundry.setEnabled(false);
        fridge.setEnabled(false);
        heat.setEnabled(false);
        oven.setEnabled(false);
        cooling.setEnabled(false);
        editSave.setEnabled(false);

        editSave.setText("Edit");
    }

    private void setEditMode(){
        isViewMode = false;

        setEditable(name, true);
        setEditable(street, true);
        setEditable(city, true);
        prov.setEnabled(true);
        setEditable(postal, true);
        setEditable(type, true);
        setEditable(bed, true);
        setEditable(bath, true);
        setEditable(indoor, true);
        setEditable(outdoor, true);
        setEditable(garage, true);
        setEditable(movein, true);
        dish.setEnabled(true);
        laundry.setEnabled(true);
        fridge.setEnabled(true);
        heat.setEnabled(true);
        oven.setEnabled(true);
        cooling.setEnabled(true);
        editSave.setEnabled(true);

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