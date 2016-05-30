package com.example.administrator.helloworld;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.frg.EnterFragment;
import com.example.frg.LoginFragment;

public class LoginActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup mRgButtom;

    private FragmentManager manager;
    private FragmentTransaction mTransaction;

    private EnterFragment mEnterFragment;
    private LoginFragment mLoginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniView();
        manager = getSupportFragmentManager();
        RadioButton childAt = (RadioButton) mRgButtom.getChildAt(0);
        childAt.setChecked(true);
    }

    private void iniView() {
        mRgButtom = (RadioGroup) this.findViewById(R.id.rg_login);
        mRgButtom.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        mTransaction = manager.beginTransaction();
        switch (checkedId) {
            case R.id.rb_enter:
                if (mEnterFragment == null) {
                    mEnterFragment = EnterFragment.newInstance("","");
                    mTransaction.add(R.id.ll_login, mEnterFragment, "enter");
                    if (mLoginFragment != null) {
                        mTransaction.hide(mLoginFragment);
                    }
                } else {
                    mTransaction.show(mEnterFragment);
                    if (mLoginFragment != null) {
                        mTransaction.hide(mLoginFragment);
                    }
                }
                break;
            case R.id.rb_login:
                if (mLoginFragment == null) {
                    mLoginFragment = LoginFragment.newInstance("","");
                    mTransaction.add(R.id.ll_login, mLoginFragment, "login");
                    if (mEnterFragment != null) {
                        mTransaction.hide(mEnterFragment);
                    }
                } else {
                    mTransaction.show(mLoginFragment);
                    if (mEnterFragment != null) {
                        mTransaction.hide(mEnterFragment);
                    }
                }
                break;
        }
        mTransaction.commit();

    }
    public void click(View view){
        finish();
    }
}
