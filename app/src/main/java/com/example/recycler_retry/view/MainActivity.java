package com.example.recycler_retry.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.recycler_retry.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button retrofitBtn, recyclerViewBtn;
    private ImageView retrofitInfoIv, recyclerViewInfoIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupComponents();

    }

    public void setupComponents() {

        // info - Image View
        retrofitInfoIv = findViewById(R.id.iv_retrofit_info);
        retrofitInfoIv.setOnClickListener(this);
        recyclerViewInfoIv = findViewById(R.id.iv_recycler_view_info);
        recyclerViewInfoIv.setOnClickListener(this);

        // button
        retrofitBtn = findViewById(R.id.btn_retrofit);
        retrofitBtn.setOnClickListener(this);
        recyclerViewBtn = findViewById(R.id.btn_recycler_view);
        recyclerViewBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_retrofit) {
            Log.d("SSIRI", "Test retrofit");
            Intent intent = new Intent(this, RetrofitActivity.class);
            startActivity(intent);


        } else if (id == R.id.btn_recycler_view) {
            Log.d("SSIRI", "Test Recycler");
        } else if (id == R.id.iv_retrofit_info) {
            Log.d("SSIRI", "IV retrofit info");
        } else if (id == R.id.iv_recycler_view_info) {
            Log.d("SSIRI", "IV recycler view info");
        }
    }
}
