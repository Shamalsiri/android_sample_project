package com.example.recycler_retry.model;

import android.util.Log;

import com.example.recycler_retry.controller.retrofit.JsonPlaceHolderApi;
import com.example.recycler_retry.controller.retrofit.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModel {
    private static final String TAG = "SSIRI" ;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static String mint;

    public static String getSinglePost(int id) {

        Retrofit retrofit = new Retrofit.Builder()
                . baseUrl(BASE_URL)
                . addConverterFactory(GsonConverterFactory.create())
                . build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Post> call = jsonPlaceHolderApi.getSinglePost(id);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    mint = ("Code: " + response.code());
                    return;
                }

                Post post = response.body();

                String content = "";
                content += "ID : " + post.getId();
                content += "\nUser Id: " + post.getUserId();
                content += "\nTitle: " + post.getTitle();
                content += "\nText: " + post.getBody() + "\n\n";

                mint = content;

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                mint = t.getLocalizedMessage();
            }
        });

        return mint;
    }

    public static String getAllPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                . baseUrl(BASE_URL)
                . addConverterFactory(GsonConverterFactory.create())
                . build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    mint = "Code: " + response.code();
                    Log.d(TAG,"Failed with Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                String content = "";
                for (Post post : posts) {
                    content += "ID : " + post.getId();
                    content += "\nUser Id: " + post.getUserId();
                    content += "\nTitle: " + post.getTitle();
                    content += "\nText: " + post.getBody() + "\n\n";

                }
                mint = content;
                Log.d(TAG, "Retrofit Call Successful");

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                mint =  t.getLocalizedMessage();
                Log.d(TAG, "Retrofit Call Failed");
            }
        });

        return mint;
    }

    public static void downloadDataToDb() {

    }
}
