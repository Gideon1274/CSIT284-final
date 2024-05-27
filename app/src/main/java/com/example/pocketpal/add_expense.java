package com.example.pocketpal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ContextWrapper;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.example.pocketpal.ExpenseFileUtils;

public class add_expense extends AppCompatActivity {
    TextView textViewUsername;
    String username;
    Button View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_expense);
        File file = new File(getFilesDir(), "expenses.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Expense> expenses = ExpenseFileUtils.getExpensesFromFile(this);
        ExpenseFileUtils.saveExpensesToFile(this, expenses  );
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewUsername = findViewById(R.id.textusername);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        if (username != null) {
            textViewUsername.setText(username);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

//        Button buttonSave = findViewById(R.id.buttonSave);
//        buttonSave.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                EditText editTextAmount = findViewById(R.id.editTextAmount);
//                EditText editTextDescription = findViewById(R.id.editTextDescription);
//                Spinner spinnerCategory = findViewById(R.id.spinnerCategory);
//
//                String amountString = editTextAmount.getText().toString();
//                if (amountString.isEmpty()) {
//                    Toast.makeText(add_expense.this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                double amount = Double.parseDouble(amountString);
//                String description = editTextDescription.getText().toString();
//                String category = spinnerCategory.getSelectedItem().toString();
//
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("amount", String.valueOf(amount));
//                editor.putString("description", description);
//                editor.putString("category", category);
//                editor.apply();
//
//                Toast.makeText(add_expense.this, "Expense saved", Toast.LENGTH_SHORT).show();
//
//                // Clear the input fields after saving
//                editTextAmount.setText("");
//                editTextDescription.setText("");
//                spinnerCategory.setSelection(0);
//            }
//        });
        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText editTextAmount = findViewById(R.id.editTextAmount);
                EditText editTextDescription = findViewById(R.id.editTextDescription);
                Spinner spinnerCategory = findViewById(R.id.spinnerCategory);

                String amountString = editTextAmount.getText().toString();
                if (amountString.isEmpty()) {
                    Toast.makeText(add_expense.this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
                    return;
                }
                double amount = Double.parseDouble(amountString);
                String description = editTextDescription.getText().toString();
                String category = spinnerCategory.getSelectedItem().toString();

                Expense expense = new Expense(amount, description, category);


                Toast.makeText(add_expense.this, "Expense saved", Toast.LENGTH_SHORT).show();

                editTextAmount.setText("");
                editTextDescription.setText("");
                spinnerCategory.setSelection(0);
            }
        });
        Button View = findViewById(R.id.btnView);
        View.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(add_expense.this, splash.class);
                startActivity(intent1);
            }
        });



    }



}
