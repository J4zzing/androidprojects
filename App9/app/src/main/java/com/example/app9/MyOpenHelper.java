package com.example.app9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

    protected MyOpenHelper(Context context) {
        super(context, "Person.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate");
        db.execSQL("create table info(" +
                "id integer primary key autoincrement," +
                "name varchar(20)," +
                "phone varchar(20)" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        System.out.println("onUpgrade");
    }
}
