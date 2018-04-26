package com.anar.rupestrarium;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

public class Instrucciones extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.instrucciones,container,false);

        String language = Locale.getDefault().getLanguage();
        Drawable bg = getResources().getDrawable(R.drawable.instr_en);

        if (language == "en"){

            if (Build.VERSION.SDK_INT >= 16)
                view.setBackground(bg);
            else
                view.setBackgroundDrawable(bg);
        }


        return view;
    }
}