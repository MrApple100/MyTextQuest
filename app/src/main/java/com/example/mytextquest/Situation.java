package com.example.mytextquest;

//=======ситуация=======
public class Situation {
    Situation[] direction;
    String subject,text;
    int dRPB,dRPW,dSubs;
    int variants;
    public Situation (String subject, String text, int variants, int dRPB,int dRPW,int dSubs) {
        this.subject=subject;
        this.text=text;
        this.dRPB=dRPB;
        this.dRPW=dRPW;
        this.dSubs=dSubs;
        this.variants=variants;
        direction=new Situation[variants+1];
    }





}

