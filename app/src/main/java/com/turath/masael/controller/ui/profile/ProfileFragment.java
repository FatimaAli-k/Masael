package com.turath.masael.controller.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.turath.masael.R;
import com.turath.masael.controller.ui.AskDialogFragment;

public class ProfileFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        ViewPager viewPager = root.findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getContext(),getChildFragmentManager()));

        TabLayout tabLayout=root.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

       return root;
    }
}