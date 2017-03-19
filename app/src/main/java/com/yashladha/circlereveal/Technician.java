package com.yashladha.circlereveal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.yashladha.circlereveal.log.database.LogDatabaseHelper;

import java.util.Calendar;

public class Technician extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician);

        final Spinner typeTechnician = (Spinner) findViewById(R.id.spJobs);
        final Spinner month = (Spinner) findViewById(R.id.spMonth);
        final Spinner date = (Spinner) findViewById(R.id.spDate);
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.tbutCurrent);
        final ImageView send = (ImageView) findViewById(R.id.ivSend);

        LogDatabaseHelper db_helper = new LogDatabaseHelper(this);
        final SQLiteDatabase db = db_helper.getWritableDatabase();

        toggleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toggleButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    toggleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    toggleButton.setTextColor(getResources().getColor(R.color.colorPrimary));
                    month.setVisibility(View.GONE);
                    date.setVisibility(View.GONE);
                } else {
                    toggleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    toggleButton.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    month.setVisibility(View.VISIBLE);
                    date.setVisibility(View.VISIBLE);
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typeWork = typeTechnician.getSelectedItem().toString();
                technicalWork work = null;
                if (!toggleButton.isChecked()) {
                    String strMonth = month.getSelectedItem().toString();
                    String strDate = date.getSelectedItem().toString();
                    work = new technicalWork(typeWork, strMonth, strDate);
                } else {
                    Calendar c = Calendar.getInstance();
                    int intMonth = c.get(Calendar.MONTH);
                    String[] monthArray = getResources().getStringArray(R.array.Months);
                    String strMonth = monthArray[intMonth];
                    String strDate = String.valueOf(c.get(Calendar.DATE));
                    work = new technicalWork(typeWork, strMonth, strDate);
                }
                insertData(db, work);
            }
        });
    }

    private void insertData(SQLiteDatabase db, technicalWork work) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TYPE", work.getType());
        contentValues.put("MONTH", work.getMonth());
        contentValues.put("DATE", work.getDate());
        db.insert("APP_LOG", null, contentValues);
        Toast.makeText(getApplicationContext(), "Submitted Successfully", Toast.LENGTH_SHORT).show();
    }
}
