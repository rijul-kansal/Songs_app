package com.example.songs_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class play_list extends AppCompatActivity {
    Button hindi,english,punjabi,romantic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
        hindi=findViewById(R.id.Hindi);
        english=findViewById(R.id.english);
        punjabi=findViewById(R.id.punjabi);
        romantic=findViewById(R.id.romantic);

        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),hindosongs.class);
            }
        });hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),hindosongs.class);
                startActivity(i);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),english_songs.class);
                startActivity(i);
            }
        });
        punjabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),punjabi_songs.class);
                startActivity(i);
            }
        });
        romantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),romantic_songs.class);
                startActivity(i);
            }
        });
    }
}