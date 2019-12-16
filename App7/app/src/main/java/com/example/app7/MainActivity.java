package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Xml;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_info = findViewById(R.id.tv_info);
        WeatherInfo weatherInfo = new WeatherInfo();

        AssetManager am = this.getAssets();
        try {
            InputStream is = am.open("weather.xml");
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(is, "utf-8");
            int type = parser.getEventType();
            while(type != XmlPullParser.END_DOCUMENT) {
                if (type == XmlPullParser.START_TAG) {
                    switch (parser.getName()) {
                        case "name":
                            String name = parser.nextText();
                            weatherInfo.setName(name);
                            break;
                        case "weather":
                            String weather = parser.nextText();
                            weatherInfo.setWeather(weather);
                            break;
                        case "temp":
                            String temp = parser.nextText();
                            weatherInfo.setTemp(temp);
                            break;
                        case "info":
                            String info = parser.nextText();
                            weatherInfo.setInfo(info);
                            break;
                    }
                }
                type = parser.next();
                System.out.println("type=" + weatherInfo.toString());
            }
            Toast.makeText(getApplicationContext(), weatherInfo.toString(), Toast.LENGTH_LONG).show();
            tv_info.setText(weatherInfo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }



    }
}
