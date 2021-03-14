package com.example.for_hw;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Acc_Explain extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acc_explain);
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
