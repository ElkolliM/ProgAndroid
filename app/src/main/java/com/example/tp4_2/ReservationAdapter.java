package com.example.tp4_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ViewHolder> {

    private ArrayList<String> tables = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();
    private String restoName;
    private Context mContext;



    public ReservationAdapter(Context context, ArrayList<String> tables, ArrayList<String> times, String restoName) {
        this.tables = tables;
        this.times = times;
        this.restoName = restoName;
        this.mContext = context;
    }

    @Override
    public ReservationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table, parent, false);
        ReservationAdapter.ViewHolder holder = new ReservationAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ReservationAdapter.ViewHolder holder, final int position) {
        holder.tables.setText(tables.get(position));
        holder.times.setText(times.get(position));
        if(holder.times.getText() != "FULL"){
            holder.times.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ScheduleActivity.class);
                    intent.putExtra("resto_name", restoName);
                    intent.putExtra("table", tables.get(position));
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tables;
        TextView times;

        public ViewHolder(View itemView) {
            super(itemView);
            tables = itemView.findViewById(R.id.table);
            times =  itemView.findViewById(R.id.seeTimes);

        }
    }
}
