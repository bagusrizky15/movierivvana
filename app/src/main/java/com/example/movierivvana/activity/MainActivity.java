package com.example.movierivvana.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.movierivvana.R;
import com.example.movierivvana.adapter.RecyclerMoviesAdapter;
import com.example.movierivvana.model.Response;
import com.example.movierivvana.model.Result;
import com.example.movierivvana.rest.ApiClient;
import com.example.movierivvana.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private RecyclerMoviesAdapter adapter;
    String API_KEY ="b305e83b1f41e223dc8afd508bad63f6";
    String LANGUAGE = "en-US";
    String CATEGORY="popular";
    int PAGE = 1;
    RecyclerView recyclerView;
    ImageButton button_Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hapus statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //button
        button_Image = (ImageButton) findViewById(R.id.imageBtn);
        button_Image.setOnClickListener(v -> {
            Intent btnImageIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(btnImageIntent);
        });

        recyclerView = findViewById(R.id.rvMovie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        callRetrofit();

    }

    private void callRetrofit() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Response> call= apiInterface.getMovie(CATEGORY,API_KEY,LANGUAGE,PAGE);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<Result> mList = response.body().getResults();
                adapter = new RecyclerMoviesAdapter(MainActivity.this,mList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.fillInStackTrace();

            }
        });
    }
}