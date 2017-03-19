package com.yashladha.circlereveal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        Button rateButton = (Button) findViewById(R.id.btSubmitRating);

        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rate = ratingBar.getRating();
                Toast.makeText(getApplicationContext(), "You rated us: " + String.valueOf(rate), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
