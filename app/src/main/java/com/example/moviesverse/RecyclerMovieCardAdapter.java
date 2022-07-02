package com.example.moviesverse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesverse.model.MovieCardModel;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RecyclerMovieCardAdapter extends RecyclerView.Adapter<RecyclerMovieCardAdapter.ViewHolder> {

    Context context;
    ArrayList<MovieCardModel> arrMovies;

    private OnNoteListner mOnNoteListener;

    RecyclerMovieCardAdapter(Context context, ArrayList<MovieCardModel> arrMovies,OnNoteListner mOnNoteListener){
        this.context = context;
        this.arrMovies = arrMovies;
        this.mOnNoteListener = mOnNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.movie_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(v,mOnNoteListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            Picasso.get().load(arrMovies.get(position).img).into(holder.posterImage);
            holder.title.setText(arrMovies.get(position).title);
            holder.ratingTv.setText(arrMovies.get(position).rating+" IMDB");
            holder.releaseDateTv.setText("Release Date: "+arrMovies.get(position).releaseDate);
            holder.popularityTv.setText("Popularity: "+arrMovies.get(position).popularity);

    }

    @Override
    public int getItemCount() {
        return arrMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView posterImage;
        TextView title,ratingTv,releaseDateTv,popularityTv;

        OnNoteListner onNoteListner;

        public ViewHolder(@NonNull View itemView,OnNoteListner onNoteListner){
            super(itemView);

            posterImage = itemView.findViewById(R.id.posterImage);
            title = itemView.findViewById(R.id.title);
            ratingTv = itemView.findViewById(R.id.ratingTv);
            releaseDateTv = itemView.findViewById(R.id.releaseDateTv);
            popularityTv = itemView.findViewById(R.id.popularityTv);

            this.onNoteListner = onNoteListner;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onNoteListner.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListner{
        void onNoteClick(int position);
    }

}
