package com.example.eventos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.eventos.R;
import com.example.eventos.model.Pessoa;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ParticipantsViewHolder> {

    Context context;
    List<Pessoa> pessoaContacts;
    RequestOptions option;

    public ParticipantsAdapter(Context context, List<Pessoa> rankingContacts) {
        this.context = context;
        this.pessoaContacts = rankingContacts;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
    }

    @NonNull
    @Override
    public ParticipantsAdapter.ParticipantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_item, parent, false);
        return new ParticipantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantsAdapter.ParticipantsViewHolder holder, int position) {
        try {
            holder.name_pessoa.setText(pessoaContacts.get(position).getName());
            Glide.with(context).load(pessoaContacts.get(position).getPicture()).apply(option).into(holder.image_pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return pessoaContacts.size();
    }

    public class ParticipantsViewHolder extends RecyclerView.ViewHolder {

        TextView name_pessoa;
        CircleImageView image_pessoa;

        public ParticipantsViewHolder(@NonNull View itemView) {
            super(itemView);

            name_pessoa = itemView.findViewById(R.id.name_ranking);
            image_pessoa = itemView.findViewById(R.id.image_ranking);
        }
    }
}
