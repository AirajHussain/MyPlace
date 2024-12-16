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
import com.example.myplace.R;

import java.util.ArrayList;
import java.util.List;

public class RealEstateFragment extends Fragment {

    private ArrayAdapter<String> adapter;
    private static final int REQUEST_CODE = 1;

    RecyclerView listRecyclerView;
    List<RealEstate> listingList;
    DBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_real_estate, container, false);

        listRecyclerView = view.findViewById(R.id.realEstateRecycler);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dbHandler = new DBHandler(this.getContext());

        loadList();

        return view;
    }


    private void loadList() {
        listingList = new ArrayList<>();
        Cursor cursor = dbHandler.showAllRealEstate();
        TextView noListingList = listRecyclerView.findViewById(R.id.noLists);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("e_id")); // Real Estate ID
                int u_id = cursor.getInt(cursor.getColumnIndexOrThrow("eu_id"));
                String post_date = cursor.getString(cursor.getColumnIndexOrThrow("e_post_date"));
                int price = cursor.getInt(cursor.getColumnIndexOrThrow("price"));
                String address = cursor.getString(cursor.getColumnIndexOrThrow("e_address"));
                String city = cursor.getString(cursor.getColumnIndexOrThrow("e_city"));
                String province = cursor.getString(cursor.getColumnIndexOrThrow("e_province"));
                String postal = cursor.getString(cursor.getColumnIndexOrThrow("e_postal"));
                String type = cursor.getString(cursor.getColumnIndexOrThrow("e_type"));
                int bedrooms = cursor.getInt(cursor.getColumnIndexOrThrow("e_bedrooms"));
                float bathrooms = cursor.getFloat(cursor.getColumnIndexOrThrow("e_bathrooms"));
                int indoor_size = cursor.getInt(cursor.getColumnIndexOrThrow("indoor_size"));
                int outdoor_size = cursor.getInt(cursor.getColumnIndexOrThrow("outdoor_size"));
                int garage = cursor.getInt(cursor.getColumnIndexOrThrow("garage"));
                String moveInDate = cursor.getString(cursor.getColumnIndexOrThrow("e_move_in"));
                int laundry = cursor.getInt(cursor.getColumnIndexOrThrow("e_app_laundry"));
                int dishwasher = cursor.getInt(cursor.getColumnIndexOrThrow("e_app_dishwasher"));
                int fridge = cursor.getInt(cursor.getColumnIndexOrThrow("e_app_fridge"));
                int oven = cursor.getInt(cursor.getColumnIndexOrThrow("e_app_oven"));
                String heating = cursor.getString(cursor.getColumnIndexOrThrow("heating"));
                String cooling = cursor.getString(cursor.getColumnIndexOrThrow("cooling"));
                byte[] image = cursor.getBlob(cursor.getColumnIndexOrThrow("r_image"));

                // Create RealEstate object and add to list
                listingList.add(new RealEstate(id, u_id, post_date, price, address, city, province,
                        postal, type, bedrooms, bathrooms, indoor_size, outdoor_size, garage,
                        moveInDate, laundry, dishwasher, fridge, oven, heating, cooling, image));
            } while (cursor.moveToNext());

            // Hide "no listings" message if data exists
            noListingList.setVisibility(View.GONE);
        } else {
            // Show "no listings" message if no data exists
            noListingList.setVisibility(View.VISIBLE);
        }

        RealEstateAdapter realEstateAdapter = new RealEstateAdapter(getContext(), listingList);
        listRecyclerView.setAdapter(realEstateAdapter);
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