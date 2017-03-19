package com.yashladha.circlereveal;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView technician = (ImageView) findViewById(R.id.ivTechnician);
        ImageView complaint = (ImageView) findViewById(R.id.ivComplaint);
        ImageView rate = (ImageView) findViewById(R.id.ivRate);
        ImageView about = (ImageView) findViewById(R.id.ivAbout);
        ImageView log = (ImageView) findViewById(R.id.ivLog);

        technician.setOnClickListener(this);
        complaint.setOnClickListener(this);
        rate.setOnClickListener(this);
        about.setOnClickListener(this);
        log.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ivTechnician:
                Intent i = new Intent(MainActivity.this, Technician.class);
                ImageView sharedView = (ImageView) findViewById(R.id.ivTechnician);
                String transitionName = getString(R.string.ivTechnician);
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, sharedView, transitionName);
                startActivity(i, activityOptions.toBundle());
                break;
            case R.id.ivAbout:
                i = new Intent(MainActivity.this, About.class);
                activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(i, activityOptions.toBundle());
                break;
            case R.id.ivComplaint:
                i = new Intent(MainActivity.this, Complaint.class);
                activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(i, activityOptions.toBundle());
                break;
            case R.id.ivRate:
                i = new Intent(MainActivity.this, Rate.class);
                activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(i, activityOptions.toBundle());
                break;
            case R.id.ivLog:
                i = new Intent(MainActivity.this, LOG.class);
                activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(i, activityOptions.toBundle());
                break;
        }
    }
}
