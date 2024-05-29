package com.example.pocketpal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Savings extends AppCompatActivity {
    private EditText savingsDescription;
    private EditText savingsMoney;
    private EditText savingsDate;
    private TextView savingsResult;
    private Button savingsCalculate, btnTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);

        savingsDescription = findViewById(R.id.savingsDescription);
        savingsMoney = findViewById(R.id.savingsMoney);
        savingsDate = findViewById(R.id.savingsDate);
        savingsCalculate = findViewById(R.id.savingsCalculate);
        savingsResult = findViewById(R.id.savingsResult);

        savingsDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        savingsCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    double money = Double.parseDouble(savingsMoney.getText().toString());
                    String dateString = savingsDate.getText().toString();
                    long daysTillDate = calculateDaysTillDate(dateString);

                    if (daysTillDate > 0) {
                        double savingsPerDay = money / daysTillDate;
                        savingsResult.setText(String.format("Savings per Day: %.2f", savingsPerDay));
                    } else {
                        savingsResult.setText("Date should be in the future");

                    }
                }
            }
        });
        btnTips= findViewById(R.id.btnTips);
        btnTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Savings.this,Tips.class);
                startActivity(intent);
            }
        });

    }

    private boolean validateInput() {
        if (savingsDescription.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Description is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (savingsMoney.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Money is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (savingsDate.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Date is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

//    private void showDatePickerDialog() {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                String date = String.format("%d-%02d-%02d", year, month + 1, dayOfMonth);
//                savingsDate.setText(date);
//            }
//        }, year, month, day);
//
//        datePickerDialog.show();
//    }
private void showDatePickerDialog() {
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String date = String.format("%d-%02d-%02d", year, month + 1, dayOfMonth);
            savingsDate.setText(date);
        }
    }, year, month, day);

    datePickerDialog.show();
}

//    private long calculateDaysTillDate(String date) {
//        Calendar calendar = Calendar.getInstance();
//        String currentDate = String.format("%d-%02d-%02d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
//
//        try {
//            java.time.LocalDate localDate1 = java.time.LocalDate.parse(currentDate);
//            java.time.LocalDate localDate2 = java.time.LocalDate.parse(date);
//            return java.time.Duration.between(localDate1, localDate2).toDays();
//        } catch (Exception e) {
//            return -1;
//        }
//    }
private long calculateDaysTillDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(date, formatter);
    LocalDate currentDate = LocalDate.now();
    return ChronoUnit.DAYS.between(currentDate, localDate);
}
}