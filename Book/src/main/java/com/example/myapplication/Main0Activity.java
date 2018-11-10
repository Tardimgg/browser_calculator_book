package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;


public class Main0Activity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (base.output_default_settings()){
            base.input_check(false);
            base.input_default_settings(false);
        }
        if (base.output_check()){
            base.input_check(false);
            Intent intent = new Intent(this, Main3Activity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_main);
        CheckBox x = (CheckBox) findViewById(R.id.checkBox);
        Button button = (Button) findViewById(R.id.button);
        button.setEnabled(x.isChecked());
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    public void onClick(View view) {
        CheckBox x = (CheckBox) findViewById(R.id.checkBox);
        Button button = (Button) findViewById(R.id.button);
        button.setEnabled(x.isChecked());
    }
    public void onClick1(View view) {
        try {
            write();
        }catch (Exception e){}
        Intent intent = new Intent(this, method.class);
        startActivity(intent);
        finish();
    }
    public void onClick2(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
    public void onClick3(View view) {
        base.input_admin_old_view(0);
        Intent intent = new Intent(this, admin.class);
        startActivity(intent);
        finish();
    }
    private void write()throws Exception{
        if (!base.output_check()) {
            base.input_check(false);
            base.input_method(1);
            base.input_window(1);
            base.input_progress(1);
            base.input_restart(true);
        }
    }
    public void onBackPressed(){
        back();
    }
    private void back(){
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.activity_exit, null);
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Main0Activity.this);
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