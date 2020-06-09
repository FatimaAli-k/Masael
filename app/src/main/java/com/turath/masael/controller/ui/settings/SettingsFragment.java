package com.turath.masael.controller.ui.settings;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.turath.masael.MainActivity;
import com.turath.masael.R;
import com.turath.masael.controller.ui.LoginDialogFragment;
import com.turath.masael.controller.ui.RegisterDialogFragment;

import java.util.Locale;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

public class SettingsFragment extends Fragment {
    Button login,logout,register;
    Switch themeSwitch;
    RadioGroup fontSelect,app_lang,content_lang;
    RadioButton f1,f2,f3,ar,en,fr,ar2,en2,fr2;
    ImageButton increase,decrease;
    TextView sizeSample;
    Typeface typeface;
    boolean changed=false;
    SharedPreferences settingsPrefs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        settingsPrefs = getActivity().getSharedPreferences("settings", Activity.MODE_PRIVATE);

//        //hide fab
//        FloatingActionButton fab = ((MainActivity) getActivity()).getFloatingActionButton();
//        fab.hide();


        //theme
        themeSwitch=root.findViewById(R.id.themeSwitch);
        changeTheme();

        login=root.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
//                getActivity().recreate();

                LoginDialogFragment cf=new LoginDialogFragment();
//        cf.setArguments(bundle);
                FragmentTransaction ft =  getChildFragmentManager().beginTransaction();
                Fragment prev =  getChildFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);


                cf.show(ft, "dialog");
            }
        });

        register=root.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RegisterDialogFragment cf=new RegisterDialogFragment();
//        cf.setArguments(bundle);
                FragmentTransaction ft =  getChildFragmentManager().beginTransaction();
                Fragment prev =  getChildFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);


                cf.show(ft, "dialog");
            }
        });


        increase=root.findViewById(R.id.increase);
        decrease=root.findViewById(R.id.decrease);
        sizeSample=root.findViewById(R.id.sizeSample);

        //font
        fontSelect=root.findViewById(R.id.fontSelect);
        f1=root.findViewById(R.id.f1);
        f2=root.findViewById(R.id.f2);
        f3=root.findViewById(R.id.f3);
        fontChange();

        //size
        fontResize();

        //default settings
        Button defaultSettings=root.findViewById(R.id.defaultSettings);
        defaultSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = settingsPrefs.edit();
                editor.putFloat("size", 16);
                editor.putInt("font",1);
                editor.putInt("app_lang",1);
                editor.putBoolean("nightMode", false);
                editor.apply();
                changed=true;
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                fontChange();
                getActivity().recreate();


            }
        });


