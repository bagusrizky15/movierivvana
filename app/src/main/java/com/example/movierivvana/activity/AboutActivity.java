package com.example.movierivvana.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movierivvana.R;

public class AboutActivity extends AppCompatActivity {

    Button button_Kembali, button_Bahasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        button_Kembali = (Button) findViewById(R.id.button_Kembali);
        button_Kembali.setOnClickListener(v -> {
            Intent kembaliIntent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(kembaliIntent);
        });

        button_Bahasa = (Button) findViewById(R.id.button_Bahasa);
        button_Bahasa.setOnClickListener(v -> {
            Intent bahasaIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(bahasaIntent);
        });
    }
}