package com.example.apicontac.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.example.apicontac.Models.DataModel;
import com.example.apicontac.Presenter.IPresenter;
import com.example.apicontac.Presenter.Presenterimpl;
import com.example.apicontac.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView, SearchView.OnQueryTextListener {

    IPresenter iPresenter;
    ListAdapter listAdapter;
    RecyclerView recyclerView;
    SearchView buscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iPresenter = new Presenterimpl(this);
        recyclerView = findViewById(R.id.recycler);
        buscador = findViewById(R.id.buscador);
        buscador.setOnQueryTextListener(this);

        consult();

    }

    @Override
    public void consult() {
        iPresenter.consult();
    }

    @Override
    public void showConsult(List<DataModel> dataModels) {
        listAdapter = new ListAdapter(dataModels, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filtrado(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filtrado(newText);
        return false;
    }
}