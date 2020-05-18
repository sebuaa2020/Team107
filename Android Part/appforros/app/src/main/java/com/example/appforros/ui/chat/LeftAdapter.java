package com.example.appforros.ui.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appforros.R;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {
    private Context context;
    private List<String> list;

    public LeftAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public LeftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LeftViewHolder holder = new LeftViewHolder(LayoutInflater.from(
                context).inflate(R.layout.chat_left_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(LeftAdapter.LeftViewHolder holder, final int position) {
        holder.left_chat.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(int position) {
        list.add("test" + position);
        notifyItemInserted(position);
    }


    class LeftViewHolder extends RecyclerView.ViewHolder {
        TextView left_chat;
        public LeftViewHolder(View view) {
            super(view);
            left_chat = view.findViewById(R.id.left_mes);
        }
    }
}