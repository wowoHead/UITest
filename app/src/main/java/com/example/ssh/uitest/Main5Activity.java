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
