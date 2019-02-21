package com.conversion.sbx.firebasepush;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class PagerViewAdapter extends FragmentPagerAdapter {
    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;

            case 1:
                UserFragment userFragment = new UserFragment();
                return  userFragment;

            case 2:
                NotificationFragment notificationFragment = new NotificationFragment();
                return  notificationFragment;

            default:
                return  null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
