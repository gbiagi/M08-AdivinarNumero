package com.example.adivinarnumero;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
public class MyAlertDialog {
    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // Set the dialog title and message
        builder.setTitle(title);
        builder.setMessage(message);
        // Set a positive button and its click listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Do something when the "OK" button is clicked
                dialog.dismiss();
            }
        });
        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
