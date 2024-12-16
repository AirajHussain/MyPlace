package com.example.myplace.ui.mainpage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewAdapterMainPage extends FragmentStateAdapter {

    public ViewAdapterMainPage(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position){
        switch(position){
            case 0:
                return new RentalsFragment();
            case 1:
                return new RealEstateFragment();
            default:
                return new RentalsFragment();
        }
    }

    @Override
    public int getItemCount(){
        return 2;
    }
}
