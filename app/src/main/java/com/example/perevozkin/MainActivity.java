package com.example.perevozkin;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements UpdateListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            BlankFragment fragment = new BlankFragment();

            fragmentTransaction.add(R.id.main, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onUpdateText(String newText) {
        BlankFragment fragment = (BlankFragment) fragmentManager.findFragmentById(R.id.main);
        fragment
        fragment2.counter_text.setText(newText);
    }

    @Override
    public void onFragmentSwitch(int container_id, Fragment newFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(container_id, newFragment).addToBackStack(null).commit();
    }
}