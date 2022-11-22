package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvMoney1,tvMoney2,tvShow;
    private Spinner sp1,sp2;
    private Button btnCE,btnB,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDot;

    private String[] countries={"Viet Nam - Dong","Europ - Euro","JaPan - Yen","Austraylia - Dollar","Mexico - Peso","United States - Dollar"};
    private String[] element={"Dong","Euro","Yen","Dollar","Peso","Dollar"};
    private Double[] moneyCost={1.0,24755.0,175.0,16169.0,1139.0,23195.0};
    private Double data1,data2;
    private String type1,type2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMoney1 =findViewById(R.id.tvMoney1);
        tvMoney2=findViewById(R.id.tvMoney2);
        sp1=findViewById(R.id.spinner1);
        sp2=findViewById(R.id.spinner2);
        btnCE=findViewById(R.id.btnCE);
        btnB=findViewById(R.id.btnBT);
        btn0=findViewById(R.id.btn00);
        btn1=findViewById(R.id.btn01);
        btn2=findViewById(R.id.btn02);
        btn3=findViewById(R.id.btn03);
        btn4=findViewById(R.id.btn04);
        btn5=findViewById(R.id.btn05);
        btn6=findViewById(R.id.btn06);
        btn7=findViewById(R.id.btn07);
        btn8=findViewById(R.id.btn08);
        btn9=findViewById(R.id.btn09);
        btnDot=findViewById(R.id.btnDot);
        data1=1.0;
        data2=1.0;
        tvShow=findViewById(R.id.tvShow);
        tvShow.setText("1 DONG = 1 DONG");
        type1="DONG";
        type2="DONG";
        ArrayAdapter adapter1=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,countries);
        sp1.setAdapter(adapter1);

        ArrayAdapter adapter2=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,countries);
        sp2.setAdapter(adapter2);

        tvMoney1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                showData();
            }
        });

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                data1=moneyCost[i];
                type1=element[i];
                String data="1"+" "+type1+" = "+String.valueOf(data1/data2)+" "+type2;
                tvShow.setText(data);
                showData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                data2=moneyCost[i];
                type2=element[i];
                String data="1"+" "+type1+" = "+String.valueOf(data1/data2)+" "+type2;
                tvShow.setText(data);
                showData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnB.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        int id=view.getId();

        if(id==R.id.btn00){
            mySetTvMoney1(0);

        }else if(id==R.id.btn01){
            mySetTvMoney1(1);
        }else if(id==R.id.btn02){
            mySetTvMoney1(2);
        }else if(id==R.id.btn03){
            mySetTvMoney1(3);
        }else if(id==R.id.btn04){
            mySetTvMoney1(4);
        }else if(id==R.id.btn05){
            mySetTvMoney1(5);
        }else if(id==R.id.btn06){
            mySetTvMoney1(6);
        }else if(id==R.id.btn07){
            mySetTvMoney1(7);
        }else if(id==R.id.btn08){
            mySetTvMoney1(8);
        }else if(id==R.id.btn09){
            mySetTvMoney1(9);
        }else if(id==R.id.btnDot){
            mySetTvMoney1(-1);
        }else if(id==R.id.btnCE){
            tvMoney1.setText("");
        }else{
            DeleteLastLetter();
        }
    }


    public String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    void DeleteLastLetter(){
        String tv1=tvMoney1.getText().toString();
        if(!tv1.isEmpty()){
            tv1=removeCharAt(tv1,tv1.length()-1);
            tvMoney1.setText(tv1);
        }

    }

    void mySetTvMoney1(int x){
        String tv1=tvMoney1.getText().toString();
        if(tv1.length()<17) {
            if (x == 0 && tv1.isEmpty()) {
                return;
            } else if (x == -1) {
                if (tv1.isEmpty()) {
                    tv1 = "0.";
                } else if (tv1.indexOf('.') == -1) {
                    tv1 = tv1 + ".";
                }
            } else {
                tv1 = tv1 + String.valueOf(x);

            }
            tvMoney1.setText(tv1);
        }
    }

    void showData(){
        String tv=tvMoney1.getText().toString();
        if(!tv.isEmpty()) {
            Double req = Double.valueOf(tv);
            req = Double.valueOf(Math.round((req / data2) * data1*Math.pow(10,2)))/Math.pow(10,2);
            String tvn=String.valueOf(req);
            if(tvn.length()>12) tvMoney2.setTextSize(20);
            else tvMoney2.setTextSize(40);
            tvMoney2.setText(req + "");
        }else{
            tvMoney2.setText("");
        }
    }

}