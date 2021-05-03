package com.example.tp4_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private ArrayList<String> hours = new ArrayList<>();
    private ArrayList<String> book = new ArrayList<>();
    private Context mContext;
    private String mtable;
    private String mResto;

    public ScheduleAdapter(Context context, ArrayList<String> hours, ArrayList<String> book, String table,String resto) {
        this.hours = hours;
        this.book = book;
        this.mtable = table;
        this.mResto = resto;
        this.mContext = context;
    }

    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        ScheduleAdapter.ViewHolder holder = new ScheduleAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ScheduleAdapter.ViewHolder holder, final int position) {
        holder.hours.setText(hours.get(position));
        holder.book.setText(book.get(position));
        if(!holder.book.getText().equals("TAKEN")){
            holder.book.setBackgroundColor(Color.argb(255, 98, 235 , 64));
            holder.book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // ajoute reservation du compte de l'utilisarteur
                    Account account = ListAccounts.getInstance().getAccountInBuffer();
                     account.addReservation(new Reservations(mResto, hours.get(position),mtable));

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
    }

    @Override
    public int getItemCount() {
        return hours.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView hours;
        TextView book;

        public ViewHolder(View itemView) {
            super(itemView);
            hours = itemView.findViewById(R.id.hours);
            book = itemView.findViewById(R.id.book);
        }
    }
}
