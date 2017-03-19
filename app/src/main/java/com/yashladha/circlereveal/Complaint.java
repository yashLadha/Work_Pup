package com.yashladha.circlereveal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Complaint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        Button submitButton = (Button) findViewById(R.id.btSubmitComplaint);
        final EditText complaintText = (EditText) findViewById(R.id.etComplaintText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String complaint = complaintText.getText().toString();
                Toast.makeText(getApplicationContext(), "Complaint Sent Succesfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
