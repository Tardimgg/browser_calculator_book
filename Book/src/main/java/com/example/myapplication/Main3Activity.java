package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


public class Main3Activity extends Activity implements View.OnTouchListener{

    private Button x0;
    private Button x;
    private Button x1;
    //private int height_touch;
    //private int width_touch;
    private int height_width;
    public boolean check_touch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!base.output_check()) {
            base.input_window(2);
            base.input_method_size(0);
            Intent intent = new Intent(this, method.class);
            startActivity(intent);
            finish();
        } else {
            base.input_check(false);
            setContentView(R.layout.activity_main3);
            x0 = (Button) findViewById(R.id.button);
            x = (Button) findViewById(R.id.button1);
            x1 = (Button) findViewById(R.id.button2);
            float size = base.output_progress_size();
            x0.setTextSize(size - 1.0f > 0 ? size - 1.0f : 1.0f);
            x.setTextSize(size - 1.0f > 0 ? size - 1.0f : 1.0f);
            x1.setTextSize(size - 1.0f > 0 ? size - 1.0f : 1.0f);
            x0.setTransformationMethod(null);
            x.setTransformationMethod(null);
            x1.setTransformationMethod(null);
            int max = getWindowManager().getDefaultDisplay().getWidth() / 4;
            x0.setMaxWidth(max);
            x.setMaxWidth(max);
            x1.setMaxWidth(max);
            ImageView imageView = (ImageView) findViewById(R.id.imageView2);
            imageView.setOnTouchListener(this);
            final android.support.constraint.ConstraintLayout view = (android.support.constraint.ConstraintLayout) findViewById(R.id.view3);
            view.getViewTreeObserver().addOnGlobalLayoutListener( new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    height_width = Math.max(Math.max(x0.getWidth(), x.getWidth()), x1.getWidth());
                    x0.setMinHeight(height_width);
                    x.setMinHeight(height_width);
                    x1.setMinHeight(height_width);
                    x0.setWidth(height_width);
                    x.setWidth(height_width);
                    x1.setWidth(height_width);
                    ScrollView scroll = (ScrollView) findViewById(R.id.view3_scroll);
                    int height = scroll.getMeasuredHeight();
                    int width = scroll.getMeasuredWidth();
                    view.setMinHeight(height);
                    ImageView imageButton = (ImageView) findViewById(R.id.imageView2);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) imageButton.getLayoutParams();
                    params.height = (int) (height / 1.5);
                    params.width = (int) (width / 1.5);
                    //height_touch = (int) (height / 1.5);
                    //width_touch = (int) (width / 1.5);
                    imageButton.setLayoutParams(params);
                }
            });
        }
    }

    @Override
    public boolean onTouch (View view, MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: // нажатие
                if (!check_touch) {
                    view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.touch_button));
                    check_touch = true;
                }
                break;
            case MotionEvent.ACTION_MOVE: // движение
               break;
            case MotionEvent.ACTION_UP: // отпускание
                Uri address = Uri.parse("https://play.google.com/store/apps/details?id=com.duy.compiler.javanide&hl=ru");
                Intent intent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(intent);
               //ImageView image = (ImageView) findViewById(R.id.imageView2);
               //ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) image.getLayoutParams();
               //params.height =  height_touch;
               //params.width = width_touch;
               //image.setLayoutParams(params);
                check_touch = false;
                break;
        }
        return true;

    }
    public void onClick(View view) {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
        finish();
    }

    public void onClick1(View view) {
        //Intent intent = new Intent(this, );
        //startActivity(intent);
    }

    public void onClick2(View view) {
        //Intent intent = new Intent(this, );
        //startActivity(intent);
    }


    public void onBackPressed() {
        back();
    }

    private void back() {
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.activity_exit, null);
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Main3Activity.this);
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
