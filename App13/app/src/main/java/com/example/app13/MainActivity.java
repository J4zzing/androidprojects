package com.example.app13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv_list);
        lv.setAdapter(new ArrayAdapter<String>(
                this, R.layout.tv_item,
                new String[] {
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                }
        ));
//        lv.setAdapter(new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return Integer.MAX_VALUE;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return 0;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                TextView tv = new TextView(getApplicationContext());
//                tv.setText("位置：" + position);
//                return tv;
//            }
//        });
    }
}
