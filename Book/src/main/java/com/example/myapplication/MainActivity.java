package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            int answer = writer();
            if (answer == -1) {
                Intent intent = new Intent(this, method.class);
                startActivity(intent);
                finish();
            }
            if (answer == 0 || answer == 1000) {
                Intent intent = new Intent(this, Main0Activity.class);
                startActivity(intent);
                finish();
            }
            if (answer != 0) {
                setContentView(R.layout.activity_main0);
                float size = base.output_progress_size();
                TextView textView = (TextView) findViewById(R.id.button19);
                TextView textView1 = (TextView) findViewById(R.id.button20);
                textView.setTransformationMethod(null);
                textView1.setTransformationMethod(null);

                textView.setTextSize(size - 1.0f > 0 ? size - 1.0f : 1.0f);
                textView1.setTextSize(size - 10.0f > 0 ? size - 10.0f : 1.0f);
                final android.support.constraint.ConstraintLayout view = (android.support.constraint.ConstraintLayout) findViewById(R.id.view0);
                view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        view.setMinHeight(findViewById(R.id.view0_scroll).getMeasuredHeight());
                    }
                });
            }

        } catch (Exception e) {}
    }

    private int writer() throws Exception {
        int answer = -1;
        if (!base.output_check()) {
            base.input_window(0);
            base.input_method(0);
            base.input_method_size(0);
        } else {
            base.input_check(false);
            answer = base.output_progress();
        }
        return answer;
    }

    public void onClick(View view) {
        Intent x = new Intent(this, Main3Activity.class);
        startActivity(x);
        finish();
    }

    public void onClick1(View view) throws Exception {
        base.input_progress(0);
        base.input_window(1);
        base.input_method(1);
        base.input_default_settings(true);
        base.input_default_fout(true);
        base.input_restart(true);
        Intent x = new Intent(this, method.class);
        startActivity(x);
        finish();
    }
    public void onClick3(View view) {
        base.input_admin_old_view(1);
        Intent intent = new Intent(this, admin.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        back();
    }
    private void back(){
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.activity_exit, null);
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(MainActivity.this);
        quitDialog.setView(promptsView);
        ((TextView) promptsView.findViewById(R.id.text_exit)).setTextSize(base.output_progress_size() - 1.0f);
        quitDialog
                .setCancelable(false)
                .setPositiveButton("Да",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                .setNegativeButton("Нет",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


        //и отображаем его:
        quitDialog.show();
    }
}

