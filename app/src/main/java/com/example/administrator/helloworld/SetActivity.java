package com.example.administrator.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class SetActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        linearLayout = (LinearLayout) findViewById(R.id.ll_ac_set);
        linearLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
