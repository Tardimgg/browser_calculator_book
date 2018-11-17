package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class method extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int method = base.output_method();
        int method1 = base.output_method_size();
        int method2 = base.output_method_check_box();
        int window = base.output_window();
        boolean check = false;
        base.input_check(true);
        if (method == 0) {
            String progress = read();
            progress = progress.equals("") ? "0" : progress;
            if (progress.equals("1001") && window == 0) {
                method = 1;
                base.input_progress(1);
                check = true;
            } else {
                base.input_progress(Integer.parseInt(progress));
                base.input_method(-1);
            }
        }
        if (method == 1) {
            if (!base.output_restart() && !check) {
                String OldProgress = read();
                if (base.output_progress() > Float.parseFloat(OldProgress.equals("") ? "0" : OldProgress)) {
                    saved(base.output_progress());

                }
            } else {
                saved(base.output_progress());
                base.input_restart(false);
            }
            base.input_method(-1);
        }
        if (method1 == 0) {
            String number = read_font();
            int font = Integer.parseInt(number.equals("") ? "18" : number);
            base.input_progress_size(font);
            base.input_method_size(-1);
        } else if (method1 == 1) {
            saved_font(base.output_progress_size());
            base.input_method_size(-1);
        }
        if (method2 == 0) {
            String number = read_check_box();
            base.input_progress_boolean(!number.equals("") && number.equals("true"));
            base.input_method_check_box(-1);
        } else if (method2 == 1) {
            saved_check_box(Boolean.toString(base.output_progress_boolean()));
            base.input_method_check_box(-1);
        }
        if (base.output_default_font()) {
            saved_font(-1);
            saved_check_box(Boolean.toString(false));
            base.input_default_font(false);
        }
        Intent intent;
        switch (window) {
            case 0:
                intent = new Intent(this, MainActivity.class);
                break;
            case 1:
                intent = new Intent(this, Main0Activity.class);
                break;
            case 2:
                intent = new Intent(this, Main3Activity.class);
                break;
            case 3:
                intent = new Intent(this, Main4Activity.class);
                break;
            case 4:
                intent = new Intent(this, Main5Activity.class);
                break;
            case 5:
                intent = new Intent(this, Main6Activity.class);
                break;
            case 6:
                intent = new Intent(this, Main7Activity.class);
                break;
            case 7:
                intent = new Intent(this, Main8Activity.class);
                break;
            default:
                intent = new Intent(this, MainActivity.class);
                break;
        }
        startActivity(intent);
        finish();
    }

    public void saved(int progress) {
        SharedPreferences sPref = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("saved_text", Integer.toString(progress));
        ed.commit();
    }

    public String read() {
        SharedPreferences sPref = this.getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString("saved_text", "");
        return savedText;
    }

    public void saved_font(int progress) {
        SharedPreferences sPref_font = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref_font.edit();
        ed.putString("saved_text1", progress == -1 ? "" : Integer.toString(progress));
        ed.commit();
    }

    public String read_font() {
        SharedPreferences sPref_font = this.getPreferences(MODE_PRIVATE);
        String savedText = sPref_font.getString("saved_text1", "");
        return savedText;
    }

    public void saved_check_box(String progress) {
        SharedPreferences sPref_check_box = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref_check_box.edit();
        ed.putString("saved_text2", progress.equals("-1") ? "" : progress);
        ed.commit();
    }

    public String read_check_box() {
        SharedPreferences sPref_check_box = this.getPreferences(MODE_PRIVATE);
        String savedText = sPref_check_box.getString("saved_text2", "");
        return savedText;
    }
}
