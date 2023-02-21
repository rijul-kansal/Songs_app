package com.example.songs_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class media_player extends AppCompatActivity {
 ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        String []Romantic= {"Duniyaa","Rozana","Wang da Naap","Hamnava mera","Tay hai"};
        String []Punjabi= {"Daku","Suit","8 parche","same Time Same jagha","Slowly Slowly"};
        String []English= {"ily","one kiss","talking to the moon","Blinding Lights","Need to know"};
        String []Hindi= {"Nashe se Chadd gai","Bom Diggy Diggy ","Dheema Dheema","Manali Tarance","Mera Haath Mein"};
        img=findViewById(R.id.imageView2);
        img.setImageResource(R.drawable.bomdiggy);
    }
}