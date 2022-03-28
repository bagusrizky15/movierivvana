package com.example.movierivvana.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movierivvana.R;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    Button toSigninBtn, btnSignUp;
    TextInputEditText email, username, phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hapus statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //tombol daftar
        btnSignUp = (Button) findViewById(R.id.button_signup);
        btnSignUp.setOnClickListener(v -> {
            if (!validateEmail2() | !validatePassword2()){
                return;
            } else {
                Intent signUpIntent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(signUpIntent);
            }
        });

        //tombol ke login
        toSigninBtn = (Button) findViewById(R.id.button_toSignin);
        toSigninBtn.setOnClickListener(v -> {
            Intent toSiginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(toSiginIntent);
        });
    }

    //validation function
    private boolean validateEmail2(){
        String val = email.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()){
            email.setError("Field can not be empty");
            return false;
        } else if(!val.matches(checkEmail)){
            email.setError("Invalid Email!");
            return false;
        }else {
            email.setError(null);
            return true;
        }
    }

//    private boolean validateUsername(){
//        String val = username.getText().toString().trim();
//        String checkspaces = "Aw{1,20}z";
//
//        if (val.isEmpty()){
//            username.setError("Field can not be empty");
//            return false;
//        } else if(!val.matches(checkspaces)){
//            username.setError("No spaces");
//            return false;
//        } else if(val.length()>20){
//            username.setError("max. 20 characters");
//            return false;
//        }else {
//            username.setError(null);
//            return true;
//        }
//    }

    private boolean validatePassword2(){
        String val = password.getText().toString().trim();

        if (val.isEmpty()){
            password.setError("Field can not be empty");
            return false;
        }else {
            password.setError(null);
            return true;
        }
    }

}
