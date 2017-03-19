package com.yashladha.circlereveal.log.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LogDatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "LOG";
    private static final int DB_VERSION = 1;

    public LogDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE APP_LOG ( "
                + "_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "TYPE TEXT, "
                + "MONTH TEXT, "
                + "DATE TEXT); "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