//        saveSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(changed)
//                    getActivity().recreate();
//            }
//        });

        //app lang select
        app_lang=root.findViewById(R.id.app_languageSelect);
        ar=root.findViewById(R.id.AR);
        en=root.findViewById(R.id.EN);
        fr=root.findViewById(R.id.FR);
        appLangSelect();

        return root;
    }

    private void changeTheme() {

        themeSwitch.setChecked(settingsPrefs.getBoolean("nightMode",false));

        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!settingsPrefs.getBoolean("nightMode",false)) {
                    SharedPreferences.Editor editor = settingsPrefs.edit();
                    editor.putBoolean("nightMode", true);
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);

                }
                else{
                    SharedPreferences.Editor editor = settingsPrefs.edit();
                    editor.putBoolean("nightMode", false);
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                getActivity().recreate();
            }
        });
    }

    private void fontChange() {





        if(settingsPrefs.getInt("font",1)==1)
        {
            f1.setChecked(true);
            SharedPreferences.Editor editor = settingsPrefs.edit();
            editor.putInt("font", 1);
            editor.apply();
            typeface = ResourcesCompat.getFont(getContext(), R.font.myfont);

        }
        else if(settingsPrefs.getInt("font",1)==2){

            f2.setChecked(true);
            SharedPreferences.Editor editor = settingsPrefs.edit();
            editor.putInt("font", 2);
            editor.apply();
            typeface = ResourcesCompat.getFont(getContext(), R.font.myfont2);
        }
        else{

            f3.setChecked(true);
            SharedPreferences.Editor editor = settingsPrefs.edit();
            editor.putInt("font", 3);
            editor.apply();
            typeface = ResourcesCompat.getFont(getContext(), R.font.myfont3);

        }

//        final Button saveSettings=root.findViewById(R.id.saveSettings);

        sizeSample.setTypeface(typeface);

        fontSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int f=1;
                if(i==f3.getId()) {
                    f = 3;
                    typeface = ResourcesCompat.getFont(getContext(), R.font.myfont3);
                }
                else if(i==f2.getId()) {
                    f = 2;
                    typeface = ResourcesCompat.getFont(getContext(), R.font.myfont2);
                }
                else {
                    f = 1;
                    typeface = ResourcesCompat.getFont(getContext(), R.font.myfont);
                }
                SharedPreferences.Editor editor = settingsPrefs.edit();
                editor.putInt("font", f);
                editor.apply();

                sizeSample.setTypeface(typeface);
                sizeSample.invalidate();
                changed=true;
//                saveSettings.setVisibility(View.VISIBLE);
//           getActivity().recreate();
            }
        });
    }

    private void fontResize() {



        sizeSample.setTextSize(settingsPrefs.getFloat("size",16));

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float px = sizeSample.getTextSize();
                float sp = px / getResources().getDisplayMetrics().scaledDensity;
                Log.d("d", "onClick: "+sp);
                if(sp<52) {
                    sizeSample.setTextSize(sp + 4);
                    sizeSample.invalidate();
                    SharedPreferences.Editor editor = settingsPrefs.edit();
                    editor.putFloat("size", sp + 4);
                    editor.apply();
                    changed=true;
//                    saveSettings.setVisibility(View.VISIBLE);


                }
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float px = sizeSample.getTextSize();
                float sp = px / getResources().getDisplayMetrics().scaledDensity;
                if(sp>12) {
                    sizeSample.setTextSize(sp - 2);
                    sizeSample.invalidate();
                    SharedPreferences.Editor editor = settingsPrefs.edit();
                    editor.putFloat("size", sp - 2);
                    editor.apply();
                    changed=true;
//                    saveSettings.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void appLangSelect() {



        if(settingsPrefs.getInt("app_lang",1)==1)
        {
            ar.setChecked(true);
            SharedPreferences.Editor editor = settingsPrefs.edit();
            editor.putInt("app_lang", 1);
            editor.apply();
            String languageToLoad  = "ar";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getContext().getResources().updateConfiguration(config,getContext().getResources().getDisplayMetrics());



        }
        else if(settingsPrefs.getInt("app_lang",1)==2)
        {
            en.setChecked(true);
            SharedPreferences.Editor editor = settingsPrefs.edit();
            editor.putInt("app_lang", 2);
            editor.apply();
            String languageToLoad  = "en";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getContext().getResources().updateConfiguration(config,getContext().getResources().getDisplayMetrics());



        }
        else
        {
            fr.setChecked(true);
            SharedPreferences.Editor editor = settingsPrefs.edit();
            editor.putInt("app_lang", 3);
            editor.apply();
            String languageToLoad  = "fr";
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getContext().getResources().updateConfiguration(config,getContext().getResources().getDisplayMetrics());



        }
        app_lang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int f;
                if(i==fr.getId()) {
                    f = 3;
                    String languageToLoad  = "fr";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getContext().getResources().updateConfiguration(config,getContext().getResources().getDisplayMetrics());


                }
                else if(i==en.getId()) {
                    f = 2;
                    String languageToLoad  = "en";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getContext().getResources().updateConfiguration(config,getContext().getResources().getDisplayMetrics());


                }
                else {
                    f = 1;
                    String languageToLoad  = "ar";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getContext().getResources().updateConfiguration(config,getContext().getResources().getDisplayMetrics());


                }
                SharedPreferences.Editor editor = settingsPrefs.edit();
                editor.putInt("app_lang", f);
                editor.apply();

                changed=true;

                getActivity().recreate();
            }
        });
    }
}