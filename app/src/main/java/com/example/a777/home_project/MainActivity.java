package com.example.a777.home_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button startButton; //кнопка перехода к активности с категории мини-игр
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Это главный экран, с него можно перейти к выбору изучаемой силы", Toast.LENGTH_LONG).show();
        startButton = (Button) findViewById(R.id.startButton);
// по нажатию на кнопку будет осуществлен переход на активность с выобором категории мини-игр
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, ChoiceForces.class);
                startActivity(intent);
            }
        });
    }
}
