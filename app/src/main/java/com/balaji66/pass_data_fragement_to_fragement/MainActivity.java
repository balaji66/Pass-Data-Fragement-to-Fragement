package com.balaji66.pass_data_fragement_to_fragement;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener  {

    static FirstFragment fragOne;
    static SecondFragment fragTwo;
    MyPagerAdapter myPagerAdapter;
    ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragOne = new FirstFragment();
        fragTwo = new SecondFragment();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public void onFragmentInteraction(String name, String desc) {
        myPagerAdapter.onFragmentInteraction(name, desc );
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter implements FirstFragment.OnFragmentInteractionListener{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return fragOne;
                case 1:
                    return fragTwo;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            if (position == 0) {
                title = "Fragment-1";
            } else if (position == 1) {
                title = "Fragment-2";
            }
            return title;
            //return "Page " + position;
        }

        @Override
        public void onFragmentInteraction(String name, String desc) {
            fragTwo.onFragmentInteraction(name, desc);
        }
    }

}
