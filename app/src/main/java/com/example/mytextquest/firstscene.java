package com.example.mytextquest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class firstscene extends AppCompatActivity {
    //Create hero and story
    private static Character hackerman;
    private static Story story;
    private static int i=0;
    private DelayedPrinter.Word word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Initialize elements
        TextView NM = ((TextView) findViewById(R.id.name));
        TextView RPB = ((TextView) findViewById(R.id.rpblack));
        TextView RPW = ((TextView) findViewById(R.id.rpwhite));
        TextView SBs = ((TextView) findViewById(R.id.subsibes));

        String name = getIntent().getStringExtra("name");
        hackerman = new Character(name);
        //full up
        NM.setText(getString(R.string.hakerman) + hackerman.getName());
        RPB.setText(getString(R.string.repBlack) + hackerman.getRPB());
        RPW.setText(getString(R.string.repWhite) + hackerman.getRPW());
        SBs.setText(getString(R.string.Subsribes) + hackerman.getSubs());

      story = new Story();

        //Main part
            TextView MainText=((TextView) findViewById(R.id.text2));
            TextView First=((TextView) findViewById(R.id.first));
            TextView Second=((TextView) findViewById(R.id.second));
            TextView Third=((TextView) findViewById(R.id.third));

            hackerman.setRPB(story.current_situation.dRPB);
            hackerman.setRPW(story.current_situation.dRPW);
            hackerman.setSubs(story.current_situation.dSubs);
            MainText.setText("");
            word = new DelayedPrinter.Word(30,story.current_situation.text);
            word.setOffset(10);
            DelayedPrinter.printText(word, MainText);
            //Click
                View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = v.getId();

                        switch (id) {
                            //left
                            case R.id.first:
                                if(story.current_situation.variants>=1){
                                    story.go(2);
                                    MainText.setText("");
                                    word = new DelayedPrinter.Word(10,story.current_situation.text);
                                    word.setOffset(5);
                                    DelayedPrinter.printText(word, MainText);
                                    hackerman.setRPB(hackerman.getRPB()+story.current_situation.dRPB);
                                    hackerman.setRPW(hackerman.getRPW()+story.current_situation.dRPW);
                                    hackerman.setSubs(hackerman.getSubs()+story.current_situation.dSubs);
                                }
                                break;
                                //right
                            case R.id.second:
                                if(story.current_situation.variants>=2){
                                    story.go(3);
                                    MainText.setText("");
                                    word = new DelayedPrinter.Word(10,story.current_situation.text);
                                    word.setOffset(5);
                                    DelayedPrinter.printText(word, MainText);
                                    hackerman.setRPB(hackerman.getRPB()+story.current_situation.dRPB);
                                    hackerman.setRPW(hackerman.getRPW()+story.current_situation.dRPW);
                                    hackerman.setSubs(hackerman.getSubs()+story.current_situation.dSubs);
                                }
                                break;
                                //down
                            case R.id.third:
                                if(story.current_situation.variants==3){
                                    story.go(4);
                                    MainText.setText("");
                                    word = new DelayedPrinter.Word(10,story.current_situation.text);
                                    word.setOffset(5);
                                    DelayedPrinter.printText(word, MainText);
                                    hackerman.setRPB(hackerman.getRPB()+story.current_situation.dRPB);
                                    hackerman.setRPW(hackerman.getRPW()+story.current_situation.dRPW);
                                    hackerman.setSubs(hackerman.getSubs()+story.current_situation.dSubs);
                                }
                                break;
                                //mainscreen
                            case R.id.text2:
                                if(story.current_situation.variants==0){
                                    story.go(1);
                                    if(story.current_situation.subject.equals("END1.2")){
                                        Intent i=new Intent(firstscene.this, Endscene.class);
                                        i.putExtra("result",hackerman.toString());
                                        startActivity(i);
                                    }else {
                                        MainText.setText("");
                                        word = new DelayedPrinter.Word(10, story.current_situation.text);
                                        word.setOffset(5);
                                        DelayedPrinter.printText(word, MainText);
                                    }
                                }

                                break;
                        }

                        //update info on screen
                        RPB.setText(getString(R.string.repBlack) + hackerman.getRPB());

                        RPW.setText(getString(R.string.repWhite) + hackerman.getRPW());

                        SBs.setText(getString(R.string.Subsribes) + hackerman.getSubs());


                    }
                };

                MainText.setOnClickListener(listener);
                First.setOnClickListener(listener);
                Second.setOnClickListener(listener);
                Third.setOnClickListener(listener);



    }

}



