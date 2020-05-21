package com.example.jsonparsing1;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String body;

    public String getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
