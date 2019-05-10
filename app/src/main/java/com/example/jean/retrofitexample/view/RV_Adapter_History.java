package com.example.jean.retrofitexample.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.History;
import com.example.jean.retrofitexample.model.HistoryItem;
import com.example.jean.retrofitexample.model.Player;

import java.util.ArrayList;
import java.util.List;

public class RV_Adapter_History extends RecyclerView.Adapter<RV_Adapter_History.MyViewHolder>   {

    private List<History> histories = new ArrayList<>();
    private Context mcontext;

    public RV_Adapter_History(Context context) {
        this.mcontext = context;
    }

    public void setdata(List<History> players) {
        this.histories = players;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new MyViewHolder(LayoutInflater.from(mcontext)
                .inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        final History mhistory = histories.get(position);
        myViewHolder.id.setText("Player Position  : " + mhistory.getPosisi());
        myViewHolder.nama.setText("Player Name      : " + mhistory.getNama());
        myViewHolder.umur.setText("Player Age      : " + mhistory.getAge());
        myViewHolder.team.setText("Player Age      : " + mhistory.getTeam());

        Glide.with(mcontext)
                .load(mhistory.getGambar())
                .into(myViewHolder.image);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast toast = Toast.makeText(mcontext, mhistory.getNama()+" "+mhistory.getAge(), Toast.LENGTH_SHORT);
//                toast.show();
//                Intent intent = new Intent(mcontext, HistoryActivity.class);
//                intent.putExtra("nama",mhistory.getNama());
//                intent.putExtra("list",historyItem);
//                intent.putParcelableArrayListExtra("history",historyItem);
                History history = histories.get(position);
                final ArrayList<HistoryItem> historyItem = new ArrayList<>();
                historyItem.addAll(history.getHistory());

                Bundle b = new Bundle();
                b.putParcelableArrayList("item",  historyItem);
                Intent i = new Intent(mcontext, HistoryActivity.class);
                i.putExtras(b);
                mcontext.startActivity(i);

            }
        }) ;
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView id, nama, umur,team;
        ImageView image;
//        private String gambar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id =(TextView) itemView.findViewById(R.id.tv_id);
            nama = (TextView)itemView.findViewById(R.id.tv_nama);
            umur = (TextView)itemView.findViewById(R.id.tv_umur);
            team = (TextView) itemView.findViewById(R.id.tv_team) ;
            image = (ImageView) itemView.findViewById(R.id.IV_gambar);

        }
    }


}
