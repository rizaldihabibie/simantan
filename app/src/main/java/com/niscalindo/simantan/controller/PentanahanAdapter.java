package com.niscalindo.simantan.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.model.Pentanahan;

import java.util.List;

/**
 * Created by USER on 4/4/2018.
 */
public class PentanahanAdapter  extends RecyclerView.Adapter<PentanahanAdapter.MyViewHolder>  {
    private List<Pentanahan> listPentanahan;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Pentanahan item);
    }

    public PentanahanAdapter(List<Pentanahan> listPentanahan, OnItemClickListener listener){
        this.listPentanahan = listPentanahan;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pentanahan,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(listPentanahan.get(position),listener);
        Pentanahan pentanahan = listPentanahan.get(position);


    }

    @Override
    public int getItemCount() {

        return listPentanahan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView garduNumber, garduAddress;

        public MyViewHolder(View view){
            super(view);
            garduNumber = (TextView) view.findViewById(R.id.number);
            garduAddress = (TextView) view.findViewById(R.id.address);
        }
        public void bind(final Pentanahan pentanahan, final OnItemClickListener listener){
            garduNumber.setText(pentanahan.getGardu().getNomorGardu());
            garduAddress.setText(pentanahan.getGardu().getAlamat());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(pentanahan);
                }
            });
        }

    }
}
