package com.reeyanto.antaranews.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.reeyanto.antaranews.R;
import com.reeyanto.antaranews.models.Post;
import com.reeyanto.antaranews.viewholders.NewsViewHolder;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Post> posts;

    public NewsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsViewHolder viewHolder = (NewsViewHolder) holder;

        viewHolder.tvTitle.setText(posts.get(position).getTitle());
        viewHolder.tvPubdate.setText(posts.get(position).getPubDate());
        viewHolder.tvDescription.setText(posts.get(position).getDescription());
        Glide.with(context).load(posts.get(position).getThumbnail()).into(viewHolder.ivThumbnail);

        viewHolder.cvNews.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setData(Uri.parse(posts.get(position).getLink()));
            intent.setAction(Intent.ACTION_VIEW);

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
