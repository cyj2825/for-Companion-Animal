package com.example.for_hw;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import java.util.Random;

public class Event extends AppCompatActivity {
    ImageView iv_roulette;
    float startDegree = 0f;
    float endDegree = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);

        iv_roulette = (ImageView)findViewById(R.id.roulette);
    }
    public void rotate(View v){
        startDegree = endDegree;

        Random rand = new Random();
        int degree_rand = rand.nextInt(360);
        endDegree = startDegree + 360 * 3 + degree_rand;

        ObjectAnimator object = ObjectAnimator.ofFloat(iv_roulette,"rotation",startDegree,endDegree);
        object.setInterpolator(new AccelerateDecelerateInterpolator());
        object.setDuration(5000);
        object.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.menu){
            Intent it=new Intent(this, Accommodation.class);
            startActivity(it);
            finish();
            return true;
        }else if(id==R.id.menu0) {
            Intent it = new Intent(this, Acc_Explain.class);
            startActivity(it);
            finish();
            return true;
        }else if(id==R.id.menu2) {
            Intent it = new Intent(this, Hospital.class);
            startActivity(it);
            finish();
            return true;
        }else if(id==R.id.menu3) {
            Intent it = new Intent(this, Event.class);
            startActivity(it);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}