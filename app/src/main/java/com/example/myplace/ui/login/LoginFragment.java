package com.example.myplace.ui.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplace.R;

public class LoginFragment extends Fragment {

    private EditText liEmail, liPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        liEmail = view.findViewById((R.id.emailLogin));
        liPassword = view.findViewById(R.id.passwordLogin);
        Button btnLogin = view.findViewById(R.id.login);

        btnLogin.setOnClickListener(v -> {

            String email = liEmail.getText().toString().trim();
            String password = liPassword.getText().toString().trim();

            if (!isValidEmail(email)) {
                liEmail.setError("Email is Required");
                liEmail.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                liPassword.setError("Password is Required");
                liPassword.requestFocus();
                return;
            }

            //REPLACE WITH EMAIL AND PASSWORD VALIDATION
            if (email.equals("test@test.com") && password.equals("password")) {
                Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }

    private boolean isValidEmail(String email) {
        return !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}