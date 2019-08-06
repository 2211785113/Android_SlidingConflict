package com.example.ruru.android_slidingconflictdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruru.android_slidingconflictdemo.R;

import java.util.List;

public class SubRvAdapter extends RecyclerView.Adapter<SubRvAdapter.MyViewHolder> {

    private Context context;
    private List<String> list;
    private final LayoutInflater inflater;

    public SubRvAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv);

        }
    }
}
