package com.example.songs_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class media_player extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        String []arr= {"Nashe se Chadd gai","Bom Diggy Diggy ","Dheema Dheema","Manali Tarance","Mera Haath Mein"};
        Intent i=getIntent();
        int x=i.getIntExtra("Hindi_songs_list",0);
        Toast.makeText(this, "in media activity "+arr[x], Toast.LENGTH_SHORT).show();
    }
}