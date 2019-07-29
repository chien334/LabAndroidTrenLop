package com.example.labtrentruong;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.labtrentruong.Lab2_3.gridview.grid_fragment;
import com.example.labtrentruong.Lab2_3.listview.list_fragment;
import com.example.labtrentruong.Lab2_3.recycleview.recycle_fragment;

public class viewPager extends FragmentPagerAdapter {

    private Context mContext;

    public viewPager(Context context,FragmentManager fm) {
        super(fm);
        mContext=context;

    }


    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new list_fragment();
        } else if (i == 1){
            return new grid_fragment();
        } else if (i == 2){
            return new recycle_fragment();
        }
        return new grid_fragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_usefulinfo);
            case 1:
                return mContext.getString(R.string.category_places);
            case 2:
                return mContext.getString(R.string.category_food);
            default:
                return null;
        }
    }
}
