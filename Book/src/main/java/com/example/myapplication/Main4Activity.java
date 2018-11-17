package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity implements View.OnTouchListener {

    float first_x;
    float first_y;
    View r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!base.output_check()) {
            base.input_method_size(2);
            base.input_window(3);
            base.input_check(true);
            Intent intent = new Intent(this, method.class);
            startActivity(intent);
            finish();
        } else {
            base.input_check(false);
            setContentView(R.layout.activity_main4);
            android.support.constraint.ConstraintLayout view = (android.support.constraint.ConstraintLayout) findViewById(R.id.view4);
            view.setOnTouchListener(this);
            Button x = (Button) findViewById(R.id.button3);
            float size = base.output_progress_size();
            x.setTextSize(size - 1.0f > 0 ? size - 1.0f : 1.0f);
            x.setTransformationMethod(null);
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
        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.open, R.anim.exit);
    }

    public void font(int progress) {
        base.input_progress_size(progress);
        base.input_window(3);
        base.input_method_size(1);
        Intent intent = new Intent(this, method.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportActionBar().setTitle("Уроки");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#393837")));
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
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
                base.input_window(3);
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

    @Override
    public void onBackPressed() {
        back();
    }

    private void back() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
        finish();
    }
}
