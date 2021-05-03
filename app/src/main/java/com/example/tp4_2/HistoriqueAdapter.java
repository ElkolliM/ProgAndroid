package com.example.tp4_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class HistoriqueAdapter extends RecyclerView.Adapter<HistoriqueAdapter.ViewHolder> {

    private Context mContext;
    Account acc;
    public HistoriqueAdapter(Context context, Account acc) {
        this.acc = acc;
        this.mContext = context;
    }

    @Override
    public HistoriqueAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historique, parent, false);
        HistoriqueAdapter.ViewHolder holder = new HistoriqueAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(HistoriqueAdapter.ViewHolder holder, final int position) {
        holder.hours.setText(acc.getReservations().get(position).getDate());
        //holder.hours.setText(hours.get(position));
        holder.nameResto.setText(acc.getReservations().get(position).getNameResto());
        holder.table.setText(acc.getReservations().get(position).getTable());
        /*
        if(!holder.book.getText().equals("TAKEN")){
            holder.book.setBackgroundColor(Color.argb(255, 98, 235 , 64));
            holder.book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(mContext)
                            .setTitle(mContext.getString(R.string.reservation_done))
                            .setMessage(mContext.getString(R.string.reservation) + " " + mtable + " " + mContext.getString(R.string.restaurant) + " " + mResto + " " +  mContext.getString(R.string.done))
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(mContext, HomePage.class);
                                    mContext.startActivity(intent);
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            });
        }
        */
    }

    @Override
    public int getItemCount() {
        return acc.getReservations().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView hours;
        TextView table;
        TextView nameResto;

        public ViewHolder(View itemView) {
            super(itemView);
            hours = itemView.findViewById(R.id.txtView1);
            table = itemView.findViewById(R.id.txtView2);
            nameResto = itemView.findViewById(R.id.txtView3);
        }
    }
}
