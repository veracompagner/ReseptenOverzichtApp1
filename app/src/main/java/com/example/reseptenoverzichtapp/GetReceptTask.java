package com.example.reseptenoverzichtapp;

import android.util.Log;

public class GetReceptTask implements Runnable {

    AppDatabase db;

    public  GetReceptTask(AppDatabase db){
        this.db = db;
    }

    @Override
    public void run(){
        String gerecht = db.receptDAO().getAll().get(0).getGerecht();
        Log.d("getRecpetTask", gerecht);
    }
}
