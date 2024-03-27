package com.example.asm51.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import com.example.asm51.R;
import com.example.asm51.models.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    List<News> listNews;
    OnItemClickListener listener;

    public NewsAdapter(List<News> listNews, OnItemClickListener listener) {
        this.listNews = listNews;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewProduct = LayoutInflater.from( parent.getContext()).inflate(R.layout.items_news, parent, false);
        return new ViewHolder(viewProduct);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News p = listNews.get(position);
        holder.txtName.setText(p.getTitle());
        if(p.getImage().startsWith("https://"))
        {
            Glide.with(holder.imgView.getContext()).load(p.getImage()).into(holder.imgView);
        }
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgProduct);
            txtName = (TextView)   itemView.findViewById(R.id.txtName);

            itemView.setOnClickListener(v -> {
                if(listener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        String url = listNews.get(position).getLink();
                        listener.onItemClick(url);
                    }
                }
            });
        }
    }
}
