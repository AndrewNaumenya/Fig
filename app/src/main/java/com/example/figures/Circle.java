package com.example.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Circle extends AppCompatActivity implements Figure{
    private EditText oneCirc;
    private Button butCirc;
    private TextView centCirc;
    private TextView squaCirc;
    private TextView perCirc;
    private double oneCir;
    private double xxxx;
    private double yyyy;
    private EditText x;
    private EditText y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);


        oneCirc = findViewById(R.id.one_circle);
        butCirc = findViewById(R.id.button_circle);
        centCirc = findViewById(R.id.circle_center);
        squaCirc = findViewById(R.id.circle_square);
        perCirc = findViewById(R.id.circle_perimeter);
        x = findViewById(R.id.xx);
        y = findViewById(R.id.yy);

        butCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oneC = oneCirc.getText().toString();
                String xxx = x.getText().toString();
                String yyy = y.getText().toString();
                if (xxx.isEmpty())
                    Toast.makeText(getApplicationContext(), "Введи координату х", Toast.LENGTH_SHORT).show();
                else if (yyy.isEmpty())
                    Toast.makeText(getApplicationContext(), "Введи координату у", Toast.LENGTH_SHORT).show();
                else if (oneC.isEmpty())
                    Toast.makeText(getApplicationContext(),"Введи длину радиуса",Toast.LENGTH_LONG).show();
                else {
                    oneCir = new Double(oneC);
                    xxxx = Double.parseDouble(xxx);
                    yyyy = Double.parseDouble(yyy);
                    getCenter(xxxx, yyyy);
                    getSquare(oneCir, 0, 0);
                    getPerimeter(oneCir, 0, 0);

                if (oneCir==0)
                    Toast.makeText(getApplicationContext(),"Введи корректную длину радиуса",Toast.LENGTH_LONG).show();
                else{
                    getCenter(xxxx, yyyy);
                    getSquare(oneCir, 0, 0);
                    getPerimeter(oneCir, 0, 0);
                }}

            }
        });
    }

    @Override
    public void getCenter(double a, double b) {
        centCirc.setText("Координаты - X: "+ a+ ", Y: "+ b);
    }

    @Override
    public void getSquare(double a, double b, double c) {
        squaCirc.setText("Площадь: "+ (Math.PI*oneCir*oneCir));
    }

    @Override
    public void getPerimeter(double a, double b, double c) {
        perCirc.setText("Периметр: "+ (Math.PI*oneCir*2));
    }
}