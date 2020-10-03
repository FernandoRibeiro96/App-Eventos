package com.example.eventos.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.eventos.R;
import com.example.eventos.activity.InformationActivity;
import com.example.eventos.model.Eventos;
import com.example.eventos.model.Pessoa;

import java.io.Serializable;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Eventos> mEvento;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Eventos> mEvento) {
        this.mContext = mContext;
        this.mEvento = mEvento;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.eventos_item_row, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();

                try{
                    Intent intent = new Intent(mContext, InformationActivity.class);
                    intent.putExtra("description",mEvento.get(position).getDescription());
                    intent.putExtra("title",mEvento.get(position).getTitle());
                    intent.putExtra("price", mEvento.get(position).getPrice());
                    intent.putExtra("image",mEvento.get(position).getImage());

                    List<Pessoa> list = mEvento.get(position).getPeople();
                    intent.putExtra("people", (Serializable) list);

                    mContext.startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txt_title.setText(mEvento.get(position).getTitle());
        holder.txt_price.setText(mEvento.get(position).getPrice());

        // carregar a imagem da internet usando o glide
        Glide.with(mContext).load(mEvento.get(position).getImage()).apply(option).into(holder.img_picture);

    }

    @Override
    public int getItemCount() {
        return mEvento.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_title;
        TextView txt_price;
        TextView txt_description;
        ImageView img_picture;
        CardView view_container;


        public MyViewHolder(View itemView){
            super(itemView);

            txt_title = itemView.findViewById(R.id.titleid);
            txt_price = itemView.findViewById(R.id.priceId);
            txt_description = itemView.findViewById(R.id.descricaoID);
            img_picture = itemView.findViewById(R.id.pictureId);
            view_container = itemView.findViewById(R.id.container);

        }
    }

    private void sendPeopleValuesExtras(Pessoa pessoa){

    }

}
