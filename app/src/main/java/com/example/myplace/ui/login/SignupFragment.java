package com.example.myplace.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplace.R;

import java.util.regex.Pattern;

public class SignupFragment extends Fragment {

    private EditText UName, FName, LName, Email, Password, Phone;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        UName = view.findViewById(R.id.userName);
        Password = view.findViewById(R.id.password);
        FName = view.findViewById(R.id.firstName);
        LName = view.findViewById(R.id.lastName);
        Email = view.findViewById(R.id.email);
        Phone = view.findViewById(R.id.phoneNumber);
        Button btnSignup = view.findViewById(R.id.signupbtn);

        btnSignup.setOnClickListener(v -> {

            String uname = UName.getText().toString().trim();
            String fname = FName.getText().toString().trim();
            String lname = LName.getText().toString().trim();
            String email = Email.getText().toString().trim();
            String password = Password.getText().toString().trim();
            String phone = Phone.getText().toString().trim();

            //VERIFICATION THAT USERNAME IS NOT IN DB NEEDS TO BE ADDED
            if (uname.isEmpty()){
                UName.setError("User Name is Required");
                UName.requestFocus();
                return;
            }

            if (fname.isEmpty()){
                FName.setError("First Name is Required");
                FName.requestFocus();
                return;
            }

            if (lname.isEmpty()){
                LName.setError("Last Name is Required");
                LName.requestFocus();
                return;
            }

            if (!isValidEmail(email)){
                Email.setError("Enter a valid email address");
                Email.requestFocus();
                return;
            }

            if (password.isEmpty()){
                Password.setError("Password is Required");
                Password.requestFocus();
                return;
            }

            if (!isValidPhone(phone)){
                Phone.setError("Enter a valid Phone Number");
                Phone.requestFocus();
                return;
            }

            //CODE TO STORE INFORMATION ON DATABASE
            Toast.makeText(getActivity(), "Sign Up Successful", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    private boolean isValidPhone(String phone) {
        return !phone.isEmpty() && phone.matches("\\+?[0=9]{10,15}$");
    }

    //VERIFY EMAIL IS NOT DATABASE NEEDS TO BE ADDED
    private boolean isValidEmail(String email) {

        return !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}