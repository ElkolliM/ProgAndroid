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

public class RestoAdapter  extends RecyclerView.Adapter<RestoAdapter.ViewHolder>{
    private ArrayList<String> restoNames = new ArrayList<>();
    private ArrayList<String> styles = new ArrayList<>();
    private ArrayList<String> prix = new ArrayList<>();
    private ArrayList<String> notes = new ArrayList<>();
    private Context mContext;

    public RestoAdapter(Context context, ArrayList<String> resto, ArrayList<String> notes, ArrayList<String> prix, ArrayList<String> styles) {
        this.restoNames = resto;
        this.styles = styles;
        this.prix = prix;
        this.notes = notes;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resto, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.coursName.setText(restoNames.get(position));
        holder.prix.setText(prix.get(position));
        holder.notes.setText(notes.get(position));
        holder.styles.setText(styles.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MenuActivity.class);
                intent.putExtra("resto_name", restoNames.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restoNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView coursName;
        TextView prix;
        TextView notes;
        TextView styles;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            coursName = itemView.findViewById(R.id.nom_resto);
            prix = itemView.findViewById(R.id.prix);
            notes = itemView.findViewById(R.id.note);
            styles = itemView.findViewById(R.id.style);
            parentLayout = itemView.findViewById(R.id.item_resto);
        }
    }
}
