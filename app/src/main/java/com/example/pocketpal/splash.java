package com.example.pocketpal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

//        List<Expense> expenses = ExpenseFileUtils.getExpensesFromFile(this);
//
//        StringBuilder displayText = new StringBuilder();
//        for (Expense expense : expenses) {
//            displayText.append("Amount: ").append(expense.getAmount()).append("\n");
//            displayText.append("Description: ").append(expense.getDescription()).append("\n");
//            displayText.append("Category: ").append(expense.getCategory()).append("\n\n");
//        }
//
//        TextView textView = findViewById(R.id.display);
//        textView.setText(displayText.toString());

//        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//        String amount = sharedPreferences.getString("amount", "0.00");
//        String description = sharedPreferences.getString("description", "Nothing");
//        String category = sharedPreferences.getString("category", "No category");
//
//        // Display the shared preferences data in the TextView
//        TextView sharedPrefTextView = findViewById(R.id.display);
//        sharedPrefTextView.setText("Amount: " + amount + "\nDescription: " + description + "\nCategory: " + category);

//        Button btnAdd = findViewById(R.id.btnAdd);
//        btnAdd.setOnClickListener(new android.view.View.OnClickListener(){
//            @Override
//            public void onClick(android.view.View v) {
//                Intent intent1 = new Intent(splash.this, add_expense.class);
//                startActivity(intent1);
//            }
//        });
        File file = new File(getFilesDir(), "expenses.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Load expenses from the file
        List<Expense> expenses = ExpenseFileUtils.getExpensesFromFile(this);

        // Update the UI with the loaded expenses
        updateUI(expenses);

        // Set up the button click listener
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(splash.this, add_expense.class);
                startActivity(intent1);
            }
        });
    }
    private void updateUI(List<Expense> expenses) {
        StringBuilder displayText = new StringBuilder();
        for (Expense expense : expenses) {
            displayText.append("Amount: ").append(expense.getAmount()).append("\n");
            displayText.append("Description: ").append(expense.getDescription()).append("\n");
            displayText.append("Category: ").append(expense.getCategory()).append("\n\n");
        }

        TextView textView = findViewById(R.id.display);
        textView.setText(displayText.toString());
    }
}