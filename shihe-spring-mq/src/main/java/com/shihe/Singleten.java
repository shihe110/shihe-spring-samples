package com.shihe;

public class Singleten {
//    private static final Singleten = null;


    private Singleten() {
    }

    private static Singleten instance = new Singleten();

    public static Singleten getInstance(){
        return instance;
    }
}
