package com.example.myplace;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myplace.ui.login.ViewAdapterSignup;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SignupPage extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page);

        TabLayout tabLayout = findViewById(R.id.tabLayoutSignIn);
        ViewPager2 viewPager = findViewById(R.id.profileInfo);

        ViewAdapterSignup adapter = new ViewAdapterSignup(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Login");
                    break;
                case 1:
                    tab.setText("Sign Up");
                    break;
            }
        }).attach();

    }
}