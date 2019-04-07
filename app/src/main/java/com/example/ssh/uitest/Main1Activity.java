package com.example.ssh.uitest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Main1Activity extends AppCompatActivity {

    private Button button;
    private String userName;
    private String userPassword;
    private EditText userNameEdit;
    private EditText userPasswordEdit;
    private View alertDialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        alertDialogView = getLayoutInflater().inflate(R.layout.alertdialog,null,false);

        button = findViewById(R.id.button_sign);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder loginAlertDialog = new AlertDialog.Builder(Main1Activity.this);
                loginAlertDialog.setView(alertDialogView);

                loginAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userNameEdit = alertDialogView.findViewById (R.id.name);
                        userPasswordEdit = alertDialogView.findViewById (R.id.pwd);
                        userName = userNameEdit.getText ().toString ();
                        userPassword = userPasswordEdit.getText ().toString ();
                    }
                });



                loginAlertDialog.show();

            }
        });

        Log.i("AlertDialog","OnCreate:username is " + userName + ", userpassword is " + userPassword);
    }
}
