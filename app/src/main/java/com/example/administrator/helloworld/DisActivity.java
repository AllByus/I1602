package com.example.administrator.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.frg.BaseFragment;
import com.example.frg.DiscovryFragment;
import com.example.frg.PageFiveFragment;


public class DisActivity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener{
    private FragmentManager supportFragmentManager;
    private DiscovryFragment discovryFragment;
    private Fragment oldFragment;
    private ListView lview;
    private PageFiveFragment pagefivefragment;
    private int mposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis);
        discovryFragment = DiscovryFragment.newInstance("","");
        pagefivefragment = PageFiveFragment.newInstance("","");
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        controlFragment(discovryFragment);
        fragmentTransaction.commit();



    }



    private void controlFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        if (oldFragment != null) {
            fragmentTransaction.hide(oldFragment);
        }
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.replace(R.id.fl_dis,fragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        oldFragment = fragment;
    }


    @Override
    public void onFragmentInteraction(String string ,int num) {
        mposition = num;
        Bundle args=new Bundle();
        args.putInt("position",mposition);
        pagefivefragment.setArguments(args);
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        controlFragment(pagefivefragment);
        fragmentTransaction.commit();
    }
}
