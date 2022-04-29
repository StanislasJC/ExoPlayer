package com.nislas.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import java.util.ArrayList;
import java.util.List;


public class AudioActivity extends AppCompatActivity {

    ExoPlayer exoPlayer;
    StyledPlayerView styledPlayerView;

    //TO DELETE\\
    //ImageView imageViewAudioPlayer;

    String videoGeometryMotionLoop = "https://static.videezy.com/system/resources/previews/000/050/266/original/200626-LoopColorFulMesh2.mp4";
    String songHelix1URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
    String songHelix2URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3";
    String songHelix3URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3";
    String songHelix4URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-4.mp3";
    String songHelix5URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-5.mp3";
    String songHelix6URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-6.mp3";
    String songHelix7URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-7.mp3";
    String songHelix8URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3";

    String audioStreamingURL = "https://stream.audioxi.com/SW";

    List<String> audioPlaylist = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        styledPlayerView = findViewById(R.id.styled_audio_player);

        //TO DELETE\\
        //imageViewAudioPlayer = findViewById(R.id.imageview_audio_player);

        //Remove the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        audioPlaylist.add(songHelix1URL);
        audioPlaylist.add(songHelix2URL);
        audioPlaylist.add(songHelix3URL);
        audioPlaylist.add(songHelix4URL);
        audioPlaylist.add(songHelix5URL);
        audioPlaylist.add(songHelix6URL);
        audioPlaylist.add(songHelix7URL);
        audioPlaylist.add(songHelix8URL);

        int audioPlaylistLength = audioPlaylist.size();

        exoPlayerSetup(audioPlaylistLength);

    }

    public void exoPlayerSetup(int audioPlaylistLength){
        try{

            exoPlayer = new ExoPlayer.Builder(this).build();
            styledPlayerView.setPlayer(exoPlayer);
            styledPlayerView.setUseController(false);
            //exoPlayer.getPlayWhenReady();

            styledPlayerView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LOW_PROFILE |
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );

            for(int i=0; i != audioPlaylistLength; i++){
                MediaItem item = MediaItem.fromUri(audioPlaylist.get(i));
                exoPlayer.addMediaItem(item);

                exoPlayer.prepare();

                exoPlayer.play();
            }

        }catch(Exception e) {
            Log.e("TAG", "ERROR : " + e);
        }
    }


}