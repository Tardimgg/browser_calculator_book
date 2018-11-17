package com.example.basicviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    private ArrayList<String> base = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void onClick(View view) {
        base.add(((Button) view).getText().toString());
        StringBuilder x = new StringBuilder();
        for (String g : base) {
            x.append(g);
        }
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(x.toString());
    }

    public void onClick1(View view) {
        int answer = 0;
        for (String t : base) {
            answer += Integer.parseInt(t);
        }
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(Double.toString((double) answer / base.size()));
        base.clear();
    }
}
