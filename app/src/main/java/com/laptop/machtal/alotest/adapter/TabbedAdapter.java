package com.laptop.machtal.alotest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.laptop.machtal.alotest.fragment.FragmentTab1;
import com.laptop.machtal.alotest.fragment.FragmentTab2;


public class TabbedAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public TabbedAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                FragmentTab1 tab1 = new FragmentTab1();
                return tab1;
            case 1:
                FragmentTab2 tab2 = new FragmentTab2();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
