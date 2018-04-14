package com.niscalindo.simantan.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.model.Gardu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2/19/2018.
 */
public class GarduAdapter extends RecyclerView.Adapter<GarduAdapter.MyViewHolder> implements Filterable {
    private List<Gardu> listGardu;
    private List<Gardu> searchResult;
    private OnItemClickListener listener;
    private Context context;

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();


                if (charString.isEmpty()) {
                    searchResult = listGardu;
                } else {

                    ArrayList<Gardu> filteredList = new ArrayList<>();

                    for (Gardu gardu : listGardu) {

                        if (gardu.getNomorGardu().toLowerCase().contains(charString) || gardu.getAlamat().toLowerCase().contains(charString)) {
                            filteredList.add(gardu);
                        }
                    }

                    searchResult = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = searchResult;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                searchResult = (ArrayList<Gardu>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface OnItemClickListener{
        void onItemClick(Gardu item);
    }

    public GarduAdapter(List<Gardu> listGardu, OnItemClickListener listener){
        this.listGardu = listGardu;
        this.searchResult = listGardu;
        this.listener = listener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gardu,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(searchResult.get(position),listener);
        Gardu gardu = searchResult.get(position);


    }

    @Override
    public int getItemCount() {

        return searchResult.size();
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
    public void setContext(Context context){
        this.context = context;
    }

}
