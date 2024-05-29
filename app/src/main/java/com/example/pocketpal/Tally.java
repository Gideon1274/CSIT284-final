package com.example.pocketpal;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tally extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tally);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText searchEditText = findViewById(R.id.searchText);
        ImageButton menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(Tally.this, menuButton);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();
                        if (itemId == R.id.Oldest) {
                            Toast.makeText(Tally.this, "Oldest to latest selected", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.Latest) {
                            Toast.makeText(Tally.this, "Latest to oldest selected", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.AtoZ) {
                            Toast.makeText(Tally.this, "A to Z selected", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.ZtoA) {
                            Toast.makeText(Tally.this, "Z to A selected", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.Highest) {
                            Toast.makeText(Tally.this, "Highest to lowest selected", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (itemId == R.id.Lowest) {
                            Toast.makeText(Tally.this, "Lowest to highest selected", Toast.LENGTH_SHORT).show();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                // Show the popup menu
                popupMenu.show();
            }
        });
    }
}
