package com.example.songs_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button playlist,randomplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playlist=findViewById(R.id.playlist);
        randomplay=findViewById(R.id.random);

       playlist.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getApplicationContext(),play_list.class);
               startActivity(i);

           }
       });
       randomplay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(getApplicationContext(),media_player.class);
               startActivity(i);
           }
       });
    }
}