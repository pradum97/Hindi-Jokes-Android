package com.techsofts.hindijokes.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.techsofts.hindijokes.Fragment.Category_Fragment;
import com.techsofts.hindijokes.Fragment.HomeFragment;
import com.techsofts.hindijokes.Fragment.Shayari_Fragment;

public class Main_Viewpager extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    public Main_Viewpager(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new Shayari_Fragment();

            case 2:
                return new Category_Fragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}