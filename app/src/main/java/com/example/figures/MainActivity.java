package com.example.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] figures = {"Не выбрано", "Треугольник", "Прямоугольник", "Круг"};
    TextView get_figure;
    String figure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.figures);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, figures);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        get_figure = (TextView) findViewById(R.id.get_figure);
        Button button_one = findViewById(R.id.button_main);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                figure = (String)parent.getItemAtPosition(position);
                get_figure.setText(figure);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (figure) {
                    case "Треугольник": {
                        Intent intent = new Intent(getApplicationContext(), Triangle.class);
                        startActivity(intent);
                        break;
                    }
                    case "Прямоугольник": {
                        Intent intent = new Intent(getApplicationContext(), Rectangle.class);
                        startActivity(intent);
                        break;
                    }
                    case "Круг": {
                        Intent intent = new Intent(getApplicationContext(), Circle.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });




    }

}