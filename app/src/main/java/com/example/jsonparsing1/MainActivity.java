package com.example.jsonparsing1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build();
        Javaclassholderapi javaclassholderapi=retrofit.create(Javaclassholderapi.class);

        Call<List<Post>> call=javaclassholderapi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful())
                {
                    tv1.setText("code:"+response.code());
                    return;
                }
                List<Post>posts=response.body();
                for(Post post:posts)
                {
                    String content="";
                    content+="userid:"+post.getUserId()+"\n";
                    content+="id:"+post.getId()+"\n";
                    content+="title:"+post.getTitle()+"\n";
                    content+="body:"+post.getBody()+"\n\n";
                    tv1.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv1.setText(t.getMessage());
            }
        });
    }
}
