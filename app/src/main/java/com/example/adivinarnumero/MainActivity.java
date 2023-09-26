package com.example.adivinarnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText cajaNum = findViewById(R.id.editTextNumber2);

        final Button button1 = findViewById(R.id.button);
        button1.setText("¡Clickeame!");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,cajaNum.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}