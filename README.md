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

实验三上下文菜单

![](https://github.com/wowoHead/UITest/blob/master/%E5%AE%9E%E9%AA%8C%E4%B8%89/%E4%B8%8A%E4%B8%8B%E6%96%87%E8%8F%9C%E5%8D%95.png)

```

package com.example.ssh.uitest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    ListView listView;
    List<String> datas = new ArrayList<String>();
    ListViewAdapter adapter;
    ModeCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        listView = (ListView)findViewById(R.id.list);
        initData();
        adapter = new ListViewAdapter();
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        callback = new ModeCallback();
        listView.setMultiChoiceModeListener(callback);
    }

    class ModeCallback implements AbsListView.MultiChoiceModeListener {

        View actionBarView;
        TextView selectedNum;

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            return true;
        }

        //退出多选模式时调用
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // TODO Auto-generated method stub
            listView.clearChoices();
        }

        //进入多选模式调用，初始化ActionBar的菜单和布局
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            getMenuInflater().inflate(R.menu.multiple_mode_menu, menu);
            if(actionBarView == null) {
                actionBarView = LayoutInflater.from(Main5Activity.this).inflate(R.layout.actionbar_view, null);
                selectedNum = (TextView)actionBarView.findViewById(R.id.selected_num);
            }
            mode.setCustomView(actionBarView);
            return true;
        }

        //ActionBar上的菜单项被点击时调用
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // TODO Auto-generated method stub
            switch(item.getItemId()) {
                case R.id.select_all:
                    for(int i = 0; i < adapter.getCount(); i++) {
                        listView.setItemChecked(i, true);
                    }
                    updateSelectedCount();
                    adapter.notifyDataSetChanged();
                    break;
                case R.id.unselect_all:
                    listView.clearChoices();
                    updateSelectedCount();
                    adapter.notifyDataSetChanged();
                    break;
            }
            return true;
        }

        //列表项的选中状态被改变时调用
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position,
                                              long id, boolean checked) {
            // TODO Auto-generated method stub
            updateSelectedCount();
            mode.invalidate();
            adapter.notifyDataSetChanged();
        }

        public void updateSelectedCount() {
            int selectedCount = listView.getCheckedItemCount();
            selectedNum.setText(selectedCount + "");
        }
    }

    class ListViewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolder viewHolder;
            if(convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(Main5Activity.this, R.layout.item, null);
                viewHolder.text = (TextView)convertView.findViewById(R.id.text);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder.text.setText(datas.get(position));
            if(listView.isItemChecked(position)) {
                convertView.setBackgroundColor(Color.RED);
            } else {
                convertView.setBackgroundColor(Color.TRANSPARENT);
            }
            return convertView;
        }

        class ViewHolder {
            TextView text;
        }
    }

    public void initData() {
        for(int i = 1; i <= 15; i++) {
            datas.add(i + "");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mian3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.enter_mode) {
            listView.setItemChecked(0, true);
            listView.clearChoices();
            callback.updateSelectedCount();
        }
        return super.onOptionsItemSelected(item);
    }
}

```

实验三XML定义菜单

![](https://github.com/wowoHead/UITest/blob/master/%E5%AE%9E%E9%AA%8C%E4%B8%89/XML%E5%AE%9A%E4%B9%89%E8%8F%9C%E5%8D%95.png)

```

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

```

实验三SimpleAdapter

![](https://github.com/wowoHead/UITest/blob/master/%E5%AE%9E%E9%AA%8C%E4%B8%89/SimpleAdapter.png)

```
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

```
