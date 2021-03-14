package com.example.for_hw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class reservationInfo extends AppCompatActivity {
    TextView result;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_info);

        result=(TextView)findViewById(R.id.result);
        btn=(Button)findViewById(R.id.button2);

        Bundle extras=getIntent().getExtras();
        result.setText("성명 : "+extras.getString("name")+"\n 전화번호 : "+extras.getString("tel")+
                "\n 예약한 호텔이름 : " +extras.getString("htname") + "\n 인원수 : "+extras.getString("num")+
                "\n 반려동물 수 : "+extras.getString("anum")+"\n");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(reservationInfo.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

