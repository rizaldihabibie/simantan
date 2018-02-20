package com.niscalindo.simantan.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.model.Gardu;

import java.util.List;

/**
 * Created by USER on 2/19/2018.
 */
public class GarduAdapter extends RecyclerView.Adapter<GarduAdapter.MyViewHolder> {
    private List<Gardu> listGardu;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Gardu item);
    }

    public GarduAdapter(List<Gardu> listGardu, OnItemClickListener listener){
        this.listGardu = listGardu;
        this.listener = listener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gardu,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(listGardu.get(position),listener);
        Gardu gardu = listGardu.get(position);


    }

    @Override
    public int getItemCount() {

        return listGardu.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView garduNumber, garduAddress;

        public MyViewHolder(View view){
            super(view);
            garduNumber = (TextView) view.findViewById(R.id.number);
            garduAddress = (TextView) view.findViewById(R.id.address);
        }
        public void bind(final Gardu gardu, final OnItemClickListener listener){
            garduNumber.setText(gardu.getNomorGardu());
            garduAddress.setText(gardu.getAlamat());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(gardu);
                }
            });
        }

    }


}
