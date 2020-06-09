package com.turath.masael.controller.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.appbar.AppBarLayout;
import com.turath.masael.R;
import com.turath.masael.controller.ui.AskDialogFragment;

public class HomeFragment extends Fragment {

    ImageButton div1,div2,div3,div4,all;
    Bundle arg=new Bundle();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_home, container, false);
//

        div1=root.findViewById(R.id.division1);
        div1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arg.putInt("div",1);
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_questions,arg);
//

            }
        });
        div2=root.findViewById(R.id.division2);
        div2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arg.putInt("div",2);
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_questions,arg);
//

            }
        });
        div3=root.findViewById(R.id.division3);
        div3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arg.putInt("div",3);
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_questions,arg);
//

            }
        });
        div4=root.findViewById(R.id.division4);
        div4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arg.putInt("div",4);
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_questions,arg);
//

            }
        });
        all=root.findViewById(R.id.all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arg.putInt("div",0);
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_questions,arg);
//

            }
        });


        return root;
    }


}