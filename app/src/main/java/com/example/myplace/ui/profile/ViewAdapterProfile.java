package com.example.myplace.ui.profile;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewAdapterProfile extends FragmentStateAdapter {

    public ViewAdapterProfile(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position){
        switch(position){
            case 0:
                return new profileInfo();
            case 1:
                return new profileEdit();
            default:
                return new profileInfo();
        }
    }

    @Override
    public int getItemCount(){
        return 2;
    }
}
