package com.example.apicontac.Models;


import android.util.Log;

import com.example.apicontac.Service.Service;
import com.example.apicontac.Presenter.IPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Modelimpl implements IModel {
    private IPresenter presenter;

    public Modelimpl(IPresenter iPresenter) {
        this.presenter = iPresenter;
    }

    @Override
    public void consult() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<List<DataModel>> call = service.ListaOb();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if (!response.isSuccessful()) {
                    Log.d("disconnected", "Sin Conexion");
                } else {
                    List<DataModel> showRes = response.body();
                    showConsult(showRes);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Log.d("Err", "Error");
            }
        });
    }

    @Override
    public void showConsult(List<DataModel> dataModels) {
        presenter.showConsult(dataModels);
    }
}
