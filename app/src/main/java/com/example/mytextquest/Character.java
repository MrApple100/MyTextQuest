package com.example.mytextquest;

import android.widget.TextView;

//=======персонаж=======
public class Character {
    private int RPB=0;
    private int RPW=0;
    private int Subs=0;
    private String name;

    public Character(String name) {
        this.name = name;
    }

    public int getRPB() {
        return RPB;
    }

    public void setRPB(int RPB) {
        this.RPB = RPB;

    }

    public int getRPW() {
        return RPW;
    }

    public void setRPW(int RPW) {
        this.RPW = RPW;
    }


    public int getSubs() {
        return Subs;
    }

    public void setSubs(int subs) {
        Subs = subs;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+":" +
                "\nRPB=" + RPB +
                "\nRPW=" + RPW +
                "\nSubs=" + Subs;
    }
}

