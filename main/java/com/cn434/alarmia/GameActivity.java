package com.cn434.alarmia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by samsung on 24/2/2558.
 */
public class GameActivity extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_game);
        Button doneButton = (Button) findViewById(R.id.button_done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(GameActivity.this,SetTimerActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}
