package com.turath.masael.controller.ui.profile;

import android.content.Context;
import android.content.res.Resources;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.turath.masael.R;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] childFragments;
    Context context;

    public ViewPagerAdapter(Context context,FragmentManager fm) {

        super(fm);
        childFragments = new Fragment[] {
                new MyQuestionsChildFragment(), //0
                new BookmarksChildFragment(), //1

        };
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title= context.getString(R.string.my_questions);
                break;
            case 1:
                title= context.getString(R.string.bookmarks);
                break;

        }
//        String title = getItem(position).getClass().getName();
//        return title.subSequence(title.lastIndexOf(".") + 1, title.length());
        return title;
    }
}