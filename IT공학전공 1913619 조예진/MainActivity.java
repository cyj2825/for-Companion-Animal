package com.example.for_hw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    ImageView eventbox;
    SensorManager sm = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventbox = findViewById(R.id.eventbox);
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE );
        Sensor sensorAcceler = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if( sensorAcceler != null ) {
            sm.registerListener(this, sensorAcceler, SensorManager.SENSOR_DELAY_UI);
        }
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float v[] = event.values;
            double sum = Math.abs(v[0]) + Math.abs(v[1]) + Math.abs(v[2]);
            if( sum > 30 ) {
                int[] imageId = {R.drawable.eventbox1, R.drawable.eventbox2, R.drawable.eventbox3, R.drawable.eventbox4};
                int rand = getRandom(4, 0);
                eventbox.setImageResource( imageId[rand] );
            }
        }
    }
    int getRandom(int range, int min) {
        return (int)(Math.random() * range) + min;
    }

    public void displayPicture(View v){
        int id=v.getId();
        LinearLayout layout=(LinearLayout) v.findViewById(id);
        String tag=(String) layout.getTag();

        Intent it=new Intent(this, Picture.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
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