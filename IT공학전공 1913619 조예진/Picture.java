package com.example.for_hw;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Picture extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);

        TextView tv_ti=(TextView)findViewById(R.id.title);
        TextView tv_ex=(TextView)findViewById(R.id.explain);
        ImageView iv_pi=(ImageView)findViewById(R.id.picture);

        Intent it=getIntent();
        String tag=it.getStringExtra("it_tag");
        Resources res =getResources();

        int id_title=res.getIdentifier("title"+tag, "string",getPackageName());
        String title=res.getString(id_title);
        tv_ti.setText(title);

        int id_explain=res.getIdentifier("explain"+tag, "string",getPackageName());
        String explain=res.getString(id_explain);
        tv_ex.setText(explain);

        int id_picture=res.getIdentifier("picture"+tag, "string",getPackageName());
        String picture=res.getString(id_picture);
        int id_img=res.getIdentifier(picture,"drawable",getPackageName());

        Drawable drawable=res.getDrawable(id_img);
        iv_pi.setBackground(drawable);
    }
    public void closePicture(View v){
        finish();
    }
}
