package com.example.imagecaptioner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class activity_camera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction().add(R.id.container,new Camera2BasicFragment()).commit();
        }
    }
}
