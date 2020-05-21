package com.example.jsonparsing1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Javaclassholderapi {
    @GET("posts")
    Call<List<Post>> getPosts();
}
