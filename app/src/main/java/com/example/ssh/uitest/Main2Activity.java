package com.example.ssh.uitest;


import android.graphics.Color;
import android.support.annotation.MenuRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = (TextView)findViewById(R.id.txt);
        registerForContextMenu(txt);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.mian,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        mi.setCheckable(true);
        switch (mi.getItemId()) {
            case R.id.red_font:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.green_font:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue_font:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_12:
                txt.setTextSize(12*2);
                break;
            case R.id.font_14:
                txt.setTextSize(14*2);
                break;
            case R.id.font_16:
                txt.setTextSize(16*2);
                break;
        }
        return true;
    }




}
