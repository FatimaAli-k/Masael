package com.turath.masael.controller.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.turath.masael.R;
import com.turath.masael.controller.tools.SwipeDismissTouchListener;


public class AskDialogFragment extends DialogFragment {

    Button send, catBtn;
    int cat=0;

    public AskDialogFragment(){}


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.ask, container,false);
       send=view.findViewById(R.id.send);
       catBtn =view.findViewById(R.id.catBtn);
       catBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               PopupMenu popup = new PopupMenu(getContext(), view);
               popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem menuItem) {
                       String name="";
                       switch (menuItem.getItemId()) {
                           case R.id.division1:
                               cat=1;
                              name= menuItem.getTitle().toString();

                           case R.id.division2:
                               cat=2;
                               name= menuItem.getTitle().toString();

                           case R.id.division3:
                               cat=3;
                               name= menuItem.getTitle().toString();

                           case R.id.division4:
                               cat=4;
                               name= menuItem.getTitle().toString();

                           case R.id.unknown:
                               cat=0;
                               name= menuItem.getTitle().toString();



                       }

                       catBtn.setText(name);
                       return true;
                   }
               });
               popup.inflate(R.menu.cat_menu);
               popup.show();
           }
       });

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.bg_round_corner);

        return view;
    }



//    @Override
//    public void onDismiss(DialogInterface dialog) {
//        super.onDismiss(dialog);
//
//    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();

        if(window == null) return;
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
//        params.height = (int)(getResources().getDisplayMetrics().heightPixels*0.75);
        window.setAttributes(params);
        window.getDecorView().setOnTouchListener(new SwipeDismissTouchListener(window.getDecorView(), null, new SwipeDismissTouchListener.DismissCallbacks() {
            @Override
            public boolean canDismiss(Object token) {
                return true;
            }

            @Override
            public void onDismiss(View view, Object token) {
                dismiss();
            }
        }));
    }


    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(getContext(), v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.cat_menu, popup.getMenu());
        popup.show();
    }

}