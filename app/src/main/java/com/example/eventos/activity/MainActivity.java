package com.example.eventos.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.eventos.R;
import com.example.eventos.adapter.RecyclerViewAdapter;
import com.example.eventos.model.Eventos;
import com.example.eventos.model.Pessoa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "http://5f5a8f24d44d640016169133.mockapi.io/api/events";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Eventos> eventosList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventosList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerV);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);
                        Eventos eventos = new Eventos();

                        eventos.setDescription(jsonObject.getString("description"));
                        eventos.setTitle(jsonObject.getString("title"));
                        eventos.setPrice(jsonObject.getString("price"));
                        eventos.setImage(jsonObject.getString("image"));

                        //pegando valores do json PESSOA
                        try {
                            eventos.setPeople(getPeopleJsonValues(jsonObject, eventos));
                        } catch (Exception e) {
                            Log.e("TAG", e.getMessage());
                        }

                        eventosList.add(eventos);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(eventosList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Erro!", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Eventos> eventosList) {

        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this, eventosList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(mAdapter);
    }

    private List<Pessoa> getPeopleJsonValues(JSONObject jsonObject, Eventos eventos) throws JSONException {
        JSONArray json = jsonObject.getJSONArray("people");
        List<Pessoa> list = new ArrayList<>();
        for (int i = 0; i < json.length(); i++) {
            String name = json.getJSONObject(i).getString("name");
            String picture = json.getJSONObject(i).getString("picture");
            int eventId = json.getJSONObject(i).getInt("eventId");
            int id = json.getJSONObject(i).getInt("id");

            Pessoa people = new Pessoa(picture, name, eventId, id);
            list.add(people);
        }
        return list;
    }
}