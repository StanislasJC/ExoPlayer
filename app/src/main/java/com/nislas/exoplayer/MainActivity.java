package com.nislas.exoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.StyledPlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {


    //URL Videos tests
    //String videoURL = "https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4";
    String videoRobotURL = "http://techslides.com/demos/sample-videos/small.mp4";
    String videoLogoURL = "https://static.videezy.com/system/resources/previews/000/020/578/original/Logo_Reveal_Animation_Mogrt_Template_01_Preview.mp4";
    String videoAztecURL = "https://static.videezy.com/system/resources/previews/000/008/220/original/Triangles_01.mp4";
    String videoSweetColorsURL = "https://static.videezy.com/system/resources/previews/000/036/644/original/Fancy-1.mp4";
    String videoVortexURL = "https://static.videezy.com/system/resources/previews/000/051/885/original/200806-LoopSwirlDarkLight.mp4";
    String videoTransitionURL = "https://static.videezy.com/system/resources/previews/000/045/828/original/transition_green_bg.mp4";
    String videoGeometryMotionLoop = "https://static.videezy.com/system/resources/previews/000/050/266/original/200626-LoopColorFulMesh2.mp4";
    String videoFireURL = "https://static.videezy.com/system/resources/previews/000/021/342/original/Flame_Wall.mp4";
    String videoFireworksURL = "https://static.videezy.com/system/resources/previews/000/005/420/original/fireworks.mp4";
    String videoRocketURL = "https://static.videezy.com/system/resources/previews/000/043/912/original/Paper_art_Rocket.mp4";
    String videoShapesURL = "https://static.videezy.com/system/resources/previews/000/050/586/original/alb_kaleido1006_1080p_24fps.mp4";



    //BEGIN : TO CHANGE\\

    // TO INITIALIZE : Exoplayer view, Application context, Playlist movies list. \\

    //Variable ExoPlayer view
    ExoPlayer exoPlayer;
    StyledPlayerView exoPlayerView;
    //END : TO CHANGE\\

    //Movies playlist
    List<String> moviesPlaylist = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        exoPlayerView = findViewById(R.id.idExoPlayerView);
        resetPlaylist();
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
            //for each element in the video playlist, read it on the ExoPlayer instance
            for(int i=0;i!=moviesPlaylist.size(); i++){
                //Getting the media item from the URI
                MediaItem item = MediaItem.fromUri(moviesPlaylist.get(i));
                //Add the media item to the ExoPlayer instance
                exoPlayer.addMediaItem(item);
            }
            //Repeat mode
            exoPlayer.setRepeatMode(exoPlayer.REPEAT_MODE_ALL);
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

    public void resetPlaylist(){
        moviesPlaylist.add(videoAztecURL);
        moviesPlaylist.add(videoVortexURL);
        moviesPlaylist.add(videoSweetColorsURL);
        moviesPlaylist.add(videoTransitionURL);
        moviesPlaylist.add(videoGeometryMotionLoop);
        moviesPlaylist.add(videoFireURL);
        moviesPlaylist.add(videoFireworksURL);
        moviesPlaylist.add(videoShapesURL);
        moviesPlaylist.add(videoRocketURL);
    }

    public void openMenuActivity(){
        exoPlayer.stop();
        exoPlayer.release();
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }




}


