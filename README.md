# UITest

实验三主界面

![](https://github.com/wowoHead/UITest/blob/master/%E5%AE%9E%E9%AA%8C%E4%B8%89/%E4%B8%BB%E7%95%8C%E9%9D%A2.png)

```
package com.example.ssh.uitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main1Activity.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        Button btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);
            }
        });

        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });


    }
}
```

实验三自定义对话框

![](https://github.com/wowoHead/UITest/blob/master/%E5%AE%9E%E9%AA%8C%E4%B8%89/%E8%87%AA%E5%AE%9A%E4%B9%89%E5%AF%B9%E8%AF%9D%E6%A1%86.png)

```

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
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    






    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <EditText
            android:id="@+id/name"
            android:layout_width="300dp"
            android:layout_height="40dp"
            android:hint="username"
            />
        <EditText
            android:id="@+id/pwd"
            android:layout_width="300dp"
            android:layout_height="40dp"
            android:hint="password"/>

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btn_Ok"
            android:layout_width="100dp"
            android:layout_height="50dp"
            android:text="Ok"/>

        <Button
            android:id="@+id/btn_Cancel"
            android:layout_width="100dp"
            android:layout_height="50dp"
            android:text="Cancel"/>

    </LinearLayout>

</LinearLayout>

```
