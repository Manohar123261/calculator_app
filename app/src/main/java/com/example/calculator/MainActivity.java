package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView restv,soltv;
    MaterialButton btnc,btnlb,btnrb,divide,btn7,btn8,btn9,mult,btn4,btn5,btn6,plus,btn1,btn2,btn3,minus,
            btnac,btn0,dot,equal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restv=findViewById(R.id.result_tv);
        soltv=findViewById(R.id.sol_tv);
        assign(btnc,R.id.c);
        assign(btnlb,R.id.left_b);
        assign(btnrb,R.id.rigt_b);
        assign(divide,R.id.divide);
        assign(btn7,R.id.btn7);
        assign(btn8,R.id.btn8);
        assign(btn9,R.id.btn9);
        assign(btn4,R.id.btn4);
        assign(btn5,R.id.btn5);
        assign(btn6,R.id.btn6);
        assign(btn1,R.id.btn1);
        assign(btn2,R.id.btn2);
        assign(btn3,R.id.btn3);
        assign(btnac,R.id.ac);
        assign(btn0,R.id.btn0);
        assign(dot,R.id.dot);
        assign(equal,R.id.equal);
        assign(plus,R.id.plus);
        assign(minus,R.id.minus);
        assign(mult,R.id.mult);
//        System.out.println("manohar");

    }
    public void assign(MaterialButton btn,int id){
        btn=findViewById(id);
    }
    public void plus(String x,String y){
        Float p=Float.parseFloat(x);
        Float q=Float.parseFloat(y);
        String z=Float.toString(p+q);
        restv.setText(z);
    }
    public void mult(String x,String y){
        float p=Float.parseFloat(x);
        float q=Float.parseFloat(y);
        String z=Float.toString(p*q);
        restv.setText(z);
    }
    public void min(String x,String y){
        float p=Float.parseFloat(x);
        float q=Float.parseFloat(y);
        String z=Float.toString(p-q);
        restv.setText(z);
    }
    public void div(String x,String y){
        float p=Float.parseFloat(x);
        float q=Float.parseFloat(y);
        String z=Float.toString(p/q);
        restv.setText(z);
    }
    public void eq(String dt){
        restv.setText(x);
        dt="";
        y="";
        x="";
        op="";
    }
    public void ac(String dt){
        soltv.setText("");
        dt="";
        y="";
        x="";
        op="";
        restv.setText("0");
    }
    public String changeop(String dt ,boolean flag){
        StringBuilder m= new StringBuilder();
        for(int i=dt.length()-3;i>0;i--){
            if(dt.charAt(i)=='+' || dt.charAt(i)=='-' || dt.charAt(i)=='*' || dt.charAt(i)=='/'){
                for(int j=i+1;j<=dt.length()-2;j++){
                    m.append(Character.toString(dt.charAt(j)));
                }
                if(flag) {
                    return Character.toString(dt.charAt(i));
                }
                else{
                    return m.toString();
                }
            }

        }
        return "*";
    }
    public String dele(String y){
        StringBuilder s= new StringBuilder();
        for(int i=0;i<y.length()-1;i++){
            s.append(y.charAt(i));
        }
        return s.toString();
    }

    public String op="",y="",x="";
    public void onclick(View view){
        MaterialButton button=(MaterialButton) view;
        String btntext=button.getText().toString();
        String dt=soltv.getText().toString();
        if(btntext.equals("x")){
            if(!(dt.charAt(dt.length()-1)=='+') || !(dt.charAt(dt.length()-1)=='-') ||
                    !(dt.charAt(dt.length()-1)=='*') ||
                    !(dt.charAt(dt.length()-1)=='/')){
            y=dele(y);
            }
            else{
                op=changeop(dt,true);
                y=changeop(dt,false);
                switch (op){
                    case "+":
                        x=Float.toString(Float.parseFloat(x)-Float.parseFloat(y));
                        break;
                    case "-":
                        x=Float.toString(Float.parseFloat(x)+Float.parseFloat(y));
                        break;
                    case "*":
                        x=Float.toString(Float.parseFloat(x)/Float.parseFloat(y));
                        break;
                    case "/":
                        x=Float.toString(Float.parseFloat(x)*Float.parseFloat(y));
                        break;
                }
            }
            StringBuilder s= new StringBuilder();
            for(int i=0;i<dt.length()-1;i++){
                s.append(dt.charAt(i));
            }
            dt= s.toString();
            soltv.setText(dt);
        }
        else {
            dt += btntext;
            soltv.setText(dt);
            if (btntext.equals("+") || btntext.equals("*") || btntext.equals("-") ||
                    btntext.equals("/") || btntext.equals("=") || btntext.equals("ac") ||
                    btntext.equals("(") || btntext.equals(")")) {
                op = btntext;
                if (!restv.getText().toString().equals("0")) {
                    x = restv.getText().toString();
                } else {
                    x = y;
                }
                y = "0";
            } else {
                y += btntext;
            }
        }
            switch (op) {
                case "+":
                    plus(x, y);
                    break;
                case "*":
                    if (!y.equals("0")) {
                        mult(x, y);
                    }
                    break;
                case "-":
                    min(x, y);
                    break;
                case "/":
                    if (!y.equals("0")) {
                        div(x, y);
                    }
                    break;
                case "=":
                    eq(dt);
                    break;
                case "ac":
                    ac(dt);
                    break;

        }
    }
}