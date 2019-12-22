package com.example.app14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv_list);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> m1 = new HashMap<String, Object>();
//        m1.put("avatar", )
        m1.put("name", "大炮");
        Map<String, Object> m2 = new HashMap<String, Object>();
//        m1.put("avatar", )
        m2.put("name", "小明");
        Map<String, Object> m3 = new HashMap<String, Object>();
//        m1.put("avatar", )
        m3.put("name", "牛头");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        lv.setAdapter(new SimpleAdapter(
                getApplicationContext(),
                list,
                R.layout.my_item,
                new String[] {"name"},
                new int[] {R.id.textView}
        ));
    }
}
