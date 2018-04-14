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
import com.niscalindo.simantan.database.model.Pentanahan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 4/4/2018.
 */
public class PentanahanAdapter  extends RecyclerView.Adapter<PentanahanAdapter.MyViewHolder> implements Filterable {
    private List<Pentanahan> listPentanahan;
    private List<Pentanahan> searchResult;
    private OnItemClickListener listener;
    private Context context;

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();


                if (charString.isEmpty()) {
                    searchResult = listPentanahan;
                } else {

                    ArrayList<Pentanahan> filteredList = new ArrayList<>();

                    for (Pentanahan pentanahan : listPentanahan) {

                        if (pentanahan.getGardu().getNomorGardu().toLowerCase().contains(charString) || pentanahan.getGardu().getAlamat().toLowerCase().contains(charString)) {
                            filteredList.add(pentanahan);
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
                searchResult = (ArrayList<Pentanahan>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface OnItemClickListener{
        void onItemClick(Pentanahan item);
    }

    public PentanahanAdapter(List<Pentanahan> listPentanahan, OnItemClickListener listener){
        this.listPentanahan = listPentanahan;
        this.searchResult = listPentanahan;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pentanahan,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(searchResult.get(position),listener);
        Pentanahan pentanahan = searchResult.get(position);


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

    public void setContext(Context context){
        this.context = context;
    }
}
