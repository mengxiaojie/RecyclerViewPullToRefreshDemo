package com.ys100.recyclerviewpulltorefreshdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by MengJie on 2016/8/31.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {

    private Context mContext;
    private ArrayList<String> strs = new ArrayList<>();

    public RecyclerViewAdapter(Context mContext,ArrayList<String> strs) {
        this.mContext = mContext;
        this.strs = strs;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return strs.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
