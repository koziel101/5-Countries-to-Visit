package com.example.hiago.fivecountriestovisit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabAlemanha tab1 = new TabAlemanha();
                return tab1;
            case 1:
                TabCanada tab2 = new TabCanada();
                return tab2;
            case 2:
                TabEgito tab3 = new TabEgito();
                return tab3;
            case 3:
                TabFranca tab4 = new TabFranca();
                return tab4;
            case 4:
                TabNovaZelandia tab5 = new TabNovaZelandia();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}