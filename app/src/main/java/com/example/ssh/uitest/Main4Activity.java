package com.example.ssh.uitest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4Activity extends AppCompatActivity {




    private String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat"};
    private int[] imageId = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置该Activity的显示界面为R.layout.activity_main
        setContentView(R.layout.activity_main4);
        //创建一个集合，用来保存列表项，如兔爷的图片，和兔爷名字
        List<HashMap<String, Object>> listItems = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            //创建map集合，用来保存具体的列表
            HashMap<String, Object> listItem = new HashMap<String, Object>();

            listItem.put("header", imageId[i]);
            listItem.put("personName", names[i]);
            //将列表添加到列表项中
            listItems.add(listItem);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, listItems,
                R.layout.activity_main4,
                new String[] { "header", "personName" }, new int[] {R.id.header, R.id.names });
        ListView list = (ListView) findViewById(R.id.list5);
        list.setAdapter(adapter);
    }





}
