package com.example.pariprojectandroidstudiospinthebottle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
 private ImageView bott;
 private Random rand = new Random();
 private int lstDr;
 private boolean spn;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 bott = findViewById(R.id.bottle);
 }
 public void spinBottle(View v) {
 // check if the bottled has stopped spinning
 if (!spn) {
 // generate a random number from 1-2000
 int no_of_spin = rand.nextInt(2000);
 // set the pivot to the centre of the image
 float pX = bott.getWidth() / 2;
 float pY = bott.getHeight() / 2;
 // pass parameters in RotateAnimation function
 Animation rot = new RotateAnimation(lstDr, no_of_spin, pX, pY);
 // set rotate duration 2500 millisecond
 rot.setDuration(2500);
 // rotation will persist after finishing
 rot.setFillAfter(true);
 rot.setAnimationListener(new Animation.AnimationListener() {
 @Override
 public void onAnimationStart(Animation animation) {
 spn = true;
 }
 @Override
 public void onAnimationEnd(Animation animation) {
 spn = false;
 }
 @Override
 public void onAnimationRepeat(Animation animation) {
 }
 });
 // change the last direction
 lstDr = no_of_spin;
 // start the animation
 bott.startAnimation(rot);
 }
 }
}
