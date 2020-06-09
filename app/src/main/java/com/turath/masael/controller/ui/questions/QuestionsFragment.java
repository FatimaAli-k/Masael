package com.turath.masael.controller.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.turath.masael.R;
import com.turath.masael.controller.ui.AskDialogFragment;
import com.turath.masael.controller.ui.LoginDialogFragment;

public class QuestionsFragment extends Fragment {

    ImageButton appbarBack;
    TextView appbarTitle;
    int div;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_questions, container, false);

         appbarTitle=root.findViewById(R.id.appbar_title);
         appbarBack=root.findViewById(R.id.appbar_back);
         appbarBack.setVisibility(View.VISIBLE);

      div= getArguments().getInt("div",0) ;
      switch (div){
          case 1:
              appbarTitle.setText(getResources().getText(R.string.division1));
              break;
          case 2:
              appbarTitle.setText(getResources().getText(R.string.division2));
              break;
          case 3:
              appbarTitle.setText(getResources().getText(R.string.division3));
              break;
          case 4:
              appbarTitle.setText(getResources().getText(R.string.division4));
              break;

              default:
                  appbarTitle.setText(getResources().getText(R.string.all));
                  break;
      }

      appbarBack.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              getActivity().onBackPressed();
          }
      });



        return root;
    }

}