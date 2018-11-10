package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class admin extends Activity {
    private int old_view = base.output_admin_old_view();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.edittext);
        String j = editText.getText().toString();
        if (j.replace(" ", "").toLowerCase().replace(".", "").equals("ursa+wk==roshan") || j.replace(" ", "").toLowerCase().replace(".", "").equals("ursa+wk==freeroshan")) {
            base.input_window(1);
            base.input_progress(old_view == 0 ? 1000 : 1001);
            base.input_method(1);
            Intent intent = new Intent(this, method.class);
            startActivity(intent);
            finish();
        }else{
            TextView textView = (TextView) findViewById(R.id.textView9);
            textView.setText("Неправильно");
        }
    }
    public void onBackPressed(){
        back();
    }
    private void back() {
        Intent intent = new Intent(this, old_view == 0 ? Main0Activity.class : MainActivity.class);
        startActivity(intent);
        finish();
    }
}
