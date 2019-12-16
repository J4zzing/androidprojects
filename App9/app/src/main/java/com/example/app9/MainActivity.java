package com.example.app9;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private MyOpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new MyOpenHelper(getApplicationContext());
//        openHelper.getWritableDatabase();
    }

    public void add(View view) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Random random = new Random();
        db.execSQL("insert into info(name, phone) values(?, ?)", new Object[]{
                "令狐" + random.nextInt(100), "123456" + random.nextInt(100)
        });
        Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void update(View view) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Random random = new Random();
        db.execSQL("update info set phone=? where name=?", new Object[] {
                "888", "令狐"
        });
    }
}
