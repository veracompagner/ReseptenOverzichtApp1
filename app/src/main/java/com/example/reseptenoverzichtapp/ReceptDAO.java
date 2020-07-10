package com.example.reseptenoverzichtapp;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReceptDAO {

    @Query("SELECT * FROM recept")
    List<Recept> getAll();

    @Insert
    void InsertRecept(Recept recept);

    @Delete
    void delete(Recept recept);
}
