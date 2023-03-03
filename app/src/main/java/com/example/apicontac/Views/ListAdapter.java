package com.example.apicontac.Views;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.apicontac.Models.DataModel;
import com.example.apicontac.R;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<DataModel> dataModels;
    private List<DataModel> listbuscador;
    private LayoutInflater inflater;
    private Context context;


    public ListAdapter(List<DataModel> modelList, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.dataModels = modelList;
        listbuscador = new ArrayList<>();
        listbuscador.addAll(modelList);
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_contact, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.nombre = dataModels.get(position).getName();
        holder.usnombre = dataModels.get(position).getUsername();
        holder.correo = dataModels.get(position).getEmail();
        holder.telefono = dataModels.get(position).getPhone();
        holder.web = dataModels.get(position).getWebsite();

        holder.tvName.setText(holder.nombre);
        holder.tvUsername.setText(holder.usnombre);
        holder.tvEmail.setText(holder.correo);
        holder.tvPhone.setText(holder.telefono);
        holder.tvWebsite.setText(holder.web);

        holder.itemView.setOnClickListener(view -> {
            Intent i = new Intent(holder.itemView.getContext(), DetailUser.class);
            i.putExtra("street", dataModels.get(position).getAddress().getStreet());
            i.putExtra("suite", dataModels.get(position).getAddress().getSuite());
            i.putExtra("city", dataModels.get(position).getAddress().getCity());
            i.putExtra("zipc", dataModels.get(position).getAddress().getZipcode());
            i.putExtra("name", dataModels.get(position).getName().toUpperCase());
            holder.itemView.getContext().startActivity(i);
        });
    }


    public void filtrado(String buscador) {
        int longitud = buscador.length();
        if (longitud == 0) {
            dataModels.clear();
            dataModels.addAll(listbuscador);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<DataModel> collect = dataModels.stream()
                        .filter(dataModel -> dataModel.getName().toLowerCase().contains(buscador))
                        .collect(Collectors.toList());
                dataModels.clear();
                dataModels.addAll(collect);
            } else {
                dataModels.clear();
                for (DataModel dataModel : listbuscador) {
                    if (dataModel.getName().toLowerCase().contains(buscador)) {
                        dataModels.add(dataModel);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvUsername;
        TextView tvEmail;
        TextView tvPhone;
        TextView tvWebsite;
        String nombre;
        String usnombre;
        String correo;
        String telefono;
        String web;

        ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.Tvname);
            tvUsername = view.findViewById(R.id.Tvusername);
            tvEmail = view.findViewById(R.id.Tvemail);
            tvPhone = view.findViewById(R.id.Tvphone);
            tvWebsite = view.findViewById(R.id.Tvwebsite);
        }

    }

}
