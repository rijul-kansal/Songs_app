package com.example.songs_app;

import androidx.annotation.NonNull;
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


    int startTime=0;
    int finalTime=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romantic_songs);



        Intent i=getIntent();
        startTime=i.getIntExtra("st",0);
        finalTime=i.getIntExtra("ft",0);



        ls1=findViewById(R.id.list3);
        String []arr= {"Duniyaa","Rozana","Wang da Naap","Hamnava mera","Tay hai"};
        List<String> Players_list = new ArrayList<String>(Arrays.asList(arr));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Players_list);
        ls1.setAdapter(arrayAdapter);


        ls1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),media_player.class);
                i.putExtra("pos",position);
                i.putExtra("song_type","Romantic");
                startActivity(i);
            }
        });

    }


}