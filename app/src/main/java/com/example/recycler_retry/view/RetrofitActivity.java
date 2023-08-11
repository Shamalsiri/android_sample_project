package com.example.recycler_retry.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.recycler_retry.R;
import com.example.recycler_retry.model.RetrofitModel;

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {
    
    private Button downloadToDbBtn, displayAllPostsBtn, displaySinglePostBtn, exitBtn;
    private EditText postIdEt;
    private TextView postsTv;
    private RetrofitModel rfModel;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        rfModel = new RetrofitModel();
        
        setupComponents();
    }
    
    public void setupComponents() {
        
        //Buttons
        downloadToDbBtn = findViewById(R.id.btn_download_to_db);
        downloadToDbBtn.setOnClickListener(this);
        displayAllPostsBtn = findViewById(R.id.btn_display_all_posts);
        displayAllPostsBtn.setOnClickListener(this);
        displaySinglePostBtn = findViewById(R.id.btn_display_single_post);
        displaySinglePostBtn.setOnClickListener(this);
        exitBtn = findViewById(R.id.btn_exit);
        exitBtn.setOnClickListener(this);
        
        //EditText
        postIdEt = findViewById(R.id.et_post_id);
        postIdEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });
        
        //TextView
        postsTv = findViewById(R.id.tv_posts);
        
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        String content;
        
        if (viewId == R.id.btn_download_to_db) {
            rfModel.downloadDataToDb();
        } else if (viewId == R.id.btn_display_all_posts) {
            postsTv.setTextColor(Color.BLACK);

            content = RetrofitModel.getAllPosts();
            postsTv.setText(content);
        } else if (viewId == R.id.btn_display_single_post) {
            postsTv.setTextColor(Color.BLACK);

            if (postIdEt.getText().toString().length() != 0) {
                id = Integer.valueOf(postIdEt.getText().toString());
                Log.d("SSIRI", "ID: " + id);

                content = rfModel.getSinglePost(id);
                postsTv.setText(content);

            } else {
                postsTv.setTextColor(Color.RED);
                postsTv.setText("Please enter an Id number in the input space");

            }

        } else if (viewId == R.id.btn_exit) {
            finish();
        }
    }

}