package com.example.reseptenoverzichtapp;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recept {

    @ColumnInfo
    private String gerecht;
    @ColumnInfo
    private String ingredients;
    @ColumnInfo
    private String description;
    //@ColumnInfo
   // private boolean favo;

    @PrimaryKey
    private int id;

    public Recept (String gerecht, String ingredients, String description, int id){
        this.gerecht = gerecht;
        this.ingredients = ingredients;
        this.description = description;
        this.id = id;
       // this.favo = favo;
    }

  /*  public Recept (JSONObject object) throws JSONException {
        this.gerecht = object.getString("name");
        this.ingredients = object.getString("ingredients");
        this.description = object.getString("discription");
    }*/

    public String getGerecht(){
        return this.gerecht;
    }

    public String getIngredients(){
        return this.ingredients;
    }

    public String getDescription(){
        return this.description;
    }
    public int getId(){
        return this.id;
    }

    /*public boolean getFavo(){
        return this.favo;
    }*/

}
