package com.nislas.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class LoginActivity extends AppCompatActivity {

    final String loginVideoURL = "https://static.videezy.com/system/resources/previews/000/051/212/original/147_2020_GH_5_SUNRISE_5.mp4";


    ExoPlayer exoPlayer;
    StyledPlayerView exoPlayerView;

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Remove the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        exoPlayerView = findViewById(R.id.player_view_login);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> login());

        playerInitialization();
        exoPlayerSetup();
    }

    public void playerInitialization(){
        //Building the Exoplayer instance
        exoPlayer = new ExoPlayer.Builder(this).build();

        //Adding the ExoPlayer instance to the ExoPlayer view
        exoPlayerView.setPlayer(exoPlayer);
        exoPlayerView.setUseController(false);

        exoPlayerView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LOW_PROFILE |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    public void exoPlayerSetup(){
        try{
            //Getting the media item from the URI
            MediaItem item = MediaItem.fromUri(loginVideoURL);
            //Add the media item to the ExoPlayer instance
            exoPlayer.addMediaItem(item);
            //Repeat mode
            exoPlayer.setRepeatMode(Player.REPEAT_MODE_ALL);
            //Random mode
            exoPlayer.setShuffleModeEnabled(true);
            //Preparing the ExoPlayer instance
            exoPlayer.prepare();
            // Start the playback.
            exoPlayer.play();
        }catch(Exception e) {
            Log.e("TAG", "ERROR : " + e);
        }
    }

    public void login(){
        exoPlayer.stop();
        exoPlayer.release();
        Intent intent = new Intent(this, LoaderActivity.class);
        startActivity(intent);
    }

}