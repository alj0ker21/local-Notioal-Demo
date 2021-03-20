package com.example.nouritshlocal.adapter;

import android.content.Context;
import android.util.Log;
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

public class CommunityRecyclerViewAdapter extends RecyclerView.Adapter<CommunityRecyclerViewAdapter.ViewHolder> {

    ArrayList<Community> dataList;
    Context context;
    /** ------------------------------------------------------------------------------------------
     * @param  list used to pass list array list to adapter
     * @param context  used to get current context for ex: main activity
     *  ------------------------------------------------------------------------------------------
     * */

    public  CommunityRecyclerViewAdapter(ArrayList<Community> list , Context context) {
        dataList = list;
        this.context = context;
    }
    /** ------------------------------------------------------------------------------------------ */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comunity_list_view, parent, false);
        return new ViewHolder(v, context, dataList);
    }

    /** ------------------------------------------------------------------------------------------ */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titleView.setText(dataList.get(position).getName());
        holder.imageView.setImageResource(dataList.get(position).getImageReference());
        // you cant do on click listener here
    }

    /** ------------------------------------------------------------------------------------------ */

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    /** ------------------------------------------------------------------------------------------ */

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView  titleView;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView, Context context, ArrayList<Community> list) {
            super(itemView);
            titleView = itemView.findViewById(R.id.community_title);
            imageView = itemView.findViewById(R.id.community_img);
            // the correct place to do on click listener in your case
            itemView.setOnClickListener(view -> {
                ((MainActivity) context).openDetails(list.get(getAdapterPosition()));
            });
        }

    }
    /** ------------------------------------------------------------------------------------------ */

}
