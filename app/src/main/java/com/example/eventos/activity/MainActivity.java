package com.example.eventos.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.eventos.R;
import com.example.eventos.adapter.RecyclerViewAdapter;
import com.example.eventos.credential.CredentialUrl;
import com.example.eventos.model.ResultsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<ResultsBean> movieList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerV);
        jsonrequest();
    }

    private void jsonrequest() {
        /*
        Request para pegar valores do json da api, e montar o objeto movies
         */

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, CredentialUrl.JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray jsonArray = null;

                try {
                    jsonArray = response.getJSONArray("results");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < jsonArray.length(); i++) {
                    ResultsBean moviesInformation = new ResultsBean();

                    try {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        moviesInformation.setVoteAverage(jsonObject.getString("vote_average"));
                        moviesInformation.setPopularity(jsonObject.getDouble("popularity"));
                        moviesInformation.setOverview(jsonObject.getString("overview"));
                        moviesInformation.setReleaseDate(jsonObject.getString("release_date"));
                        moviesInformation.setOriginalTitle(jsonObject.getString("original_title"));
                        moviesInformation.setPosterPath(jsonObject.getString("poster_path"));
                        moviesInformation.setTitle(jsonObject.getString("title"));
                        moviesInformation.setAdult(jsonObject.getBoolean("adult"));
                        moviesInformation.setBackdropPath(jsonObject.getString("backdrop_path"));
                        JSONArray genre_ids = jsonObject.getJSONArray("genre_ids");
                        for (int j = 0; j < genre_ids.length(); j++) {
                            //  genre_ids.get(j);
                           //Caso queria usar os valores de "genre_ids"
                        }
                        moviesInformation.setId(jsonObject.getInt("id"));
                        moviesInformation.setVideo(jsonObject.getBoolean("video"));
                        moviesInformation.setVoteCount(jsonObject.getInt("vote_count"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    movieList.add(moviesInformation);
                }

                setUpRecyclerview(movieList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Erro!" + error, Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setUpRecyclerview(List<ResultsBean> moviesList) {

        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this, moviesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(mAdapter);
    }


}