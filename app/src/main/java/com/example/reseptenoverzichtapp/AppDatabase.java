package com.example.reseptenoverzichtapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Recept.class}, version = 7)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ReceptDAO receptDAO();

    private static AppDatabase instance;

    static synchronized AppDatabase getInstance(Context context){
        if(instance == null) {
            instance = create(context);

        }
        return instance;
    }
    private static AppDatabase create(final Context context){
        return Room.databaseBuilder(context,AppDatabase.class,"recepten").allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
}
