package com.example.eventos.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.eventos.R;
import com.example.eventos.activity.InformationActivity;
import com.example.eventos.model.MovieResults;
import com.example.eventos.model.ResultsBean;

import java.io.Serializable;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<ResultsBean> mMovie;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<ResultsBean> mMovie) {
        this.mContext = mContext;
        this.mMovie = mMovie;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.movies_item_row, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();

                try {
                    Intent intent = new Intent(mContext, InformationActivity.class);
                    intent.putExtra("overview", mMovie.get(position).getOverview());
                    intent.putExtra("title", mMovie.get(position).getOriginalTitle());
                    intent.putExtra("image", mMovie.get(position).getPosterPath());
                    intent.putExtra("release_date", mMovie.get(position).getReleaseDate());
                    intent.putExtra("vote_average", mMovie.get(position).getVoteAverage());

                    List<MovieResults> list = mMovie.get(position).getMovieResults();
                    intent.putExtra("people", (Serializable) list);

                    mContext.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txt_title.setText(mMovie.get(position).getOriginalTitle());
        holder.txt_data_release.setText(mMovie.get(position).getReleaseDate());
        holder.txt_vote_average.setText(mMovie.get(position).getVoteAverage());

        // carregar a imagem da internet usando o glide
        Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500/" + mMovie.get(position).getPosterPath()).into(holder.img_poster_path);
    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_title, txt_data_release, txt_overview, txt_vote_average;
        ImageView img_poster_path;
        CardView view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_title = itemView.findViewById(R.id.titleid);
            txt_data_release = itemView.findViewById(R.id.data_releaseId);
            txt_overview = itemView.findViewById(R.id.overviewID);
            txt_vote_average = itemView.findViewById(R.id.vote_averageId);
            img_poster_path = itemView.findViewById(R.id.pictureId);
            view_container = itemView.findViewById(R.id.container);

        }
    }

}
