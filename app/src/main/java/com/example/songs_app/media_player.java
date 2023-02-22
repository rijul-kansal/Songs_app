package com.example.songs_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class media_player extends AppCompatActivity
{

 Button play_btn,pause_btn,forward_btn,backward_btm,go_to;
 TextView title_tv,current_tv;
 SeekBar sk1;
 ImageView img;


 String[] Romantic = {"Duniyaa", "Rozana", "Wang da Naap", "Hamnava mera", "Tay hai"};
 String[] Punjabi = {"Daku", "Suit", "8 parche", "same Time Same jagha", "Slowly Slowly"};
 String[] English = {"ily", "one kiss", "talking to the moon", "Blinding Lights", "Need to know"};
 String[] Hindi = {"Nashe se Chadd gai", "Bom Diggy Diggy ", "Dheema Dheema", "Manali Tarance", "Mera Haath Mein"};
 long startTime=0;
 long finalTime=0;
 double forwardTime=10000;
 double backwardime=10000;
 int oneTime=0;
 int mediaisplaying=0;
 String durationStr;


 MediaPlayer mediaPlayer;
 Handler handler= new Handler();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.pause();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        img = findViewById(R.id.imageView2);
        play_btn=findViewById(R.id.play);
        pause_btn=findViewById(R.id.stop);
        forward_btn=findViewById(R.id.forward);
        backward_btm=findViewById(R.id.backward);
        title_tv=findViewById(R.id.title);
        current_tv=findViewById(R.id.current);
        sk1=findViewById(R.id.seekBar);
        go_to=findViewById(R.id.back);

        Intent i=getIntent();
        startTime=i.getIntExtra("stt",0);
        title_tv.setText(" "+startTime);
        song_selection();
        Play_Muic();



        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mediaPlayer.start();
            }

        });
        pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        forward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long temp=startTime;
                if((temp+forwardTime)<=finalTime)
                {
                    startTime+=forwardTime;
                    mediaPlayer.seekTo((int)startTime);
                }
                else
                {
                    mediaPlayer.seekTo((int)finalTime);
                }
            }
        });
        backward_btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long temp=startTime;
                if((temp-backwardime)>0)
                {
                    startTime-=forwardTime;
                    mediaPlayer.seekTo((int)startTime);
                }
                else
                {
                    mediaPlayer.seekTo(0);
                }
            }
        });
        go_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),romantic_songs.class);
                i.putExtra("st",startTime);
                i.putExtra("ft",finalTime);
                startActivity(i);
            }
        });
    }

    private void  Play_Muic()
    {
       finalTime=mediaPlayer.getDuration();
       startTime+=mediaPlayer.getCurrentPosition();
        if(oneTime==0)
        {
            sk1.setMax((int)finalTime);
            oneTime=1;
        }
        sk1.setProgress((int)startTime);
        durationStr = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(finalTime),
                TimeUnit.MILLISECONDS.toSeconds(finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(finalTime)));
        handler.postDelayed(UpdateSongTime,100);
    }
    private Runnable UpdateSongTime= new Runnable()
    {
        @Override
        public void run() {
            startTime=mediaPlayer.getCurrentPosition();
            current_tv.setText(String.format("%d:%d / ",
                    TimeUnit.MILLISECONDS.toMinutes((long)startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long)startTime)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
            +" "+durationStr);
            sk1.setProgress((int)startTime);
            handler.postDelayed(this, 100);
        }
    };
    protected void song_selection()
    {
            Intent i = getIntent();
            String type = i.getStringExtra("song_type");
            int pos = i.getIntExtra("pos", 0);
            if (type.equals("Romantic") && pos == 0) {
                mediaPlayer = MediaPlayer.create(this, R.raw.duniyaa);
                title_tv.setText(getResources().getIdentifier("duniyaa","raw",getPackageName()));
                img.setImageResource(R.drawable.duniyaa);
            }
            else if (type.equals("Romantic") && pos == 1) {
                mediaPlayer = MediaPlayer.create(this, R.raw.rozana);
                title_tv.setText(getResources().getIdentifier("rozana","raw",getPackageName()));
                img.setImageResource(R.drawable.rozana);
            }
            else if (type.equals("Romantic") && pos == 2) {
                mediaPlayer = MediaPlayer.create(this, R.raw.wang_da_naap);
                title_tv.setText(getResources().getIdentifier("wang_da_naap","raw",getPackageName()));
                img.setImageResource(R.drawable.wangdanaap);
            }
            else if (type.equals("Romantic") && pos == 3) {
                mediaPlayer = MediaPlayer.create(this, R.raw.humnava_mera);
                title_tv.setText(getResources().getIdentifier("humnava_mera","raw",getPackageName()));
                img.setImageResource(R.drawable.hamnavamera);
            }
            else if (type.equals("Romantic") && pos == 4) {
                mediaPlayer = MediaPlayer.create(this, R.raw.tay_hai);
                title_tv.setText(getResources().getIdentifier("tay_hai","raw",getPackageName()));
                img.setImageResource(R.drawable.tayhai);
            }
    }
}

