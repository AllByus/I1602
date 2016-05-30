package com.example.administrator.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adapter.UserAdapter;
import com.example.bean.User;
import com.example.db.DBHelper;
import com.example.db.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{
   private DBHelper helper;
    private EditText etName;
    private ListView lvUsers;
private ImageView imageView;
    //声明User表的操作对象
    private UserDAO dao;


    //适配器
    private UserAdapter adapter;

    private List<User> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        helper=new DBHelper(this);
        etName= (EditText) this.findViewById(R.id.et_search);
        lvUsers= (ListView) this.findViewById(R.id.lv_search);
        imageView = (ImageView) findViewById(R.id.iv_ser);
        imageView.setOnClickListener(this);
        dao = new UserDAO(helper);
        data=new ArrayList<>();
        adapter=new UserAdapter(this,data);
        lvUsers.setAdapter(adapter);


    }
    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        User user = new User(0, name);
        dao.add(user);
        List<User> users = dao.queryAll();
        data.clear();
        data.addAll(users);
       adapter.notifyDataSetChanged();
        Intent intent = new Intent(this,ShowSearchActivity.class);
        intent.putExtra("message",name);
        startActivity(intent);
    }
}
