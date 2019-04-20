package com.example.jean.retrofitexample.view;

import android.content.Context;
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
import com.example.jean.retrofitexample.model.Player;

import java.util.ArrayList;
import java.util.List;

public class RV_Adapter_History extends RecyclerView.Adapter<RV_Adapter_History.MyViewHolder> {

    private List<History> players = new ArrayList<>();
    private Context context;

    public RV_Adapter_History(Context context) {
        this.context = context;
    }

    public void setdata(List<History> players) {
        this.players = players;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        final History mhistory = players.get(position);
        myViewHolder.id.setText("Player Position  : " + mhistory.getPosisi());
        myViewHolder.nama.setText("Player Name      : " + mhistory.getNama());
        myViewHolder.umur.setText("Player Age      : " + mhistory.getAge());
        Glide.with(context)
                .load(mhistory.getGambar())
                .into(myViewHolder.image);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context, mhistory.getNama()+mhistory.getAge(), Toast.LENGTH_SHORT);
                toast.show();
            }
        })

        ;


    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView id, nama, umur,gambar;
        ImageView image;
//        private String gambar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id =(TextView) itemView.findViewById(R.id.tv_id);
            nama = (TextView)itemView.findViewById(R.id.tv_nama);
            umur = (TextView)itemView.findViewById(R.id.tv_umur);
            image = (ImageView) itemView.findViewById(R.id.IV_gambar);

        }
    }


}
