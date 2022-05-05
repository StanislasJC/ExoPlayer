package com.nislas.exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoaderActivity extends AppCompatActivity {

    TextView countdown;
    TextView deviceName;
    TextView deviceId;
    TextView streamaxVersion;
    Button parametersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        countdown = findViewById(R.id.countdown);
        deviceName = findViewById(R.id.device_name);
        deviceId = findViewById(R.id.device_id);
        streamaxVersion = findViewById(R.id.streamax_version);
        parametersButton = findViewById(R.id.parameters_button);

        //Remove the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentInformations();
        setCountdown();


        parametersButton.setOnClickListener(view -> startMenuActivity());

    }

    public void setCountdown(){
        new CountDownTimer(11000, 1000) {

            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                countdown.setText(" " + millisUntilFinished / 1000 + " ");
            }

            public void onFinish() {
                startMainActivity();
            }
        }.start();
    }

    public void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    public void setContentInformations(){
        deviceName.setText(deviceName());
        deviceId.setText(uniqueId());
        streamaxVersion.setText("1.0.0");

    }

    public String deviceName() {
        return Build.MANUFACTURER+" "+ Build.DEVICE;
    }

    @SuppressLint("HardwareIds")
    public String uniqueId() {
        return Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }
}