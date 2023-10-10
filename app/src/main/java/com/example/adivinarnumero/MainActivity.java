package com.example.adivinarnumero;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adivinarnumero.MyAlertDialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    String intentos = "";
    int numIntentos = 0;
    int randomNumber = (int) (Math.random() * 100);
    public static final String EXTRA_MESSAGE = "HOLA DAVID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting textviews
        TextView cartel1 = findViewById(R.id.textView);
        cartel1.setText("Nº intentos: ");
        TextView cartel2 = findViewById(R.id.textView5);
        cartel2.setText("Intentos:");
        TextView cartelNumIntentos = findViewById(R.id.textView2);
        cartelNumIntentos.setText(String.valueOf(numIntentos));
        TextView guardarIntentos = findViewById(R.id.textView3);
        guardarIntentos.setText("");

        ScrollView scroll = findViewById(R.id.scrollView2);

        Typeface customTypeface = Typeface.create("sans-serif", Typeface.BOLD);

        TextView cartelTitulo = findViewById(R.id.textView6);
        cartelTitulo.setText("Adivina el número entre 1 y 100");
        cartelTitulo.setTextSize(20);
        cartelTitulo.setTypeface(customTypeface);

        // Setting buttons
        final Button button1 = findViewById(R.id.button);
        Button buttonRank = findViewById(R.id.buttonRank);

        button1.setText("Adivinar");

        EditText cajaNum = findViewById(R.id.editTextNumber2);
        cajaNum.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE ||
                        (event != null && event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // Handle the Enter key press here
                    button1.callOnClick();
                    return true;
                }
                return false;
            }
        });
        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(MainActivity.this);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(cajaNum.getText()).equals("")){
                    // MyAlertDialog.showNameDialog(MainActivity.this);
                    MyAlertDialog.showAlertDialog(MainActivity.this, "AdivinarNumero", "Introduce un numero!");
                } else {
                    int numInput = Integer.parseInt(cajaNum.getText().toString());
                    if ( numInput > randomNumber) {
                        Toast.makeText(MainActivity.this, "El número que buscas es menor!", Toast.LENGTH_SHORT).show();
                        intentos = intentos + "<" + cajaNum.getText() + "\n";
                        cajaNum.setText("");
                        guardarIntentos.setText(intentos);
                        numIntentos++;
                        cartelNumIntentos.setText(String.valueOf(numIntentos));
                        scroll.scrollTo(0,scroll.getBottom());
                    } else if (numInput < randomNumber) {
                        Toast.makeText(MainActivity.this, "El número que buscas es mayor!", Toast.LENGTH_SHORT).show();
                        intentos = intentos + ">" + cajaNum.getText() + "\n";
                        cajaNum.setText("");
                        guardarIntentos.setText(intentos);
                        numIntentos++;
                        cartelNumIntentos.setText(String.valueOf(numIntentos));
                        scroll.scrollTo(0,scroll.getBottom());
                    } else {
                        MyAlertDialog.showAlertDialog(MainActivity.this, "AdivinarNumero", "¡Has ganado!");
                        intentos = "";
                        cajaNum.setText("");
                        guardarIntentos.setText(intentos);
                        numIntentos = 0;
                        cartelNumIntentos.setText(String.valueOf(numIntentos));
                        randomNumber = (int) (Math.random() * 100);
                    }
                }
            }
        });
    }
    public void sendMessage(Context context) {
        Intent intent = new Intent(context, RecordsActivity.class);
        intent.putExtra("Hola1","Hola2");
        startActivity(intent);
    }
}