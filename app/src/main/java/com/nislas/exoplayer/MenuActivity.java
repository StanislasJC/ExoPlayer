package com.nislas.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {

    Button videoButton;
    Button audioButton;

    TextView device_name;
    TextView device_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Remove the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //Instancing each button
        videoButton = findViewById(R.id.videos_btn);
        audioButton = findViewById(R.id.audio_btn);
        device_name = findViewById((R.id.device_name));
        device_name.setText(deviceName());
        device_id = findViewById(R.id.device_id);
        device_id.setText(uniqueId());


        //Launching the video activity on video button click
        videoButton.setOnClickListener(view -> openVideosActivity());

        //Launching the audio activity on audio button click
        audioButton.setOnClickListener(view -> openAudiosActivity());

    }
    public String deviceName() {
        return Build.MANUFACTURER+" "+ Build.DEVICE;
    }

    @SuppressLint("HardwareIds")
    public String uniqueId() {
        return Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    @SuppressLint("HardwareIds")
    public String deviceID() {
        return Build.ID;
    }

    public void openVideosActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openAudiosActivity(){
        Intent intent = new Intent(this, AudioActivity.class);
        startActivity(intent);
    }
}