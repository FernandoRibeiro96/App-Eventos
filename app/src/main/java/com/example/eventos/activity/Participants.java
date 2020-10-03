package com.example.eventos.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventos.R;
import com.example.eventos.adapter.ParticipantsAdapter;
import com.example.eventos.model.Pessoa;
import java.util.List;

public class Participants extends AppCompatActivity {

    List<Pessoa> listPessoa;
    RecyclerView recyclerView;
    ParticipantsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);

        recyclerView = findViewById(R.id.recycler_ranking);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listPessoa = (List<Pessoa>) getIntent().getSerializableExtra("people");

        if(listPessoa == null){
            Toast.makeText(this, "asdasd", Toast.LENGTH_SHORT).show();
        }

        adapter = new ParticipantsAdapter(this, listPessoa);
        recyclerView.setAdapter(adapter);
    }
}
