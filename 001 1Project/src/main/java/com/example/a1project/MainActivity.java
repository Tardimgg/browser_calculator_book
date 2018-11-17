package com.example.a1project;

import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.math.BigInteger;
import java.math.BigDecimal;

public class MainActivity extends Activity {
    private static ArrayList<Integer> base = new ArrayList<>();
    private static ArrayList<Integer> base1 = new ArrayList<>();
    private static byte r = 0;
    private static boolean t = false;
    private static boolean check = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(7));
    }

    public void onClick1(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(4));
    }

    public void onClick2(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(8));
    }

    public void onClick3(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(9));
    }

    public void onClick4(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve1(1));
    }

    public void onClick5(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve1(2));
    }

    public void onClick6(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve1(3));
    }

    public void onClick7(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve1(4));
    }

    public void onClick8(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(5));
    }

    public void onClick9(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(6));
    }

    public void onClick10(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(1));
    }

    public void onClick11(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(2));
    }

    public void onClick12(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(3));
    }

    public void onClick13(View view) {
        TextView y = (TextView) findViewById(R.id.textView);
        if (!t) {
            y.setText("Error");
        } else {
            String answer = resheba();
            if (check) {
                y.setText("Error");
            } else {
                y.setText(answer);
            }
        }
    }

    public void onClick14(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(0));
    }

    public void onClick15(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText(solve(-1));
    }

    public void onClick16(View view) {
        TextView x = (TextView) findViewById(R.id.textView);
        x.setText("");
        base.clear();
        base1.clear();
        r = 0;
        check = false;
        t = false;
    }

    private static String resheba() {
        String otvet = " ";
        try {
            String h = "";
            String h1 = "";
            for (int i = 0; i < Math.max(base.size(), base1.size()); i++) {
                if (base.get(0) != -100 && base.get(0) != -99) {
                    if (i < base.size()) {
                        if (base.get(i) == -1) {
                            h += ".";
                        } else if (base.get(i) == -2) {
                            h += "-";
                        } else {
                            h += Integer.toString(base.get(i));
                        }
                    }
                } else {
                    h = base.get(0) == -100 ? "Infinity" : "-Infinity";
                }
                if (base1.get(0) != -100 && base1.get(0) != -99) {
                    if (i < base1.size()) {
                        if (base1.get(i) == -1) {
                            h1 += ".";
                        } else if (base1.get(i) == -2) {
                            h1 += "-";
                        } else {
                            h1 += Integer.toString(base1.get(i));
                        }
                    }
                } else {
                    h1 = base1.get(0) == -100 ? "Infinity" : "-Infinity";
                }
            }
            if (!h.equals("Infinity") && !h1.equals("Infinity") && !h.equals("-Infinity") && !h1.equals("-Infinity")) {
                BigDecimal q = new BigDecimal(h);
                BigDecimal answer = new BigDecimal("1");
                BigDecimal w = new BigDecimal(h1);
                BigDecimal qwef = new BigDecimal("0");
                if (r == 1) {
                    if (w.equals(qwef) && !q.equals(qwef)) {
                        if (Float.parseFloat(h) > 0) {
                            answer = new BigDecimal("-100");
                        } else if (Float.parseFloat(h) < 0) {
                            answer = new BigDecimal("-99");
                        } else {
                            answer = qwef;
                        }
                    } else {
                        answer = q.divide(w, 30, BigDecimal.ROUND_HALF_UP);
                    }
                } else if (r == 2) {
                    answer = q.multiply(w);
                } else if (r == 3) {
                    answer = q.subtract(w);
                } else if (r == 4) {
                    answer = q.add(w);
                } else {
                    check = true;
                }
                BigDecimal ni = new BigDecimal("-100");
                BigDecimal nm = new BigDecimal("-99");
                if (answer.equals(ni)) {
                    otvet = "Infinity";
                } else if (answer.equals(nm)) {
                    otvet = "-Infinity";
                } else {
                    BigDecimal qwe = answer;
                    if (!check) {
                        otvet = qwe.toString();
                    }
                }
                String[] vbn = otvet.split("");
                boolean oop = false;
                boolean rty = false;
                int kol1 = 0;
                String sd = "";
                for (String i : vbn) {
                    if (i.equals(".")) {
                        oop = true;
                        rty = true;

                    } else if (oop) {
                        if (i.equals("0")) {
                            kol1++;
                        } else {
                            sd += rty ? "." : "";
                            rty = false;
                            sd += i;
                            for (int l = 0; l < kol1; l++) {
                                sd += "0";
                            }
                        }
                    } else {
                        sd += i;
                    }
                }
                otvet = sd;
            } else {
                if (r == 1) {
                    otvet = (h.equals("Infinity") ? 2 : -2) / (Integer.parseInt(h1) > 0 ? 1 : -1) > 0 ? "Infinity" : "-Infinity";
                } else if (r == 2) {
                    otvet = (h.equals("Infinity") ? 2 : -2) * (Integer.parseInt(h1) > 0 ? 1 : -1) > 0 ? "Infinity" : "-Infinity";
                } else if (r == 3) {
                    otvet = (h.equals("Infinity") ? "Infinity" : "-Infinity");
                } else if (r == 4) {
                    otvet = (h.equals("Infinity") ? "Infinity" : "-Infinity");
                }
            }
            if (!otvet.equals("Infinity") && !otvet.equals("-Infinity")) {
                base1.clear();
                base.clear();
                String[] asd = otvet.split("");
                for (String i : asd) {
                    if (i.equals(".")) {
                        base.add(-1);
                    } else if (i.equals("-")) {
                        base.add(-2);
                    } else if (!i.equals("")) {
                        base.add(Integer.parseInt(i));
                    }
                }
                t = false;
            } else {
                if (otvet.equals("Infinity")) {
                    base.add(-100);
                } else {
                    base.add(-99);
                }
            }
        } catch (Exception e) {
            check = true;
        }
        return otvet;
    }

    private static String solve(int kol) {
        String answer = "";
        if (!t) {
            base.add(kol);
            String h = "";
            for (int i = 0; i < base.size(); i++) {
                if (i < base.size()) {
                    String qww = Integer.toString(base.get(i));
                    if (qww.equals("-1")) {
                        h += ".";
                    } else if (qww.equals("-2")) {
                        h += "-";
                    } else {
                        h += Integer.toString(base.get(i));
                    }
                }
            }
            answer = (h);
        } else {
            base1.add(kol);
            String h = "";
            String h1 = "";
            boolean km = true;
            boolean km1 = true;
            for (int i = 0; i < Math.max(base.size(), base1.size()); i++) {
                if (i < base.size() && km) {
                    String qww = Integer.toString(base.get(i));
                    if (qww.equals("-1")) {
                        h += ".";
                    } else if (qww.equals("-2")) {
                        h += "-";
                    } else if (!qww.equals("-100") && !qww.equals("-99")) {
                        h += Integer.toString(base.get(i));
                    } else {
                        h = qww.equals("-100") ? "Infinity" : "-Infinity";
                        km = false;
                    }
                }
                if (i < base1.size() && km1) {
                    String qww = Integer.toString(base1.get(i));
                    if (qww.equals("-1")) {
                        h1 += ".";
                    } else if (qww.equals("-2")) {
                        h1 += "-";
                    } else if (!qww.equals("-100") && !qww.equals("-99")) {
                        h1 += Integer.toString(base1.get(i));
                    } else {
                        h = qww.equals("-100") ? "Infinity" : "-Infinity";
                        km1 = false;
                    }
                }
            }
            if (r == 1) {
                answer = (h + "/" + h1);
            } else if (r == 2) {
                answer = (h + "*" + h1);
            } else if (r == 3) {
                answer = (h + "-" + h1);
            } else if (r == 4) {
                answer = (h + "+" + h1);
            }
        }
        return answer;
    }

    private static String solve1(int kol) {
        String answer;
        String jhk = "";
        if (kol == 1) {
            jhk = "/";
        } else if (kol == 2) {
            jhk = "*";
        } else if (kol == 3) {
            jhk = "-";
        } else if (kol == 4) {
            jhk = "+";
        }
        if (!t || base1.size() == 0) {
            r = (byte) kol;
            t = base.size() > 0;
            String h = "";
            for (int i = 0; i < base.size(); i++) {
                if (i < base.size()) {
                    String qww = Integer.toString(base.get(i));
                    if (qww.equals("-1")) {
                        h += ".";
                    } else if (qww.equals("-2")) {
                        h += "-";
                    } else if (!qww.equals("-100") && !qww.equals("-99")) {
                        h += Integer.toString(base.get(i));
                    } else {
                        h = qww.equals("-100") ? "Infinity" : "-Infinity";
                        break;
                    }
                }
            }
            if (base.size() == 0 && kol == 3) {
                base.add(-2);
            }
            answer = (h + jhk);
        } else {
            String e = resheba();
            t = true;
            if (check) {
                answer = ("Error");
            } else {
                answer = (e + jhk);
            }
            r = (byte) kol;
        }
        return answer;
    }
}


