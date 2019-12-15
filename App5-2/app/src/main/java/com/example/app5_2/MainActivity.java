package com.example.app5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_qq;
    private EditText et_pwd;
    private CheckBox cb_remember;
    private Button bt_login;
    private static final String Tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_qq = findViewById(R.id.et_qq);
        et_pwd = findViewById(R.id.et_pwd);
        cb_remember = findViewById(R.id.cb_remember);
        bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String qq = et_qq.getText().toString();
                String pwd = et_pwd.getText().toString();
                if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(getApplicationContext(), "用户名或密码不能为空！", Toast.LENGTH_LONG).show();
                } else {
                    if (cb_remember.isChecked()) {
                        Log.i(Tag, "记住密码。");
                    } else {
                        Log.i(Tag, "无需记住密码。");
                    }
                }
            }
        });

    }
}
