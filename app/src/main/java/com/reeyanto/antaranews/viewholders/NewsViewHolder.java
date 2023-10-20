package com.reeyanto.antaranews.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.reeyanto.antaranews.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivThumbnail;
    public TextView tvTitle, tvPubdate, tvDescription;
    public CardView cvNews;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        ivThumbnail     = itemView.findViewById(R.id.iv_thumbnail);
        tvTitle         = itemView.findViewById(R.id.tv_title);
        tvPubdate       = itemView.findViewById(R.id.tv_pubdate);
        tvDescription   = itemView.findViewById(R.id.tv_description);
        cvNews          = itemView.findViewById(R.id.cv_news);
    }
}
