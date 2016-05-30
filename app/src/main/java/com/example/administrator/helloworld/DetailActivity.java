package com.example.administrator.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.frg.ShowGripFragment;
import com.example.frg.ShowListFragment;

public class DetailActivity extends AppCompatActivity implements ShowGripFragment.OnFragmentInteractionListener,ShowListFragment.OnFragmentInteractionListener{


    private FragmentManager supportFragmentManager;
    private ShowGripFragment showGripFragment;
    private Fragment oldFragment;
    private ShowListFragment listFragment;
    private boolean tag = false;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        int left = intent.getIntExtra("left", 1);
        int right = intent.getIntExtra("right", 6);
        imageView = (ImageView) findViewById(R.id.iv_search_detial);
        showGripFragment=ShowGripFragment.newInstance(left,right);
        listFragment = ShowListFragment.newInstance(left,right);

        supportFragmentManager = getSupportFragmentManager();
        controlFragment(showGripFragment);


    }
    public  void click(View view){
        if(tag==false){
            imageView.setImageResource(R.drawable.menu);
            controlFragment(listFragment);
            tag = true;
        }else if(tag == true){
            imageView.setImageResource(R.drawable.category);
            controlFragment(showGripFragment);
            tag = false;
        }

    }
    private void controlFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        if (oldFragment != null) {
            fragmentTransaction.hide(oldFragment);
        }
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.replace(R.id.fl_detail,fragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        oldFragment = fragment;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
