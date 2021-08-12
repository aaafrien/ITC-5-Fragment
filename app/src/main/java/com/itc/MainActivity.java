package com.itc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentIntro mfragmentIntro = new FragmentIntro();
        Fragment fragmentIntro = mFragmentManager.findFragmentByTag(FragmentIntro.class.getSimpleName());

        if (!(fragmentIntro instanceof FragmentIntro)) {
            mFragmentManager.beginTransaction()
                    .add(R.id.fl_mainFrame, mfragmentIntro, FragmentIntro.class.getSimpleName())
                    .commit();
        }
    }
}