package com.example.for_hw;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Accommodation extends AppCompatActivity {
    private EditText et_name;
    private EditText et_tel;
    private RadioGroup rg_htname;
    private RadioGroup rg_num;
    private RadioGroup rg_anum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accommodation);

        et_name = (EditText)findViewById(R.id.name);
        et_tel = (EditText)findViewById(R.id.tel);
        rg_htname = (RadioGroup)findViewById(R.id.htname);
        rg_num = (RadioGroup)findViewById(R.id.personnum);
        rg_anum = (RadioGroup)findViewById(R.id.aninum);

        Button btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_name = et_name.getText().toString();
                String str_tel = et_tel.getText().toString();

                RadioButton rb_htname;
                String str_htname = "";
                if (rg_htname.getCheckedRadioButtonId() == R.id.cap){
                    rb_htname = (RadioButton)findViewById(R.id.cap);
                    str_htname = rb_htname.getText().toString();
                }
                if (rg_htname.getCheckedRadioButtonId() == R.id.res){
                    rb_htname = (RadioButton)findViewById(R.id.res);
                    str_htname = rb_htname.getText().toString();
                }
                if (rg_htname.getCheckedRadioButtonId() == R.id.sain){
                    rb_htname = (RadioButton)findViewById(R.id.sain);
                    str_htname = rb_htname.getText().toString();
                }

                RadioButton rb_num;
                String str_num = "";
                if (rg_num.getCheckedRadioButtonId() == R.id.one){
                    rb_num = (RadioButton)findViewById(R.id.one);
                    str_num = rb_num.getText().toString();
                }
                if (rg_num.getCheckedRadioButtonId() == R.id.two){
                    rb_num = (RadioButton)findViewById(R.id.two);
                    str_num = rb_num.getText().toString();
                }
                if (rg_num.getCheckedRadioButtonId() == R.id.three){
                    rb_num = (RadioButton)findViewById(R.id.three);
                    str_num = rb_num.getText().toString();
                }
                if (rg_num.getCheckedRadioButtonId() == R.id.four){
                    rb_num = (RadioButton)findViewById(R.id.four);
                    str_num = rb_num.getText().toString();
                }
                if (rg_num.getCheckedRadioButtonId() == R.id.five){
                    rb_num = (RadioButton)findViewById(R.id.five);
                    str_num = rb_num.getText().toString();
                }

                RadioButton rb_anum;
                String str_anum = "";
                if (rg_anum.getCheckedRadioButtonId() == R.id.one1){
                    rb_anum = (RadioButton)findViewById(R.id.one1);
                    str_anum = rb_anum.getText().toString();
                }
                if (rg_anum.getCheckedRadioButtonId() == R.id.two2){
                    rb_anum = (RadioButton)findViewById(R.id.two2);
                    str_anum = rb_anum.getText().toString();
                }

                Intent it = new Intent(Accommodation.this, reservationInfo.class);

                Bundle extras = new Bundle();
                extras.putString("name",str_name);
                extras.putString("tel",str_tel);
                extras.putString("htname",str_htname);
                extras.putString("num",str_num);
                extras.putString("anum",str_anum);

                it.putExtras(extras);
                startActivity(it);
            }
        });
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
