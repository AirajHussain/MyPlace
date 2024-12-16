package com.example.myplace.ui.mainpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myplace.DBHandler;
import com.example.myplace.R;

import java.util.List;

public class RealEstateAdapter extends RecyclerView.Adapter<RealEstateAdapter.RealEstateViewHolder> {
    private List<RealEstate> realEstateList;
    private Context context;

    // Database handler instance
    DBHandler dbHandler;

    // Constructor
    public RealEstateAdapter(Context context, List<RealEstate> realEstateList) {
        this.context = context; // Store context for future use if needed
        this.realEstateList = realEstateList;
        this.dbHandler = new DBHandler(context);
    }

    @NonNull
    @Override
    public RealEstateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RealEstateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RealEstateViewHolder holder, int position) {
        RealEstate realEstate = realEstateList.get(position);

        if (realEstate != null) { // Check if realEstete is not null
            holder.address.setText(realEstate.getAddress());
            holder.city.setText(realEstate.getCity());
            holder.province.setText(realEstate.getProvince());
            holder.postalCode.setText(realEstate.getPostalCode());
            holder.price.setText(String.valueOf(realEstate.getPrice()));
            holder.bedrooms.setText(String.valueOf(realEstate.getBedrooms()));
            holder.bathrooms.setText(String.valueOf(realEstate.getBathrooms()));
            holder.moveInDate.setText(realEstate.getMoveInDate());
        } else {
            // Handle null realEstate case if necessary
            holder.address.setText("No address available");
            holder.city.setText("N/A");
            holder.province.setText("N/A");
            holder.postalCode.setText("N/A");
            holder.price.setText("N/A");
            holder.bedrooms.setText("N/A");
            holder.bathrooms.setText("N/A");
            holder.moveInDate.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return realEstateList != null ? realEstateList.size() : 0; // Safeguard against null list
    }

    public static class RealEstateViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        TextView city;
        TextView province;
        TextView postalCode;
        TextView price;
        TextView bedrooms;
        TextView bathrooms;
        TextView moveInDate;

        public RealEstateViewHolder(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.address);
            city = itemView.findViewById(R.id.city);
            province = itemView.findViewById(R.id.province);
            postalCode = itemView.findViewById(R.id.postalCode);
            price = itemView.findViewById(R.id.value);
            bedrooms = itemView.findViewById(R.id.bedrooms); // Make sure to initialize all TextViews
            bathrooms = itemView.findViewById(R.id.bathrooms);
            moveInDate = itemView.findViewById(R.id.moveInDate);
        }
    }
}
