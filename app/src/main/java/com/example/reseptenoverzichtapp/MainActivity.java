package com.example.reseptenoverzichtapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();

        final Recept[] recepten = new Recept[13];
        recepten[0] = new Recept("pasta carbo", "pasta, saus, etc", "Kook het water met je hoofd", 1);
        recepten[1] = new Recept("pasta rood", "pasta, saus, etc", "Kook het water met je hoofd", 2);
        recepten[2] = new Recept("pasta pesto", "pasta, saus, etc", "Kook het water met je hoofd", 3);
        recepten[3] = new Recept("pasta zalm", "pasta, saus, etc", "Kook het water met je hoofd",4);
        recepten[4] = new Recept("pasta student", "pasta, saus, etc", "Kook het water met je hoofd",5);


        RequestQueue queue = VolleySingleton.getInstance(this.getApplicationContext())
                .getRequestQueue();
        JsonArrayRequest jsonArReq = new JsonArrayRequest(Request.Method.GET, "http://104.248.92.163/api/recepten", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("kandiehemvinden", String.valueOf(response));
                for(int i = 0; i < response.length(); i++) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = response.getJSONObject(i);
                        int a = i + 6;
                        int b = i + 5;
                        recepten[b] = new Recept(jsonObject.getString("name"), jsonObject.getString("ingredients"), "hallo", a);
                        Log.d("idis", String.valueOf(a));
                        recyclerViewAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.d("zinnen", jsonObject.toString());


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("gefaald", error.getMessage());
            }
        });

        VolleySingleton.getInstance(this).addToRequestQueue(jsonArReq);



        // final String URL = "http://104.248.92.163/api/recepten";

        //queue.add(stringRequest);
        recyclerViewAdapter = new ReceptAdapter(recepten);
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}