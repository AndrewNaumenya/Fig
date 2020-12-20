package com.example.figures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Triangle extends AppCompatActivity implements Figure{
    private EditText oneTria;
    private EditText twoTria;
    private EditText threeTria;
    private Button butTria;
    private TextView centTria;
    private TextView squaTria;
    private TextView perTria;
    private double oneTri;
    private double twoTri;
    private double threeTri;
    private double xxxx;
    private double yyyy;
    private EditText x;
    private EditText y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);


        oneTria = findViewById(R.id.one_triangle);
        twoTria = findViewById(R.id.two_triangle);
        threeTria = findViewById(R.id.tree_triangle);
        butTria = findViewById(R.id.button_triangle);
        centTria = findViewById(R.id.triangle_center);
        squaTria = findViewById(R.id.triangle_square);
        perTria = findViewById(R.id.triangle_perimeter);
        x = findViewById(R.id.xx);
        y = findViewById(R.id.yy);

        butTria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oneT = oneTria.getText().toString();
                String twoT = twoTria.getText().toString();
                String threeT = threeTria.getText().toString();
                String xxx = x.getText().toString();
                String yyy = y.getText().toString();
                if (xxx.isEmpty())
                    Toast.makeText(getApplicationContext(), "Введи координату х", Toast.LENGTH_SHORT).show();
                else if (yyy.isEmpty())
                    Toast.makeText(getApplicationContext(), "Введи координату у", Toast.LENGTH_SHORT).show();
                else if (oneT.isEmpty())
                    Toast.makeText(getApplicationContext(),"Введи длину основания",Toast.LENGTH_LONG).show();
                else if (twoT.isEmpty())
                    Toast.makeText(getApplicationContext(),"Введи длину первой стороны",Toast.LENGTH_LONG).show();
                else if (threeT.isEmpty())
                    Toast.makeText(getApplicationContext(),"Введи длину второй стороны",Toast.LENGTH_LONG).show();
                else {
                    oneTri = Double.parseDouble(oneT);
                    twoTri = Double.parseDouble(twoT);
                    threeTri = Double.parseDouble(threeT);
                    xxxx = Double.parseDouble(xxx);
                    yyyy = Double.parseDouble(yyy);
                    if (!(oneTri<twoTri+threeTri && twoTri<oneTri+threeTri && threeTri<oneTri+twoTri))
                        Toast.makeText(getApplicationContext(),"Введи корректные длины сторон",Toast.LENGTH_LONG).show();
                    else {

                        getCenter(xxxx, yyyy);
                        getSquare(oneTri, twoTri, threeTri);
                        getPerimeter(oneTri, twoTri, threeTri);
                    }
                }



            }
        });
    }

    @Override
    public void getCenter(double a, double b) {
        centTria.setText("Координаты - X: "+ a+ ", Y: "+ b);
    }

    @Override
    public void getSquare(double a, double b, double c) {
        squaTria.setText("Площадь: "+ (Math.sqrt(((a+b+c)/2) * (((a+b+c)/2) - a)*(((a+b+c)/2) - b)*(((a+b+c)/2) - c))));
    }

    @Override
    public void getPerimeter(double a, double b, double c) {
        perTria.setText("Периметр: "+ (a+b+c));
    }
}
