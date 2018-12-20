package com.example.thampotter.atbmtt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button dichvong, affine, vigenere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        onClick();
    }

    private void onClick() {
        dichvong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DichVongActivity.class);
                startActivity(intent);
            }
        });
        affine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AfineActicity.class);
                startActivity(intent);
            }
        });
        vigenere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VigenereActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        dichvong = findViewById(R.id.btndichvong);
        affine = findViewById(R.id.btnaffine);
        vigenere = findViewById(R.id.btnvige);
    }
}
