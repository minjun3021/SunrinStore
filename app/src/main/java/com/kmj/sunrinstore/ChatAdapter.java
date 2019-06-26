package com.kmj.sunrinstore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    ArrayList<ChatModel> mData;

    public ChatAdapter(ArrayList<ChatModel> mData) {
        this.mData = mData;
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView content;
        public ChatViewHolder(@NonNull View v) {
            super(v);
            this.name=v.findViewById(R.id.chat_name);
            this.content=v.findViewById(R.id.chat_content);
        }
    }
    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.chat_item, viewGroup, false);

        ChatAdapter.ChatViewHolder viewHolder = new ChatAdapter.ChatViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder vh, int i) {
        vh.name.setText(mData.get(i).getName());
        vh.content.setText(mData.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return (null != mData ? mData.size() : 0);
    }


}
