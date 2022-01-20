package com.example.movierivvana.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movierivvana.R;

public class SignUpActivity extends AppCompatActivity {

    Button toSigninBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hapus statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //tombol ke login
        toSigninBtn = (Button) findViewById(R.id.button_toSignin);
        toSigninBtn.setOnClickListener(v -> {
            Intent toSiginIntent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(toSiginIntent);
        });
    }
}
