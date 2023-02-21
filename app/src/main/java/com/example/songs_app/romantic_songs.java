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

public class romantic_songs extends AppCompatActivity {
   ListView ls1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romantic_songs);

        ls1=findViewById(R.id.list3);
        String []arr= {"Duniyaa","Rozana","Wang da Naap","Hamnava mera","Tay hai"};
        List<String> Players_list = new ArrayList<String>(Arrays.asList(arr));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Players_list);
        ls1.setAdapter(arrayAdapter);
        ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),media_player.class);
                i.putExtra("Romantic_songs_list",position);
                i.putExtra("song_type","Romantic");
                startActivity(i);
            }
        });
    }
}