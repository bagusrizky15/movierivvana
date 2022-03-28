package com.example.movierivvana.activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.movierivvana.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn, toSignupBtn;
    TextInputLayout textEmail, textPassword;
    TextInputEditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hapus statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        
        textEmail = findViewById(R.id.text_email);
        textPassword = findViewById(R.id.text_password);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);

        //tombol login
        loginBtn = (Button) findViewById(R.id.button_login);
        loginBtn.setOnClickListener(v -> {
           // if (!validateEmail() | !validatePassword()){
             //   return;
           // }else {
                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(loginIntent);
           // }
        });

        //tombol ke signup
        toSignupBtn = (Button) findViewById(R.id.button_toSignup);
        toSignupBtn.setOnClickListener(v -> {
            Intent toSignupIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(toSignupIntent);
        });
    }
    
    //validation function
//    private boolean validateEmail(){
//        String val = email.getText().toString().trim();
//        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
//
//        if (val.isEmpty()){
//            email.setError("Field can not be empty");
//            return false;
//        } else if(!val.matches(checkEmail)){
//            email.setError("Invalid Email!");
//            return false;
//        }else {
//            email.setError(null);
//            return true;
//        }
//    }
//    private boolean validatePassword(){
//        String val = password.getText().toString().trim();
//
//        if (val.isEmpty()){
//            password.setError("Field can not be empty");
//            return false;
//        }else {
//            password.setError(null);
//            return true;
//        }
//    }
    
}
