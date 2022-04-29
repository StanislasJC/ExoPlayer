package com.nislas.exoplayer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;

import java.util.ArrayList;
import java.util.List;


public class TvActivity extends Activity {

    //URL Videos tests
    String videoLogoURL = "https://static.videezy.com/system/resources/previews/000/020/578/original/Logo_Reveal_Animation_Mogrt_Template_01_Preview.mp4";
    String videoAztecURL = "https://static.videezy.com/system/resources/previews/000/008/220/original/Triangles_01.mp4";
    String videoSweetColorsURL = "https://static.videezy.com/system/resources/previews/000/036/644/original/Fancy-1.mp4";
    String videoVortexURL = "https://static.videezy.com/system/resources/previews/000/051/885/original/200806-LoopSwirlDarkLight.mp4";
    String videoTransitionURL = "https://static.videezy.com/system/resources/previews/000/045/828/original/transition_green_bg.mp4";
    String videoGeometryMotionLoop = "https://static.videezy.com/system/resources/previews/000/050/266/original/200626-LoopColorFulMesh2.mp4";

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
        setContentView(R.layout.activity_tv);
        exoPlayerView = findViewById(R.id.idExoPlayerView);

        //Application context
        Context context = this.getApplicationContext();

        //BEGIN : TO OPTIMIZE\\

        //Adding videos to the playlist list. /// NOT OPTIMIZED \\\
        moviesPlaylist.add(videoLogoURL);
        moviesPlaylist.add(videoAztecURL);
        moviesPlaylist.add(videoSweetColorsURL);
        moviesPlaylist.add(videoVortexURL);
        moviesPlaylist.add(videoTransitionURL);
        moviesPlaylist.add(videoGeometryMotionLoop);
        //Getting the size of the list
        int lengthPlaylist = moviesPlaylist.size();

        //END : TO OPTIMIZE\\
        exoPlayerSetup(lengthPlaylist);

    }

    public void exoPlayerSetup(int lengthPlaylist){
        try{
            //Building the Exoplayer instance
            exoPlayer = new ExoPlayer.Builder(this).build();

            //Adding the ExoPlayer instance to the ExoPlayer view
            exoPlayerView.setPlayer(exoPlayer);
            exoPlayerView.setUseController(false);
            //exoPlayer.getPlayWhenReady();

            exoPlayerView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LOW_PROFILE |
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );

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
