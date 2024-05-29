package com.example.pocketpal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class homepage extends AppCompatActivity {
    Button transaction;
    ImageButton btnsavings;
    String username;
    TextView textViewUsername;
    Button Tally;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        textViewUsername = findViewById(R.id.textusername);
        textViewUsername.setText("Username: " + username);

        transaction= findViewById(R.id.btntrans);
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,display.class);
//                intent.putExtra("username", textViewUsername.getText().toString());
                startActivity(intent);
            }
        });

        btnsavings= findViewById(R.id.btnsavings);
        btnsavings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,Savings.class);
                startActivity(intent);
            }
        });
        Tally = findViewById(R.id.tallyBtn);
        Tally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,Tally.class);
                startActivity(intent);
            }
        });
    }
}