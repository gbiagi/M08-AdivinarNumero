package com.example.adivinarnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        Button buttonBack = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        String mensaje = intent.getStringExtra("Hola1");

        TextView hola = findViewById(R.id.saludo);
        hola.setText(mensaje);
    }

    public void goBack(View view){
        Intent mainScreen = new Intent(RecordsActivity.this, MainActivity.class);
        startActivity(mainScreen);
    }
}