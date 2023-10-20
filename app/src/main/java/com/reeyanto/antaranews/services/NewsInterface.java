package com.reeyanto.antaranews.services;

import com.reeyanto.antaranews.models.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsInterface {

    @GET("/antara/terbaru/")
    Call<Response> getNews();
}
