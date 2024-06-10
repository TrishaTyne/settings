package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UpdatePinActivity extends AppCompatActivity {

    private EditText enterPin, retypePin;
    private LinearLayout enterPinLayout, retypePinLayout;
    private Button confirmButton;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pin);

        enterPin = findViewById(R.id.enter_pin);
        retypePin = findViewById(R.id.retype_pin);
        enterPinLayout = findViewById(R.id.enter_pin_layout);
        retypePinLayout = findViewById(R.id.retype_pin_layout);
        confirmButton = findViewById(R.id.confirm_button);
        backButton = findViewById(R.id.back_button);

        // Handle back button click
        backButton.setOnClickListener(v -> onBackPressed());

        // Add text watchers to EditTexts
        addTextWatcher(enterPin, enterPinLayout);
        addTextWatcher(retypePin, retypePinLayout);

        // Handle confirm button click
        confirmButton.setOnClickListener(v -> {
            String pin = enterPin.getText().toString();
            String retypePinStr = retypePin.getText().toString();

            if (pin.equals(retypePinStr)) {
                Toast.makeText(UpdatePinActivity.this, "PIN updated successfully", Toast.LENGTH_SHORT).show();
                // Handle PIN update logic here
            } else {
                Toast.makeText(UpdatePinActivity.this, "PINs do not match", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addTextWatcher(EditText editText, LinearLayout pinLayout) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updatePinDots(pinLayout, s.length());
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void updatePinDots(LinearLayout layout, int length) {
        for (int i = 0; i < 4; i++) {
            View dot = layout.getChildAt(i);
            if (i < length) {
                dot.setBackgroundResource(R.drawable.pin_dot);
            } else {
                dot.setBackgroundResource(R.drawable.pin_dot_empty);
            }
        }
    }
}

