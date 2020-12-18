package com.example.mytextquest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Endscene extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        String str=getIntent().getStringExtra("result");
        TextView txt=((TextView) findViewById(R.id.result));
        Button but=((Button) findViewById(R.id.butend));
        txt.setText(str);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.butend:
                                    Intent i =new Intent(Endscene.this,MainActivity.class);
                                    startActivity(i);
                                    break;
                }
            }
        };
        but.setOnClickListener(listener);
    }
}
