package com.example.nouritshlocal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nouritshlocal.R;
import com.example.nouritshlocal.model.Community;

import java.util.ArrayList;

public class CommunityListAdapter extends BaseAdapter {
    ImageView ImageView;

    ArrayList<Community> dataList;
    Context context;
    public CommunityListAdapter(ArrayList<Community> list, Context c){
        dataList = list;
        context = c;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.comunity_list_view, parent , true);
        ImageView imageView =  rowView.findViewById(R.id.imageView);
        TextView titleTextView =  rowView.findViewById(R.id.titleTextView);
        imageView.setImageResource(dataList.get(position).getImageReference());
        titleTextView.setText(dataList.get(position).getName());
        return rowView;
    }
}
