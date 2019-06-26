package com.kmj.sunrinstore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomGridAdapter extends RecyclerView.Adapter<CustomGridAdapter.CustomGridHolder>{
    MainActivity mainActivity;
    ArrayList<List_item> data;

    int layout;
    public CustomGridAdapter(MainActivity mainActivity, ArrayList<List_item> data, int layout) {
        this.mainActivity = mainActivity;
        this.data = data;
        this.layout = layout;
    }



    public class CustomGridHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView pic;
        TextView name;
        TextView price;
        int id;
        public CustomGridHolder(@NonNull View v) {
            super(v);
            this.pic=(ImageView) v.findViewById(R.id.grid_img);
            this.name=(TextView) v.findViewById(R.id.grid_name);
            this.price=(TextView)v.findViewById(R.id.grid_price);
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mainActivity, Item_info.class);

            intent.putExtra("product_img", this.id);
            intent.putExtra("product", name.getText().toString());
            intent.putExtra("price",price.getText().toString());
            mainActivity.startActivity(intent);
        }
    }
    @NonNull
    @Override
    public CustomGridHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_item, viewGroup, false);

        CustomGridHolder viewHolder = new CustomGridHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomGridHolder viewholder, int i) {
        List_item item=data.get(i);
        viewholder.pic.setImageResource(item.getProduct_img());
        viewholder.name.setText(item.getProduct());
        viewholder.price.setText(item.getPrice());
        viewholder.id=item.getProduct_img();
    }

    @Override
    public int getItemCount() {
        return ( null!= data ? data.size() : 0);
    }


}
