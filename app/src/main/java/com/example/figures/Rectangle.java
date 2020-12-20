package com.example.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rectangle extends AppCompatActivity implements Figure{
    private EditText oneRect;
    private EditText twoRect;
    private Button butRect;
    private TextView centRect;
    private TextView squaRect;
    private TextView perRect;
    private double oneRec;
    private double twoRec;
    private double xxxx;
    private double yyyy;
    private EditText x;
    private EditText y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);


        oneRect = findViewById(R.id.one_rectangle);
        twoRect = findViewById(R.id.two_rectangle);
        butRect = findViewById(R.id.button_rectangle);
        centRect = findViewById(R.id.rectangle_center);
        squaRect = findViewById(R.id.rectangle_square);
        perRect = findViewById(R.id.rectangle_perimeter);
        x = findViewById(R.id.xx);
        y = findViewById(R.id.yy);

        butRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oneR = oneRect.getText().toString();
                String twoR = twoRect.getText().toString();
                String xxx = x.getText().toString();
                String yyy = y.getText().toString();
                if (xxx.isEmpty())
                    Toast.makeText(getApplicationContext(), "Введи координату х", Toast.LENGTH_SHORT).show();
                else if (yyy.isEmpty())
                    Toast.makeText(getApplicationContext(), "Введи координату у", Toast.LENGTH_SHORT).show();
                else if (oneR.isEmpty())
                    Toast.makeText(getApplicationContext(),"Введи длину первой стороны",Toast.LENGTH_LONG).show();
                else if (twoR.isEmpty())
                    Toast.makeText(getApplicationContext(),"Введи длину второй стороны",Toast.LENGTH_LONG).show();
                else {
                    oneRec = new Double(oneR);
                    twoRec = new Double(twoR);
                    xxxx = Double.parseDouble(xxx);
                    yyyy = Double.parseDouble(yyy);

                    if (oneRec==0 || twoRec==0)
                        Toast.makeText(getApplicationContext(),"Введи корректные длины сторон",Toast.LENGTH_LONG).show();
                    else{
                        getCenter(xxxx, yyyy);
                        getSquare(oneRec, twoRec, 0);
                        getPerimeter(oneRec, twoRec, 0);
                    }}

            }
        });
    }

    @Override
    public void getCenter(double a, double b) {
        centRect.setText("Координаты - X: "+ a+ ", Y: "+ b);
    }

    @Override
    public void getSquare(double a, double b, double c) {
        squaRect.setText("Площадь: "+ (a*b));
    }

    @Override
    public void getPerimeter(double a, double b, double c) {
        perRect.setText("Периметр: "+ (2*(a+b)));
    }
}