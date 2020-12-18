package com.example.mytextquest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startname);
        //Print text
        TextView TV1=((TextView) findViewById(R.id.tv1));
        DelayedPrinter.Word word = new DelayedPrinter.Word(50, getString(R.string.starttext));
        word.setOffset(40);
        DelayedPrinter.printText(word, TV1);
        Button but = ((Button) findViewById(R.id.but));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.but:
                        EditText ed = ((EditText) findViewById(R.id.ed));
                        //Check name
                        if (ed.length()==0){
                            TextView mistake=((TextView) findViewById(R.id.mistake));
                            mistake.setText("");
                            DelayedPrinter.Word word = new DelayedPrinter.Word(50, getString(R.string.mistakename));
                            word.setOffset(40);
                            DelayedPrinter.printText(word, mistake);
                            //next page
                        }else {
                            Intent i = new Intent(MainActivity.this, firstscene.class);
                            i.putExtra("name", ed.getText().toString());
                            startActivity(i);
                        }
                        break;
                }
            }

        };
        but.setOnClickListener(listener);

    }

}





