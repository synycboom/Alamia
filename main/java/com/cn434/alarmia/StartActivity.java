package com.cn434.alarmia;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ImageButton newAlarm = (ImageButton) findViewById(R.id.button_add);
        newAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean settingIsFull = false;
                //search available setting file
                for(int i = 1;i <= 10;i++) {
                    String prefName = i + "";
                    SharedPreferences mPreferences = getSharedPreferences(prefName,Activity.MODE_WORLD_READABLE);
                    if(!mPreferences.getBoolean("status",false)) {
                        DataProvider.currentSettingName = prefName;
                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.putBoolean("status",false);
                        editor.commit();
                        settingIsFull = false;
                        break;

                    } else {
                        settingIsFull = true;
                    }
                }

                if(settingIsFull) {
                    Intent intent  = new Intent(StartActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent  = new Intent(StartActivity.this,SetTimerActivity.class);
                    startActivity(intent);
                    finish();
                }




            }
        });

    }
}
