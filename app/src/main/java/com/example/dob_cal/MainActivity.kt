package com.example.dob_cal

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button_1)
        val button_2 = findViewById<Button>(R.id.button_2)
        button.setOnClickListener{
                view -> clickDatePicker(view)
            //Toast.makeText(this,"Button Pressed", Toast.LENGTH_SHORT).show()

        }

        button_2.setOnClickListener{
                view -> clickTimePicker(view)
            //Toast.makeText(this,"Button Pressed", Toast.LENGTH_SHORT).show()

        }



    }


    fun clickTimePicker(view: View) {
        Toast.makeText(this, "Button Pressed", Toast.LENGTH_SHORT).show()
    }



    fun clickDatePicker(view: View){
        //Toast.makeText(this,"Button Pressed", Toast.LENGTH_SHORT).show()

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val textboxinput = findViewById<TextView>(R.id.textboxinput)
        val timedifference = findViewById<TextView>(R.id.timedifference)
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
            view,selectedYear,selectedMonth,selectedDayOfMonth ->
            Toast.makeText(this,"The chosen year is "+selectedYear, Toast.LENGTH_SHORT).show()
            val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
            textboxinput.setText(selectedDate)
            val sdf = SimpleDateFormat("d/MM/yyyy",Locale.ENGLISH)
            val simpledateformat = sdf.parse(selectedDate)


            val selectedDateInMinutes = simpledateformat!!.time / 60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time / 60000
            val timeDifferenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            timedifference.setText(timeDifferenceInMinutes.toString())



        }
        ,year
        ,month
        ,day
        )


        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }
}