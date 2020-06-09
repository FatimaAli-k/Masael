package com.turath.masael.controller.ui.posts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.turath.masael.R;
import com.turath.masael.controller.ui.AskDialogFragment;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

public class PostsFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_posts, container, false);

        TextView appbarTitle=root.findViewById(R.id.appbar_title);
        appbarTitle.setText(getString(R.string.title_posts));


        return root;
    }

}