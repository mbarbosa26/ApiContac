package com.example.apicontac.Views;

import com.example.apicontac.Models.DataModel;

import java.util.List;

public interface IView {

    void consult();

    void showConsult(List<DataModel> dataModels);
}
