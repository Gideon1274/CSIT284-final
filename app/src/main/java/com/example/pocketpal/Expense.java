package com.example.pocketpal;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

public class Expense extends AppCompatActivity {
    private String description;
    private double amount;
    private String category;
    private long date;

    public Expense(double amount, String description, String category ) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // Getters and setters for all fields

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expense);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

//package com.example.pocketpal;
//
//        import java.io.Serializable;
//
//public class Expense implements Serializable {
//    private String description;
//    private double amount;
//    private String category;
//    private long date; // in milliseconds
//
//    public Expense(String description, double amount, String category, long date) {
//        this.description = description;
//        this.amount = amount;
//        this.category = category;
//        this.date = date;
//    }
//
//
//    // Getters and setters for the amount, description, and category fields
//
//    @Override
//    public String toString() {
//        return "Expense{" +
//                "amount=" + amount +
//                ", description='" + description + '\'' +
//                ", category='" + category + '\'' +
//                '}';
//    }
//}