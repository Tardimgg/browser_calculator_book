package com.example.myapplication;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    private boolean check = false;
    private boolean check1 = false;
    private boolean check_music_wrong = false;
    private boolean check_music_correctly = false;
    private boolean check_wrong = false;
    private boolean check_correctly = false;
    private boolean check_first_Tree_observer = false;
    private boolean check_change_size_font = false;
    private int old_page;
    private MediaPlayer full_correctly;
    private MediaPlayer full_wrong;
    private MediaPlayer correctly;
    private MediaPlayer wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!base.output_check()) {
            base.input_method_size(0);
            base.input_window(5);
            base.input_method_check_box(0);
            base.input_check(true);
            Intent intent = new Intent(this, method.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_main6);
            base.input_check(false);
            final float size = base.output_progress_size();
            if (size != 18 && !base.output_progress_boolean()) {
                //quitDialog.show();
                LayoutInflater li = LayoutInflater.from(this);
                View promptsView = li.inflate(R.layout.activity_dialog_size_font, null);

                //Создаем AlertDialog
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);

                //Настраиваем activity_dialog.xml для нашего AlertDialog:
                mDialogBuilder.setView(promptsView);

                //Настраиваем отображение поля для ввода текста в открытом диалоге:
                final CheckBox checkBox = (CheckBox) promptsView.findViewById(R.id.checkbox);

                checkBox.setTextSize(size - 2.0f);
                ((TextView) promptsView.findViewById(R.id.text_dialog_size)).setTextSize(size - 1.0f);
                //Настраиваем сообщение в диалоговом окне:
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Да",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //Вводим текст и отображаем в строке ввода на основном экране:
                                        if (checkBox.isChecked()) {
                                            saved_box();
                                        } else {
                                            base.input_check(false);
                                            onCreateOptionsMenu(null);
                                            float size = (float) base.output_progress_size();
                                            if (size != 0.0f) {
                                                TextView q = (TextView) findViewById(R.id.textView1);
                                                TextView w = (TextView) findViewById(R.id.textView2);
                                                q.setTextSize(size + 7.0f);
                                                w.setTextSize(size);
                                            }
                                        }
                                    }
                                })
                        .setNegativeButton("Нет",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if (checkBox.isChecked()) {
                                            base.input_check_box_size(true);
                                            saved_box();
                                        }
                                        base.input_progress_size(18);
                                        dialog.cancel();
                                    }
                                });

                //и отображаем его:
                mDialogBuilder.show();
            } else {
                if (size != 18 && !base.output_check_box_size()) {
                    base.input_check(false);
                } else if (base.output_check_box_size()) {
                    base.input_check_box_size(false);
                }
                ViewPager view = (ViewPager) findViewById(R.id.view6);
                view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if (!check_first_Tree_observer) {
                            TextView q = (TextView) findViewById(R.id.textView1);
                            TextView w = (TextView) findViewById(R.id.textView2);
                            q.setTextSize(size + 7.0f);
                            w.setTextSize(size);
                            check_first_Tree_observer = true;
                        }
                    }
                });
                check_change_size_font = true;
            }
            ViewPager pager = (ViewPager) findViewById(R.id.view6);
            pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (positionOffset == 0.0f) {
                        old_page = position;
                    }
                    if (positionOffset > 0) {
                        transformText(old_page == position ? position + 1 : position, 0);
                    }
                }

                @Override
                public void onPageSelected(int position) {
                    transformText(position, 0);
                }

                @Override
                public void onPageScrollStateChanged(int state) {


                }

            });
        }
    }

    public void saved_box() {
        base.input_progress_boolean(true);
        base.input_method_check_box(1);
        Intent intent = new Intent(this, method.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void transformText(int position, int stage) {
        float size = base.output_progress_size();
        if (position == 0) {

            TextView text = (TextView) findViewById(R.id.textView1);
            if ((int) (text.getTextSize() / getApplicationContext().getResources().getDisplayMetrics().density) != size + 7.0f) {
                text.setTextSize(size + 7.0f);
                text.setText(R.string.view6_0_text0, TextView.BufferType.SPANNABLE);
                TextView text1 = (TextView) findViewById(R.id.textView2);
                text1.setTextSize(size);
                text1.setText(R.string.view6_0_text1, TextView.BufferType.SPANNABLE);
            }
        }
        if (position == 1 && (stage == 0 ? old_page != 1 : true)) {

            Button text_button0 = (Button) findViewById(R.id.button11);
            Button text_button1 = (Button) findViewById(R.id.button10);
            Button text_button2 = (Button) findViewById(R.id.button9);
            Button text_button3 = (Button) findViewById(R.id.button12);
            TextView text_question = (TextView) findViewById(R.id.textView3);
            TextView text_answer = (TextView) findViewById(R.id.textView6);
            if (stage == 0) {
                text_button0.setTransformationMethod(null);
                text_button1.setTransformationMethod(null);
                text_button2.setTransformationMethod(null);
                text_button3.setTransformationMethod(null);
                text_button0.setBackgroundResource(R.drawable.back);
                text_button1.setBackgroundResource(R.drawable.back);
                text_button2.setBackgroundResource(R.drawable.back);
                text_button3.setBackgroundResource(R.drawable.back);
                text_answer.setText("");
            }
            if ((int) (text_answer.getTextSize() / getApplicationContext().getResources().getDisplayMetrics().density) != size - 4.0f) {
                text_answer.setTextSize(size - 4.0f > 0 ? size - 4.0f : 1.0f);
                text_question.setTextSize(size + 2.0f > 0 ? size + 2.0f : 1.0f);
                text_answer.setText(text_answer.getText(), TextView.BufferType.SPANNABLE);
                text_question.setText(R.string.view6_1_text0, TextView.BufferType.SPANNABLE);
                float size_button = size - 1.0f > 0 ? size - 1.0f : 1.0f;
                text_button0.setTextSize(size_button);
                text_button0.setText(R.string.view6_1_text1, Button.BufferType.SPANNABLE);
                text_button1.setTextSize(size_button);
                text_button1.setText(R.string.view6_1_text2, Button.BufferType.SPANNABLE);
                text_button2.setTextSize(size_button);
                text_button2.setText(R.string.view6_1_text3, Button.BufferType.SPANNABLE);
                text_button3.setTextSize(size_button);
                text_button3.setText(R.string.view6_1_text4, Button.BufferType.SPANNABLE);
            }
        }
        if (position == 2) {

            TextView text = (TextView) findViewById(R.id.textView4);
            if ((int) (text.getTextSize() / getApplicationContext().getResources().getDisplayMetrics().density) != size + 7.0f) {
                text.setTextSize(size + 7.0f);
                text.setText(R.string.view6_2_text0, TextView.BufferType.SPANNABLE);
                TextView text1 = (TextView) findViewById(R.id.textView5);
                text1.setTextSize(size);
                text1.setText(R.string.view6_2_text1, TextView.BufferType.SPANNABLE);
            }
        }
        if (position == 3 && (stage == 0 ? old_page != 3 : true)) {
            Button text_button0 = (Button) findViewById(R.id.button16);
            Button text_button1 = (Button) findViewById(R.id.button15);
            Button text_button2 = (Button) findViewById(R.id.button14);
            Button text_button3 = (Button) findViewById(R.id.button13);
            Button text_button_answer = (Button) findViewById(R.id.button17);
            TextView text_question = (TextView) findViewById(R.id.textView17);
            TextView text_answer = (TextView) findViewById(R.id.textView8);
            if (stage == 0) {
                text_button0.setTransformationMethod(null);
                text_button1.setTransformationMethod(null);
                text_button2.setTransformationMethod(null);
                text_button3.setTransformationMethod(null);
                text_button_answer.setTransformationMethod(null);
                text_button0.setBackgroundResource(R.drawable.back);
                text_button1.setBackgroundResource(R.drawable.back);
                text_button2.setBackgroundResource(R.drawable.back);
                text_button3.setBackgroundResource(R.drawable.back);
                text_button_answer.setBackgroundResource(R.drawable.back);
                text_answer.setText("");
            }
            if ((int) (text_answer.getTextSize() / getApplicationContext().getResources().getDisplayMetrics().density) != size - 4.0f) {
                text_answer.setTextSize(size - 4.0f > 0 ? size - 4.0f : 1.0f);
                text_question.setTextSize(size + 2.0f > 0 ? size + 2.0f : 1.0f);
                text_answer.setText(text_answer.getText(), TextView.BufferType.SPANNABLE);
                text_question.setText(R.string.view6_3_text0, TextView.BufferType.SPANNABLE);
                float size_button = size - 1.0f > 0 ? size - 1.0f : 1.0f;
                text_button0.setTextSize(size_button);
                text_button0.setText(R.string.view6_3_text1, Button.BufferType.SPANNABLE);
                text_button1.setTextSize(size_button);
                text_button1.setText(R.string.view6_3_text2, Button.BufferType.SPANNABLE);
                text_button2.setTextSize(size_button);
                text_button2.setText(R.string.view6_3_text3, Button.BufferType.SPANNABLE);
                text_button3.setTextSize(size_button);
                text_button3.setText(R.string.view6_3_text4, Button.BufferType.SPANNABLE);
                text_button_answer.setTextSize(size_button);
                text_button_answer.setText(text_button_answer.getText(), Button.BufferType.SPANNABLE);

            }
        }
    }

    public void onClick1(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        if (check_music_wrong) {
            full_wrong.release();
            check_music_wrong = false;
        }
        if (check_music_correctly) {
            full_correctly.release();
            check_music_correctly = false;
        }
        TextView x = (TextView) findViewById(R.id.textView6);
        x.setText("Неправильно!");
        wrong = MediaPlayer.create(this, R.raw.wrong);
        wrong.start();
        check_wrong = true;
        TextView button = (TextView) findViewById(R.id.button11);
        button.setBackgroundResource(R.drawable.wrong);
    }

    public void onClick3(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        if (check_music_wrong) {
            full_wrong.release();
            check_music_wrong = false;
        }
        if (check_music_correctly) {
            full_correctly.release();
            check_music_correctly = false;
        }
        TextView x = (TextView) findViewById(R.id.textView6);
        x.setText("Неправильно!");
        wrong = MediaPlayer.create(this, R.raw.wrong);
        wrong.start();
        check_wrong = true;
        TextView button = (TextView) findViewById(R.id.button10);
        button.setBackgroundResource(R.drawable.wrong);
    }

    public void onClick2(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        if (check_music_wrong) {
            full_wrong.release();
            check_music_wrong = false;
        }
        if (check_music_correctly) {
            full_correctly.release();
            check_music_correctly = false;
        }
        TextView x = (TextView) findViewById(R.id.textView6);
        x.setText("Правильно!");
        correctly = MediaPlayer.create(this, R.raw.correctly);
        correctly.start();
        check_correctly = true;
        TextView button = (TextView) findViewById(R.id.button9);
        button.setBackgroundResource(R.drawable.correctly);
        check = true;
    }

    public void onClick4(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        if (check_music_wrong) {
            full_wrong.release();
            check_music_wrong = false;
        }
        if (check_music_correctly) {
            full_correctly.release();
            check_music_correctly = false;
        }
        TextView x = (TextView) findViewById(R.id.textView6);
        x.setText("Неправильно!");
        wrong = MediaPlayer.create(this, R.raw.wrong);
        check_wrong = true;
        wrong.start();
        TextView button = (TextView) findViewById(R.id.button12);
        button.setBackgroundResource(R.drawable.wrong);
    }

    public void onClick5(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        TextView x = (TextView) findViewById(R.id.textView8);
        if (check_music_wrong) {
            full_wrong.release();
            check_music_wrong = false;
        }
        if (check_music_correctly) {
            full_correctly.release();
            check_music_correctly = false;
        }
        if (!check) {
            x.setText("Вы не выполнили либо выполнили неправильно предыдущее задание");
            full_wrong = MediaPlayer.create(this, R.raw.full_wrong);
            full_wrong.start();
            check_music_wrong = true;
            TextView button = (TextView) findViewById(R.id.button16);
            button.setBackgroundResource(R.drawable.full_wrong);

        } else {
            wrong = MediaPlayer.create(this, R.raw.wrong);
            wrong.start();
            check_wrong = true;
            x.setText("Неправильно!");
            TextView button = (TextView) findViewById(R.id.button16);
            button.setBackgroundResource(R.drawable.wrong);
        }
    }

    public void onClick6(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        TextView x = (TextView) findViewById(R.id.textView8);
        if (check_music_wrong) {
            full_wrong.release();
            check_music_wrong = false;
        }
        if (check_music_correctly) {
            full_correctly.release();
            check_music_correctly = false;
        }
        if (!check) {
            x.setText("Вы не выполнили либо выполнили неправильно предыдущее задание");
            TextView button = (TextView) findViewById(R.id.button15);
            button.setBackgroundResource(R.drawable.full_wrong);
            full_wrong = MediaPlayer.create(this, R.raw.full_wrong);
            full_wrong.start();
            check_music_wrong = true;
        } else {
            x.setText("Правильно!");
            full_correctly = MediaPlayer.create(this, R.raw.vi_ka);
            full_correctly.start();
            check1 = true;
            check_music_correctly = true;
            TextView button = (TextView) findViewById(R.id.button15);
            button.setBackgroundResource(R.drawable.correctly);
        }
    }

    public void onClick7(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        TextView x = (TextView) findViewById(R.id.textView8);
        if (check_music_wrong) {
            full_wrong.release();
            check_music_wrong = false;
        }
        if (check_music_correctly) {
            full_correctly.release();
            check_music_correctly = false;
        }
        if (!check) {
            x.setText("Вы не выполнили либо выполнили неправильно предыдущее задание");
            TextView button = (TextView) findViewById(R.id.button14);
            button.setBackgroundResource(R.drawable.full_wrong);
            full_wrong = MediaPlayer.create(this, R.raw.full_wrong);
            full_wrong.start();
            check_music_wrong = true;
        } else {
            x.setText("Неправильно!");
            wrong = MediaPlayer.create(this, R.raw.wrong);
            wrong.start();
            check_wrong = true;
            TextView button = (TextView) findViewById(R.id.button14);
            button.setBackgroundResource(R.drawable.wrong);
        }
    }

    public void onClick8(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        if (check_music_wrong) {
            full_wrong.release();
            check_music_wrong = false;
        }
        if (check_music_correctly) {
            full_correctly.release();
            check_music_correctly = false;
        }
        TextView x = (TextView) findViewById(R.id.textView8);
        if (!check) {
            x.setText("Вы не выполнили либо выполнили неправильно предыдущее задание");
            TextView button = (TextView) findViewById(R.id.button13);
            button.setBackgroundResource(R.drawable.full_wrong);
            full_wrong = MediaPlayer.create(this, R.raw.full_wrong);
            full_wrong.start();
            check_music_wrong = true;
        } else {
            x.setText("Неправильно!");
            wrong = MediaPlayer.create(this, R.raw.wrong);
            wrong.start();
            check_wrong = true;
            TextView button = (TextView) findViewById(R.id.button13);
            button.setBackgroundResource(R.drawable.wrong);
        }
    }

    public void onClick9(View view) {
        if (check_correctly) {
            correctly.release();
            check_correctly = false;
        }
        if (check_wrong) {
            wrong.release();
            check_wrong = false;
        }
        TextView x = (TextView) findViewById(R.id.textView8);
        if (check1) {
            full_correctly.release();
            base.input_check(false);
            base.input_window(4);
            base.input_method(1);
            base.input_progress(2);
            base.input_check_size_back(false);
            base.input_default_settings(true);
            Intent intent = new Intent(this, method.class);
            startActivity(intent);
            finish();
        } else {
            if (check_music_wrong) {
                full_wrong.release();
                check_music_wrong = false;
            }
            full_wrong = MediaPlayer.create(this, R.raw.full_wrong);
            full_wrong.start();
            check_music_wrong = true;
            TextView button = (TextView) findViewById(R.id.button17);
            button.setBackgroundResource(R.drawable.full_wrong);
            x.setText("Вы не выполнили все задания");
        }
    }


    public void font(float number) {
        //base.input_progress_size((int) number);
        //base.input_window(5);
        //base.input_method_size(1);
        //Intent intent = new Intent(this, method.class);
        //startActivity(intent);
        //finish();
        int size = (int) number;
        if (size >= 1) {
            base.input_progress_size(size);
            base.input_method_size(1);
            base.input_check_size_back(true);
            transformText(old_page, 1);
            onCreateOptionsMenu(null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ScrollView scrollView = new ScrollView(this);
        ScrollView.LayoutParams params = new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TextView textView = new TextView(this);
        textView.setText("Введение");
        textView.setTextColor(getResources().getColor(R.color.colorwhite));
        textView.setTextSize(menu == null || check_change_size_font ? base.output_progress_size() + 2 : 20);
        check_change_size_font = false;
        scrollView.addView(textView, params);
        //menu.add(textView.getText()).setActionView(scrollView);
        getSupportActionBar().setCustomView(scrollView);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#393837")));
        if (menu != null) {
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case (R.id.item1):
                if (check_correctly) {
                    correctly.release();
                    check_correctly = false;
                }
                if (check_wrong) {
                    wrong.release();
                    check_wrong = false;
                }
                if (check_music_wrong) {
                    full_wrong.release();

                    check_music_wrong = false;
                }
                if (check_music_correctly) {
                    full_correctly.release();
                    check_music_correctly = false;
                }
                Uri address = Uri.parse("https://ru.stackoverflow.com/questions/ask");
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openlinkIntent);
                break;

            case (R.id.item2):
                //Получаем вид с файла activity_dialog.xml, который применим для диалогового окна:
                LayoutInflater li = LayoutInflater.from(this);
                View promptsView = li.inflate(R.layout.activity_dialog, null);

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
                                            Float input = Float.parseFloat(userInput.getText().toString());
                                            font(input);
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
                font(18.0f);
                break;
            case (R.id.item4):
                Uri adress = Uri.parse("https://docs.oracle.com/en/java/javase/11/");
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
        if (check_music_correctly) {
            full_correctly.release();
        }
        if (check_music_wrong) {
            full_wrong.release();
        }
        back();
    }

    private void back() {
        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.open2, R.anim.exit);
    }
}
