package com.example.myplace.ui.mainpage;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myplace.DBHandler;
import com.example.myplace.MainActivity;
import com.example.myplace.R;

import java.util.ArrayList;
import java.util.List;

public class RentalsFragment extends Fragment {

    private ArrayAdapter<String> adapter;
    private static final int REQUEST_CODE = 1;

    RecyclerView listRecyclerView;
    private RentalAdapter rentalAdapter;
    List<Rental> listingList;
    DBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_rentals, container, false);

        listRecyclerView = view.findViewById(R.id.rentalsRecycler);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dbHandler = new DBHandler(this.getContext());

        loadList();

        return view;
    }


    private void loadList() {
        listingList = new ArrayList<>();
        Cursor cursor = dbHandler.showAllRentals();
        TextView nolistingList = listRecyclerView.findViewById(R.id.noLists);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("r_id")); // Rental ID
                int u_id = cursor.getInt(cursor.getColumnIndexOrThrow("ru_id"));
                String post_date = cursor.getString(cursor.getColumnIndexOrThrow("r_post_date"));
                int rent = cursor.getInt(cursor.getColumnIndexOrThrow("rent"));
                String rentPeriod = cursor.getString(cursor.getColumnIndexOrThrow("rent_period"));
                String address = cursor.getString(cursor.getColumnIndexOrThrow("r_address"));
                String city = cursor.getString(cursor.getColumnIndexOrThrow("r_city"));
                String province = cursor.getString(cursor.getColumnIndexOrThrow("r_province"));
                String postal = cursor.getString(cursor.getColumnIndexOrThrow("r_postal"));
                String type = cursor.getString(cursor.getColumnIndexOrThrow("r_type"));
                int bedrooms = cursor.getInt(cursor.getColumnIndexOrThrow("r_bedrooms"));
                float bathrooms = cursor.getFloat(cursor.getColumnIndexOrThrow("r_bathrooms"));
                int hydro = cursor.getInt(cursor.getColumnIndexOrThrow("util_hydro"));
                int heat = cursor.getInt(cursor.getColumnIndexOrThrow("util_heat"));
                int water = cursor.getInt(cursor.getColumnIndexOrThrow("util_water"));
                int wifi = cursor.getInt(cursor.getColumnIndexOrThrow("wifi"));
                int parking = cursor.getInt(cursor.getColumnIndexOrThrow("r_parking"));
                String moveInDate = cursor.getString(cursor.getColumnIndexOrThrow("r_move_in"));
                int pets = cursor.getInt(cursor.getColumnIndexOrThrow("pets"));
                int smoking = cursor.getInt(cursor.getColumnIndexOrThrow("smoking"));
                int size = cursor.getInt(cursor.getColumnIndexOrThrow("r_size"));
                String furnished = cursor.getString(cursor.getColumnIndexOrThrow("furnished"));
                int laundry = cursor.getInt(cursor.getColumnIndexOrThrow("r_app_laundry"));
                int dishwasher = cursor.getInt(cursor.getColumnIndexOrThrow("r_app_dishwasher"));
                int fridge = cursor.getInt(cursor.getColumnIndexOrThrow("r_app_fridge"));
                int oven = cursor.getInt(cursor.getColumnIndexOrThrow("r_app_oven"));
                int hasAC = cursor.getInt(cursor.getColumnIndexOrThrow("ac"));
                int outdoor = cursor.getInt(cursor.getColumnIndexOrThrow("outdoor"));
                byte[] image = cursor.getBlob(cursor.getColumnIndexOrThrow("r_image"));

                // Create Rental object and add to list
                listingList.add(new Rental(id, u_id, post_date, rent, rentPeriod, address, city,
                        province, postal, type, bedrooms, bathrooms, hydro, heat, water, wifi,
                        parking, moveInDate, pets, smoking, size, furnished, laundry, dishwasher,
                        fridge, oven, hasAC, outdoor, image));
            } while (cursor.moveToNext());

            // Hide "no rentals" message if data exists
            nolistingList.setVisibility(View.GONE);
        } else {
            // Show "no rentals" message if no data exists
            nolistingList.setVisibility(View.VISIBLE);
        }

        rentalAdapter = new RentalAdapter(getContext(),listingList);
        listRecyclerView.setAdapter(rentalAdapter);
    }

    public void onListAdded(){
        loadList();
    }

    //Get name of new listing and post to the listview
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String name = data.getStringExtra("name");
            if (name != null && !name.isEmpty()){
//                postings.add(name);
                adapter.notifyDataSetChanged();
            }
        }
    }
}