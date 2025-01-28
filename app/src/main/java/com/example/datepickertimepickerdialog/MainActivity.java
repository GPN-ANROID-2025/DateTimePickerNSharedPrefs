package com.example.datepickertimepickerdialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {



    ImageButton btnSelectDate;
    ImageButton btnSelectTime;
    TextView tvDate;
    TextView tvTime;
    int year=0;
    int month=0;
    int dayOfMonth=0;

    int hourOfDay=0;
    int minutes=0;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    MyPrefs myPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        myPrefs=new MyPrefs(MainActivity.this);
       // myPrefs.setName("Sachin");
        tvDate=findViewById(R.id.tvDate);
        btnSelectDate=findViewById(R.id.btnSelectDate);
        btnSelectTime=findViewById(R.id.btnSelectTime);
        tvTime=findViewById(R.id.tvTime);


        //myPrefs.clearAll();
        Log.d("mytag",myPrefs.getName());
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor=sharedPreferences.edit();




    /*    editor.putString("name","Sachin");
        editor.commit();*/


/*
        Log.d("mytag",sharedPreferences.getString("name","NULL"));
*/


        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        hourOfDay=calendar.get(Calendar.HOUR_OF_DAY);
        minutes=calendar.get(Calendar.MINUTE);
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {

                        Log.d("mytag",""+selectedYear);
                        Log.d("mytag",""+(selectedMonth+1));
                        Log.d("mytag",""+selectedDay);
                        tvDate.setText(""+(selectedDay)+"-"+(selectedMonth+1)+"-"+selectedYear);
                    }
                },year,month,dayOfMonth);
                datePickerDialog.show();

            }
        });

        btnSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                        Log.d("mytag","Hour => "+hour);
                        Log.d("mytag","Hour => "+minute);
                        String ampm="";
                        if(hour>12)
                        {
                            ampm="PM";
                        }else{
                            ampm="AM";
                        }

                        Log.d("mytag",ampm);

                        tvTime.setText(""+(hour)+":"+(minute)+" "+ampm);

                    }
                },hourOfDay,minutes,false);

                timePickerDialog.show();
            }
        });


    }
}