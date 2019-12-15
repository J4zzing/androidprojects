package com.example.app6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText et_qq;
    private EditText et_pwd;
    private CheckBox cb_remember;
    private Button bt_login;

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
                        Log.i(TAG, "记住密码");
                        String status = Environment.getExternalStorageState();
                        if (Environment.MEDIA_MOUNTED.equals(status)) {
                            File file = new File(getExternalFilesDir(null), "info.txt");
                            try {
                                FileOutputStream fos = new FileOutputStream(file);
                                String info = qq + "##" + pwd;
                                fos.write(info.getBytes());

                                fos.close();
                                Toast.makeText(getApplicationContext(), "密码保存成功", Toast.LENGTH_LONG).show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "sdcard不可写，请检查sdcard状态！", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Log.i(TAG, "无需记住密码");
                    }
                }
            }
        });

        File file = new File(getExternalFilesDir(null), "info.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String info = br.readLine();
            String qq = info.split("##")[0];
            String pwd = info.split("##")[1];
            et_qq.setText(qq);
            et_pwd.setText(pwd);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
