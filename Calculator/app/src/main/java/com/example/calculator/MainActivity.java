package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bd,bm,br,be,bas,c,ce,rv;
    TextView tm,ts1,ts2;
    String preTT;
    int Ans;
    boolean isValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bas=findViewById(R.id.bs);
        c=findViewById(R.id.c);
        ce=findViewById(R.id.ce);
        rv=findViewById(R.id.rv);
        b0=(Button)findViewById(R.id.btn0);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b5=findViewById(R.id.btn5);
        b6=findViewById(R.id.btn6);
        b7=findViewById(R.id.btn7);
        b8=findViewById(R.id.btn8);
        b9=findViewById(R.id.btn9);
        ba=findViewById(R.id.btnAdd);
        bs=findViewById(R.id.btnSub);
        bd=findViewById(R.id.btnDivide);
        bm=findViewById(R.id.btnMul);
        be=findViewById(R.id.btnEqual);
        br=findViewById(R.id.rv);
        tm=findViewById(R.id.textsub2);
        ts1=findViewById(R.id.subDis1);
        ts2=findViewById(R.id.subDis2);
        tm.setText("0");
        ts1.setText("");
        ts2.setText("");
        isValue=false;
        preTT="";

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonAction("9");
            }
        });

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calButtonAction("add");
            }
        });

    bs.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calButtonAction("sub");
        }
    });

    bm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calButtonAction("mul");
        }
    });

    bd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calButtonAction("div");
        }
    });

    be.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calButtonAction("");
        }
    });

    bas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!isValue){
                String str=tm.getText().toString();
                if(!str.equals("0")&&!str.equals("0")){
                    str=str.substring(0,str.length()-1);
                    tm.setText(str);
                }
            }
        }
    });

    c.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tm.setText("0");
            ts1.setText("");
            ts2.setText("");
            isValue=false;
            Ans=0;
            preTT="";
        }
    });

    ce.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tm.setText("0");
            ts1.setText("");
            ts2.setText("");
            isValue=false;
            Ans=0;
            preTT="";
        }
    });

    rv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!isValue){
                String str=tm.getText().toString();
                if(!str.equals("0")&& !str.equals("")){
                    if(str.charAt(0)=='-') str=str.substring(1,str.length());
                    else str="-"+str;
                    tm.setText(str);
                }
            }
        }
    });

    }

    void numberButtonAction(String val){
        String s=tm.getText().toString();
        if(isValue) {
            tm.setText(val);
            isValue=false;
        }
        else {
            s=s+val;
            tm.setText(s);
        }
    }

    void calButtonAction(String content){
        String str=tm.getText().toString();
        int temp=Integer.parseInt(str);
        if(preTT.equals("")){
            preTT=content;
            Ans=temp;
            isValue=true;
            ts1.setText(Ans+"");
            tm.setText("");
        }else{
            if(preTT.equals("add")){
                preTT=content;
                Ans+=temp;
                tm.setText(Ans+"");
                isValue=true;
                ts1.setText(Ans+"");
                tm.setText("");
            }else if(preTT.equals("sub")){
                Ans-=temp;
                preTT=content;
                tm.setText(Ans+"");
                isValue=true;
                ts1.setText(Ans+"");
                tm.setText("");
            }else if(preTT.equals("mul")){
                Ans*=temp;
                preTT=content;
                tm.setText(Ans+"");
                isValue=true;
                ts1.setText(Ans+"");
                tm.setText("");
            }else if(preTT.equals("div")){
                Ans/=temp;
                preTT=content;
                tm.setText(Ans+"");
                isValue=true;
                ts1.setText(Ans+"");
                tm.setText("");
            }
        }
        if(content.equals("add")) ts2.setText("+");
        else if(content.equals("sub")) ts2.setText("-");
        else if(content.equals("mul")) ts2.setText("X");
        else if(content.equals("div")) ts2.setText("/");
        else{
            tm.setText(Ans+"");
            ts1.setText("");
            ts2.setText("");
            Ans=0;
            isValue=true;
        }
    }









}