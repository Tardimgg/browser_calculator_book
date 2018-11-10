package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView x = (TextView) findViewById(R.id.textView3);
        String h = "Принимая условия использования вы подтверждаите, то что вы хуй.";
        for (int i = 0; i < 18; i++) {
            h += " Принимая условия использования вы подтверждаите, то что вы хуй.";
        }
        x.setText(h);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    public void onBackPressed() {
        Intent intent = new Intent (this, Main0Activity.class);
        startActivity(intent);
        finish();
    }
}

