package com.itcast.product.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context) {
        super(context, "itcast.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate");
        db.execSQL("create table account(" +
                "_id integer primary key autoincrement," +
                "name varchar(20)," +
                "balance integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgrade");
    }
}
