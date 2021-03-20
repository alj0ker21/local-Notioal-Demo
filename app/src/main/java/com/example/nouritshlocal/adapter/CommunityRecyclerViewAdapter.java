package com.example.nouritshlocal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nouritshlocal.MainActivity;
import com.example.nouritshlocal.R;
import com.example.nouritshlocal.model.Community;

import java.util.ArrayList;

public class CommunityRecyclerViewAdapter extends RecyclerView.Adapter {

    ArrayList<Community> dataList;
    Context context;

    public  CommunityRecyclerViewAdapter(ArrayList<Community> list , Context context){
        dataList = list;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comunity_list_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).titleView.setText(dataList.get(position).getName());
        ((ViewHolder) holder).imageView.setImageResource(dataList.get(position).getImageReference());
        final int index = holder.getAdapterPosition();
        ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).openDetails(dataList.get(index));
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView  titleView;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            titleView = itemView.findViewById(R.id.titleTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
