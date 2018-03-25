package com.example.a777.home_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button startButton, personButton, historyButton; //history для чтения предистории
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText
                (this, "Это главный экран, с него можно перейти к созданию персонажа и началу игры",
                        Toast.LENGTH_LONG).show();
        startButton = (Button) findViewById(R.id.startButton);
        personButton = (Button) findViewById(R.id.CreatePersonButton);
        historyButton = (Button) findViewById(R.id.bookButton);

        personButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, PersonActivity.class);
                startActivity(intent);
                finish();
            }
        });
       historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
