package com.example.movierivvana.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.movierivvana.R;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn, toSignupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hapus statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //tombol login
        loginBtn = (Button) findViewById(R.id.button_login);
        loginBtn.setOnClickListener(v -> {
            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(loginIntent);
        });

        //tombol ke signup
        toSignupBtn = (Button) findViewById(R.id.button_toSignup);
        toSignupBtn.setOnClickListener(v -> {
            Intent toSignupIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(toSignupIntent);
        });
    }
}
