package com.example.form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,mssv,cmnd,sdt,contry,address,email;
    RadioButton khmt,ktmt;
    CheckBox c,java,python,agree;
    Button okbtn;
    CalendarView calendar;
    TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        mssv=findViewById(R.id.mssv);
        cmnd=findViewById(R.id.cmnd);
        sdt=findViewById(R.id.sdt);
        date=findViewById(R.id.date);
        contry=findViewById(R.id.country);
        address=findViewById(R.id.address);
        khmt=findViewById(R.id.khmt);
        ktmt=findViewById(R.id.ktmt);
        c=findViewById(R.id.C);
        java=findViewById(R.id.java);
        python=findViewById(R.id.python);
        agree=findViewById(R.id.agree);
        okbtn=findViewById(R.id.okBtn);
        email=findViewById(R.id.email);
        calendar=findViewById(R.id.calender);
        calendar.setVisibility(View.INVISIBLE);
        okbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String str;
                str=name.getText().toString();
                if(str.equals("")){
                    ToastFail();
                    name.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    return ;
                }

                str=mssv.getText().toString();
                if(str.equals("")){
                    ToastFail();
                    mssv.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    return ;
                }
                str=cmnd.getText().toString();
                if(str.equals("")){
                    ToastFail();
                    cmnd.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    return ;
                }
                str=sdt.getText().toString();
                if(str.equals("")){
                    ToastFail();
                    sdt.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    return ;
                }

                str=email.getText().toString();
                if(str.equals("")){
                    ToastFail();
                    email.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    return ;
                }

                if(agree.isChecked()){
                    ToastSuccess();
                }else{
                    agree.setBackgroundColor(getResources().getColor(R.color.teal_200));
                }
            }


        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String d=(i1+1)+"/"+i2+"/"+i;
                date.setText(d);
                calendar.setVisibility(View.INVISIBLE);
            }
        });
    }

    void ToastSuccess(){
        Toast toast= Toast.makeText(this,"Nhập dữ liệu thành công",Toast.LENGTH_LONG);
        toast.show();
        name.setText("");
        mssv.setText("");
        cmnd.setText("");
        sdt.setText("");
        email.setText("");
        email.setText("");
        date.setText("");
        contry.setText("");
        address.setText("");
        ktmt.setChecked(false);
        khmt.setChecked(false);
        c.setChecked(false);
        java.setChecked(false);
        python.setChecked(false);
        agree.setChecked(false);
    }

    void ToastFail(){

        Toast toast= Toast.makeText(this,"Bạn nhập thiếu dữ liệu",Toast.LENGTH_LONG);
        toast.show();
    }


    public void changColorAfterClick(View view) {
        view.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void callCalendar(View view) {
        calendar.setVisibility(View.VISIBLE);
    }


}