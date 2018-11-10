package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Main5Activity extends AppCompatActivity implements View.OnTouchListener {

    private float first_x;
    private float first_y;
    private Button x0;
    private Button x;
    private Button x1;
    private int height_width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (base.output_default_settings()) {
            base.input_check(false);
            base.input_default_settings(false);
        }
        if (!base.output_check()) {
            base.input_method(0);
            base.input_window(4);
            base.input_method_size(base.output_check_size_back() ? 1 : 0);
            Intent intent = new Intent(this, method.class);
            startActivity(intent);
            finish();
        } else {
            base.input_check(false);
            setContentView(R.layout.activity_main5);
            final android.support.constraint.ConstraintLayout view = (android.support.constraint.ConstraintLayout) findViewById(R.id.view5);
            view.setOnTouchListener(this);
            x0 = (Button) findViewById(R.id.button);
            x = (Button) findViewById(R.id.button1);
            x1 = (Button) findViewById(R.id.button2);
            int progress = base.output_progress();
            float size = base.output_progress_size();
            x.setEnabled(progress >= 2);
            x1.setEnabled(progress >= 3);
            x0.setTextSize(size - 1.0f > 0 ? size - 1.0f : 1.0f);
            x.setTextSize(size - 1.0f > 0 ? size - 1.0f : 1.0f);
            x1.setTextSize(size - 1.0f > 0 ? size - 1.0f : 1.0f);
            x0.setTransformationMethod(null);
            x.setTransformationMethod(null);
            x1.setTransformationMethod(null);
            int max = view.getMeasuredWidth() / 4;
            x0.setMaxWidth(max);
            x.setMaxWidth(max);
            x1.setMaxWidth(max);
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    height_width = Math.max(Math.max(x0.getWidth(), x.getWidth()), x1.getWidth());
                    x0.setMinHeight(height_width);
                    x.setMinHeight(height_width);
                    x1.setMinHeight(height_width);
                    x0.setWidth(height_width);
                    x.setWidth(height_width);
                    x1.setWidth(height_width);
                    view.setMinHeight(findViewById(R.id.view5_scroll).getMeasuredHeight());
                }
            });
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:// нажатие
                first_x = x;
                first_y = y;
                break;
            case MotionEvent.ACTION_MOVE: // движение
                break;
            case MotionEvent.ACTION_UP: // отпускание
                if (Math.abs(first_y - y) <= Math.abs(first_x - x) && first_x < x) {
                    onBackPressed();
                }
                break;
        }
        return true;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, Main6Activity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.open1, R.anim.exit);

    }

    public void onClick1(View view) {
        Intent intent = new Intent(this, Main7Activity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.open1, R.anim.exit);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, Main8Activity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.open1, R.anim.exit);
    }

    public void font(int progress) {
        base.input_progress_size(progress);
        base.input_window(4);
        base.input_method_size(1);
        Intent intent = new Intent(this, method.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportActionBar().setTitle("Основы");
        //LayoutInflater li = LayoutInflater.from(this);
        //final View view =  li.inflate(R.layout.activity_menu, null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setCustomView(view);
        //((TextView) view.findViewById(R.id.view_bar)).setTextSize(base.output_progress_size() + 6.0f);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#393837")));
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case (R.id.item1):
                Uri address = Uri.parse("https://ru.stackoverflow.com/questions/ask");
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openlinkIntent);
                break;
            case (R.id.item2):
                //Получаем вид с файла activity_dialog.xml, который применим для диалогового окна:
                LayoutInflater li = LayoutInflater.from(this);
                final View promptsView = li.inflate(R.layout.activity_dialog, null);

                //Создаем AlertDialog
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);

                //Настраиваем activity_dialog.xml для нашего AlertDialog:
                mDialogBuilder.setView(promptsView);

                //Настраиваем отображение поля для ввода текста в открытом диалоге:
                final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);

                float size = base.output_progress_size();

                userInput.setTextSize(size - 2.0f);
                ((TextView) promptsView.findViewById(R.id.text_dialog)).setTextSize(size - 1.0f);
                //Настраиваем сообщение в диалоговом окне:
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //Вводим текст и отображаем в строке ввода на основном экране:
                                        try {
                                            font(Integer.parseInt(userInput.getText().toString()));
                                        } catch (Exception e) {

                                        }
                                    }
                                })
                        .setNegativeButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });


                //и отображаем его:
                mDialogBuilder.show();
                break;
            case (R.id.item3):
                base.input_progress_size(18);
                base.input_method_size(1);
                base.input_window(4);
                Intent intent = new Intent(this, method.class);
                startActivity(intent);
                finish();
                break;
            case (R.id.item4):
                Uri adress = Uri.parse("https://docs.oracle.com/javase/10/");
                Intent open_documentation = new Intent(Intent.ACTION_VIEW, adress);
                startActivity(open_documentation);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        back();
    }

    private void back() {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.open3, R.anim.exit);
    }


}
