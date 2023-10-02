package com.example.adivinarnumero;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adivinarnumero.MyAlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    String intentos = "";
    int numIntentos = 0;
    int randomNumber = (int) (Math.random() * 100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView cartel1 = findViewById(R.id.textView);
        cartel1.setText("Nº intentos: ");

        TextView cartelNumIntentos = findViewById(R.id.textView2);
        cartelNumIntentos.setText(String.valueOf(numIntentos));

        TextView guardarIntentos = findViewById(R.id.textView3);
        guardarIntentos.setText("");

        EditText cajaNum = findViewById(R.id.editTextNumber2);

        final Button button1 = findViewById(R.id.button);

        button1.setText("Adivinar");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numInput = Integer.parseInt(cajaNum.getText().toString());
                if ( numInput > randomNumber) {
                    Toast.makeText(MainActivity.this, "El número que buscas es menor!", Toast.LENGTH_SHORT).show();
                    intentos = intentos + "<" + cajaNum.getText() + "\n";
                    guardarIntentos.setText(intentos);
                    numIntentos++;
                    cartelNumIntentos.setText(String.valueOf(numIntentos));
                } else if (numInput < randomNumber) {
                    Toast.makeText(MainActivity.this, "El número que buscas es mayor!", Toast.LENGTH_SHORT).show();
                    intentos = intentos + ">" + cajaNum.getText() + "\n";
                    guardarIntentos.setText(intentos);
                    numIntentos++;
                    cartelNumIntentos.setText(String.valueOf(numIntentos));
                } else {
                    MyAlertDialog.showAlertDialog(MainActivity.this, "AdivinarNumero", "¡Has ganado!");
                    intentos = "";
                    guardarIntentos.setText(intentos);
                    numIntentos = 0;
                    cartelNumIntentos.setText(String.valueOf(numIntentos));
                    randomNumber = (int) (Math.random() * 100);
                                    }
            }
        });
    }
}
