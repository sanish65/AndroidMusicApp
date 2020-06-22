package com.example.user.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int currentposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=(Button)findViewById(R.id.bttn_play);
        pause=(Button)findViewById(R.id.bttn_pause);
        stop=(Button)findViewById(R.id.bttn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {

            case R.id.bttn_play:
                if(mediaPlayer==null)
                {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.song);
                mediaPlayer.start();
                }

                else if(!mediaPlayer.isPlaying())
                      {
                mediaPlayer.seekTo(currentposition);
                mediaPlayer.start();
                      }
                break;

                   case R.id.bttn_pause:
                       if(mediaPlayer!=null)
                       {
                           mediaPlayer.pause();
                           currentposition=mediaPlayer.getCurrentPosition();

                       }
            break;


               case R.id.bttn_stop:
                   if(mediaPlayer!=null)
                   {
                       mediaPlayer.stop();
                       mediaPlayer=null;
                   }
            break;

        }
    }
}
