package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DeletePinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_pin);

        // Handle back button click
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button noButton = findViewById(R.id.no_button);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button yesButton = findViewById(R.id.yes_button);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement your PIN deletion logic here
                Toast.makeText(DeletePinActivity.this, "PIN Deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DeletePinActivity.this, ConfirmationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}