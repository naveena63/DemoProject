package com.demo.demoproject.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demo.demoproject.R;
import com.demo.demoproject.model.ListItemsResponseDataItem;

import java.util.List;

public class ListItemadapter extends RecyclerView.Adapter<ListItemadapter.MyviewHolder> {

    Context context;
    List<ListItemsResponseDataItem> list;

    public ListItemadapter(Context context, List<ListItemsResponseDataItem> list) {
        this.context = context;
        this.list = list;
    }

    public void setMovieList(List<ListItemsResponseDataItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ListItemadapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemadapter.MyviewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getAuthor().toString());

        Glide.with(context).load(list.get(position).getDownloadUrl()).apply(RequestOptions.centerCropTransform()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;

    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView image;

        public MyviewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.title_cardview);
            image = (ImageView) itemView.findViewById(R.id.iv_cover);
        }
    }
}