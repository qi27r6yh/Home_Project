package com.example.a777.home_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 777 on 27.01.2018.
 * Это активность для выбора вида имитируемой силы
 */

public class ChoiceForces extends Activity {
    Button returnButton;//по нажатию будет осуществлен переход к главному экран(активности)
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_forces);
        returnButton=(Button) findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(ChoiceForces.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
