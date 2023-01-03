package com.example.gmail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    List<ItemModel> items;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel item=items.get(position);
        holder.image.setBackgroundResource(item.getImage());
        holder.image.setText(String.valueOf(item.getName().charAt(0)));
        holder.name.setText(item.getName());
        holder.content.setText(item.getContent());
        holder.date.setText(item.getDate());
        holder.like.setChecked(item.isLike());
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setLike(holder.like.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView image;
        TextView name;
        TextView content;
        TextView date;
        CheckBox like;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            content=itemView.findViewById(R.id.content);
            date=itemView.findViewById(R.id.date);
            like=itemView.findViewById(R.id.like);
        }
    }
}
