package com.yashladha.circlereveal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.yashladha.circlereveal.log.database.LogDatabaseHelper;

import java.util.ArrayList;

public class LOG extends AppCompatActivity {

    LogDatabaseHelper logDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        logDatabaseHelper = new LogDatabaseHelper(this);
        SQLiteDatabase db = logDatabaseHelper.getReadableDatabase();
        ArrayList<technicalWork> workArrayList = show_all(db);
        LogAdaptor adaptor = new LogAdaptor(getApplicationContext(), 0, workArrayList);
        ListView listView = (ListView) findViewById(R.id.lvItem);
        listView.setAdapter(adaptor);
    }

    public ArrayList<technicalWork> show_all(SQLiteDatabase db) {
        ArrayList<technicalWork> temp = new ArrayList<>();
        Cursor cursor = db.query("APP_LOG", new String[]{"TYPE", "MONTH", "DATE"}, null, null, null, null, null);
        if (cursor != null) {
            int cnt = 0;
            while (cursor.moveToNext()) {
                String type = cursor.getString(0);
                String month = cursor.getString(1);
                String date = cursor.getString(2);
                cnt++;
                temp.add(new technicalWork(type, month, date));
            }
            Toast.makeText(getApplicationContext(), "Log Count: " + String.valueOf(cnt), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Nothing to Display", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
        db.close();
        return temp;
    }
}
