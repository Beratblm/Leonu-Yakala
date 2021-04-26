package com.example.tekresimkenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView textViewzaman;
TextView textviewskor;
ImageView imageview;
int numara;
int Screenx,Screeny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    textviewskor = findViewById(R.id.textviewskor);
    textViewzaman = findViewById(R.id.textViewzaman);
    imageview = findViewById(R.id.imageView);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Screenx = size.x;
        Screeny = size.y;
        numara = 0;
        oyunabasla();


    }
  public void Tikla(View view){
        if(numara<3){
            Toast.makeText(MainActivity.this,"Biraz cabuk",Toast.LENGTH_SHORT).show();
        }
        if(numara<6){
            Toast.makeText(MainActivity.this,"iyi gidiyorsun",Toast.LENGTH_SHORT).show();
        }
        if(numara>8){
            Toast.makeText(MainActivity.this,"Harikasin",Toast.LENGTH_SHORT).show();
        }
        numara++;
textviewskor.setText("Skor :" +numara);


  }
  public void oyunabasla(){
      new CountDownTimer(10000, 400) {
          @Override
          public void onTick(long millisUntilFinished) {
              textViewzaman.setText("ZAMAN "+millisUntilFinished/1000);
              float Randomx = new Random().nextInt(Screenx - imageview.getMeasuredWidth());
              float Randomy = new Random().nextInt(Screeny - 3 * imageview.getMeasuredHeight());
              imageview.setX(Randomx);
              imageview.setY(Randomy);

          }

          @Override
          public void onFinish() {
              AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
              alert.setTitle("Oyun Bitti");
              alert.setMessage("Yeniden Baslamak istermisin");
              alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {

                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      numara = 0;
                      textviewskor.setText("Skor :" +numara);
                      oyunabasla();

                  }
              });
              alert.setNegativeButton("Hayir", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      imageview.setVisibility(View.INVISIBLE);


                  }
              });

              alert.show();
          }
      }.start();
    }






}

