package com.reeyanto.antaranews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.reeyanto.antaranews.adapters.NewsAdapter;
import com.reeyanto.antaranews.models.Post;
import com.reeyanto.antaranews.models.Response;
import com.reeyanto.antaranews.services.NewsInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNews;
    Retrofit retrofit;
    NewsAdapter newsAdapter;
    List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNews = findViewById(R.id.rv_news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api-berita-indonesia.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsInterface newsInterface = retrofit.create(NewsInterface.class);

        Call<Response> responseCall = newsInterface.getNews();
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Response res = response.body();
                    posts = res.getData().getPosts();

                    newsAdapter = new NewsAdapter(MainActivity.this, posts);
                    rvNews.setAdapter(newsAdapter);
                    rvNews.setLayoutManager(layoutManager);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}