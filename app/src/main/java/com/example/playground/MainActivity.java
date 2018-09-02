package com.example.playground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);
        MainFragment fragment = new MainFragment();
        fragment.show(getSupportFragmentManager(), null);
    }
}
