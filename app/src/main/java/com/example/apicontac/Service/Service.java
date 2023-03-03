package com.example.apicontac.Service;

import com.example.apicontac.Models.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

@GET("users")
    Call<List<DataModel>> ListaOb();
}
