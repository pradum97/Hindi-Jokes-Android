package com.techsofts.hindijokes.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.techsofts.hindijokes.R;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);

        startActivity(new Intent(Splash_Screen.this, MainActivity.class));
        finish();


    }
}
