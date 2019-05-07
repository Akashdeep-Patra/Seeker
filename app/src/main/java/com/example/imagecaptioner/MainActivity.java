package com.example.imagecaptioner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    Button b2;
    private int select_code = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.cam);
        b2 = findViewById(R.id.gal);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cam) {
            startActivity(new Intent(this, activity_camera.class));
        } else if (v.getId() == R.id.gal) {
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            startActivityForResult(i, select_code);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == select_code && resultCode == RESULT_OK) {
            Uri image_path = data.getData();
            startActivity(new Intent(MainActivity.this, activity_galary.class).setData(image_path));


        }
    }
}


