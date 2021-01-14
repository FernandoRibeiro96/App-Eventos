package com.example.eventos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eventos.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class InformationActivity extends AppCompatActivity {

    String title, poster_path, overview, release_data, vote_average;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao);

        //esconder a barra de ações
        getSupportActionBar().hide();

        collapseToolbar();

        TextView tv_overview = findViewById(R.id.overviewID);
        ImageView im_image = findViewById(R.id.pp_pictureId);
        TextView tv_title = findViewById(R.id.tttleId);
        TextView tv_dataRelease = findViewById(R.id.ddata_release);
        TextView tv_voteAverage = findViewById(R.id.vvote_averageId);

        overview = getIntent().getExtras().getString("overview");
        title = getIntent().getExtras().getString("title");
        poster_path = getIntent().getExtras().getString("image");
        release_data = getIntent().getExtras().getString("release_date");
        vote_average = getIntent().getExtras().getString("vote_average");

        tv_overview.setText(overview);
        tv_title.setText(title);
        tv_dataRelease.setText(release_data);
        tv_voteAverage.setText(vote_average);


        //setar a imagem usando o glide
        Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + poster_path).into(im_image);
    }

    private void collapseToolbar() {
        //iniciar as views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsinId);
        collapsingToolbarLayout.setTitleEnabled(true);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getApplicationContext().getResources().getColor(R.color.white));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getApplicationContext().getResources().getColor(R.color.white));
    }

}