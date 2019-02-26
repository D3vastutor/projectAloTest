package com.laptop.machtal.alotest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.laptop.machtal.alotest.Method.Gambar;
import com.laptop.machtal.alotest.R;

import java.util.List;

public class GambarAdapter extends RecyclerView.Adapter<GambarAdapter.GambarViewHolder> {

    private Context mCtx;
    private List<Gambar> listGambar;

    public GambarAdapter(Context mCtx, List<Gambar> listGambar) {
        this.mCtx = mCtx;
        this.listGambar = listGambar;
    }

    @NonNull
    @Override
    public GambarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_gambar, null);
        return new GambarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GambarViewHolder holder, int position) {
        Gambar gambar = listGambar.get(position);

        holder.gambar.setImageDrawable(mCtx.getResources().getDrawable(gambar.getImage()));
    }

    @Override
    public int getItemCount() {
        return listGambar.size();
    }

    class GambarViewHolder extends RecyclerView.ViewHolder{
        ImageView gambar;

        public GambarViewHolder(View itemView){
            super(itemView);

            gambar = itemView.findViewById(R.id.imgGambar);
        }
    }
}
