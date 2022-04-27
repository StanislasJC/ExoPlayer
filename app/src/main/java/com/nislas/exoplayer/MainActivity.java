package com.nislas.exoplayer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import com.google.android.exoplayer2.ui.StyledPlayerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {



    //URL Videos tests
    //String videoURL = "https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4";
    //String videoRobotURL = "http://techslides.com/demos/sample-videos/small.mp4";
    String videoLogoURL = "https://static.videezy.com/system/resources/previews/000/020/578/original/Logo_Reveal_Animation_Mogrt_Template_01_Preview.mp4";
    String videoAztecURL = "https://static.videezy.com/system/resources/previews/000/008/220/original/Triangles_01.mp4";

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
        //Application context
        Context context = this.getApplicationContext();

        //BEGIN : TO OPTIMIZE\\

        //Adding videos to the playlist list. /// NOT OPTIMIZED \\\
        moviesPlaylist.add(videoLogoURL);
        moviesPlaylist.add(videoAztecURL);
        //Getting the size of the list
        int lengthPlaylist = moviesPlaylist.size();

        //END : TO OPTIMIZE\\

        try{
            //Building the Exoplayer instance
            exoPlayer = new ExoPlayer.Builder(context).build();

            //Adding the ExoPlayer instance to the ExoPlayer view
            exoPlayerView.setPlayer(exoPlayer);

            //for each element in the video playlist, read it on the ExoPlayer instance
            for(int i=0;i!=lengthPlaylist; i++){
                System.out.println(i);
                //Getting the media item from the URI
                MediaItem item = MediaItem.fromUri(moviesPlaylist.get(i));
                //Add the media item to the ExoPlayer instance
                exoPlayer.addMediaItem(item);
                //Preparing the ExoPlayer instance
                exoPlayer.prepare();
                // Start the playback.
                exoPlayer.play();
            }

        }catch(Exception e) {
            Log.e("TAG", "ERROR : " + e);
        }
    }
}
