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

public class RentalAdapter extends RecyclerView.Adapter<RentalAdapter.RentalViewHolder> {
    private List<Rental> rentalList;
    private Context context;

    // Database handler instance
    DBHandler dbHandler;

    // Constructor
    public RentalAdapter(Context context, List<Rental> rentalList) {
        this.context = context; // Store context for future use if needed
        this.rentalList = rentalList;
        this.dbHandler = new DBHandler(context);
    }

    @NonNull
    @Override
    public RentalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RentalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RentalViewHolder holder, int position) {
        Rental rental = rentalList.get(position);

        if (rental != null) { // Check if rental is not null
            holder.address.setText(rental.getAddress());
            holder.city.setText(rental.getCity());
            holder.province.setText(rental.getProvince());
            holder.postalCode.setText(rental.getPostalCode());
            holder.rent.setText(String.valueOf(rental.getRent()));
            holder.bedrooms.setText(String.valueOf(rental.getBedrooms()));
            holder.bathrooms.setText(String.valueOf(rental.getBathrooms()));
            holder.moveInDate.setText(rental.getMoveInDate());
        } else {
            // Handle null rental case if necessary
            holder.address.setText("No address available");
            holder.city.setText("N/A");
            holder.province.setText("N/A");
            holder.postalCode.setText("N/A");
            holder.rent.setText("N/A");
            holder.bedrooms.setText("N/A");
            holder.bathrooms.setText("N/A");
            holder.moveInDate.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return rentalList != null ? rentalList.size() : 0; // Safeguard against null list
    }

    public static class RentalViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        TextView city;
        TextView province;
        TextView postalCode;
        TextView rent;
        TextView bedrooms;
        TextView bathrooms;
        TextView moveInDate;

        public RentalViewHolder(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.address);
            city = itemView.findViewById(R.id.city);
            province = itemView.findViewById(R.id.province);
            postalCode = itemView.findViewById(R.id.postalCode);
            rent = itemView.findViewById(R.id.value);
            bedrooms = itemView.findViewById(R.id.bedrooms); // Make sure to initialize all TextViews
            bathrooms = itemView.findViewById(R.id.bathrooms);
            moveInDate = itemView.findViewById(R.id.moveInDate);
        }
    }
}
