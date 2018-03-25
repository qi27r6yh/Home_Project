package com.example.a777.home_project;

        import android.app.Activity;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.InputType;
        import android.view.KeyEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import org.json.JSONStringer;

        import java.io.BufferedWriter;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.OutputStreamWriter;

/**
 * Created by 777 on 27.01.2018.
 * This activity for Person
 */

public class PersonActivity extends AppCompatActivity {
    Button returnButton;//по нажатию будет осуществлен переход к главному экран(активности)
    Button ok;//кнопка подтверждения (в данном случае кнопка сохранения имени персонажа)

    Intent intent;

    EditText editText;// поле для ввода имени персонажа
    TextView textView;//поле для отображения имени персонажа


    Person person;
    GsonBuilder builder = new GsonBuilder();
    Gson gson =  builder.create(); //new GsonBuilder().create();  builder.create();

    public static String json;

 /*   @Override
    protected void onStart() {
        person = gson.fromJson(json, Person.class);
        if (person.name!=null){
            editText.setCursorVisible(false);
            editText.setLongClickable(false);
            editText.setFocusable(false);
            ok.setCursorVisible(false);
            ok.setFocusable(false);
            ok.setLongClickable(false);

            textView.setText(person.getName());
        }
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_activity);

        returnButton = (Button) findViewById(R.id.returnButton);
        ok = (Button) findViewById(R.id.OKButton);
        editText = (EditText) findViewById(R.id.editTextName);

        textView = (TextView) findViewById(R.id.textView2);

        // по нажатию на кнопку OK, если введенное значение имени соответсвует требованиям, editText блокируется
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!editText.getText().toString().equals("")){

                    person = new Person(editText.getText().toString());
                    json = gson.toJson(person);
                    person = gson.fromJson(json, Person.class);
                    textView.setText(person.getName());
                    //Блокировка editText.
                    editText.setCursorVisible(false);
                    editText.setLongClickable(false);
                    editText.setFocusable(false);

                    /*
                    if (!json.equals("")) {
                        person = new Person(editText.getText().toString());
                        json = gson.toJson(person);
                        person = gson.fromJson(json, Person.class);
                        textView.setText(person.getName());
                        editText.setCursorVisible(false);
                        editText.setLongClickable(false);
                        editText.setFocusable(false);
                    }else{
                        person = gson.fromJson(json, Person.class);
                        editText.setText(person.getName());
                        editText.setCursorVisible(false);
                        editText.setLongClickable(false);
                        editText.setFocusable(false);
                    }*/
                }
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(PersonActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
