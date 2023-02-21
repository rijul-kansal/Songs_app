package com.example.songs_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class english_songs extends AppCompatActivity {
    ListView ls1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_songs);
        ls1=findViewById(R.id.list1);
        String []arr= {"ily","one kiss","talking to the moon","Blinding Lights","Need to know"};
        List<String> Players_list = new ArrayList<String>(Arrays.asList(arr));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Players_list);
        ls1.setAdapter(arrayAdapter);
        ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),media_player.class);
                i.putExtra("English_songs_list",position);
                i.putExtra("song_type","English");
                startActivity(i);
            }
        });
    }
}