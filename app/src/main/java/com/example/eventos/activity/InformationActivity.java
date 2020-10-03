package com.example.eventos.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cocosw.bottomsheet.BottomSheet;
import com.example.eventos.R;
import com.example.eventos.adapter.ParticipantsAdapter;
import com.example.eventos.model.Pessoa;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    String title, image, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao);

        //esconder a barra de ações
        getSupportActionBar().hide();

        collapseToolbar();

        TextView tv_description = findViewById(R.id.descricaoID);
        ImageView im_image = findViewById(R.id.pp_pictureId);

        BottomNavigationView navigationView = findViewById(R.id.navigationView);

        description = getIntent().getExtras().getString("description");
        title = getIntent().getExtras().getString("title");
        image = getIntent().getExtras().getString("image");

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        getJsonValues();
                        break;
                    case R.id.navigation_share:
                        showBottomSheet();
                        break;
                    case R.id.navigation_check_in:
                        Toast.makeText(InformationActivity.this, "Check-in", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        tv_description.setText(description);

        //setar a imagem usando o glide
        Glide.with(this).load(image).into(im_image);
    }

    private void getJsonValues(){
        //receber dados
        List<Pessoa> list = (List<Pessoa>) getIntent().getSerializableExtra("people");
        if(list.size() == 0){
            Toast.makeText(this, "Não existe participantes neste evento!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(getApplicationContext(), Participants.class);
            intent.putExtra("people", (Serializable) list);
            startActivity(intent);
            finish();
        }
    }

    private void collapseToolbar(){
        //iniciar as views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsinId);
        collapsingToolbarLayout.setTitleEnabled(true);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getApplicationContext().getResources().getColor(R.color.white));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getApplicationContext().getResources().getColor(R.color.white));
    }

    private void showBottomSheet(){
        new BottomSheet.Builder(this).title("Compartilhar").sheet(R.menu.list).listener(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case R.id.facebook:
                        Toast.makeText(InformationActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.twitter:
                        Toast.makeText(InformationActivity.this, "Twitter", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.gmail:
                        Toast.makeText(InformationActivity.this, "Gmail", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.instagram:
                        Toast.makeText(InformationActivity.this, "Instagram", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }).show();
    }

}