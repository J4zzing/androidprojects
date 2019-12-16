package com.example.app9;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
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
        db.execSQL("update info set phone=? where name=?", new Object[] {
                "888", "令狐7"
        });
        Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void delete(View view) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.execSQL("delete from info where name=?", new Object[] { "令狐7" });
        Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void findAll(View view) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from info", null);
        List<Person> people = new ArrayList<Person>();
        while (cursor.moveToNext()) {
            Person person =new Person();
            person.setId(cursor.getInt(0));
            person.setName(cursor.getString(1));
            person.setPhone(cursor.getString(2));
            people.add(person);
        }
        cursor.close();
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
