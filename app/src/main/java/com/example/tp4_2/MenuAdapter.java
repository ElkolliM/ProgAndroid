package com.example.tp4_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<String> type = new ArrayList<>();
    private ArrayList<String> item1 = new ArrayList<>();
    private ArrayList<String> item2 = new ArrayList<>();
    private ArrayList<String> item3 = new ArrayList<>();
    private ArrayList<String> item1Price = new ArrayList<>();
    private ArrayList<String> item2Price = new ArrayList<>();
    private ArrayList<String> item3Price = new ArrayList<>();
    private Context mContext;

    public MenuAdapter(Context context, ArrayList<String> type, ArrayList<String> item1, ArrayList<String> item2, ArrayList<String> item3, ArrayList<String> item1Price, ArrayList<String> item2Price, ArrayList<String> item3Price) {
        this.type = type;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item1Price = item1Price;
        this.item2Price = item2Price;
        this.item3Price = item3Price;
        this.mContext = context;
    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        MenuAdapter.ViewHolder holder = new MenuAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MenuAdapter.ViewHolder holder, final int position) {
        holder.type.setText(type.get(position));
        holder.item1.setText(item1.get(position));
        holder.item2.setText(item2.get(position));
        holder.item3.setText(item3.get(position));
        holder.item1Price.setText(item1Price.get(position));
        holder.item2Price.setText(item2Price.get(position));
        holder.item3Price.setText(item3Price.get(position));
    }

    @Override
    public int getItemCount() {
        return type.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView type;
        TextView item1;
        TextView item2;
        TextView item3;
        TextView item1Price;
        TextView item2Price;
        TextView item3Price;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            item1 = itemView.findViewById(R.id.item1);
            item2 = itemView.findViewById(R.id.item2);
            item3 = itemView.findViewById(R.id.item3);
            item1Price = itemView.findViewById(R.id.item1Price);
            item2Price = itemView.findViewById(R.id.item2Price);
            item3Price = itemView.findViewById(R.id.item3Price);
            parentLayout = itemView.findViewById(R.id.item_resto);
        }
    }
}
