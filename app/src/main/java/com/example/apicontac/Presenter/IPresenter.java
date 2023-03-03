package com.example.apicontac.Presenter;

import com.example.apicontac.Models.DataModel;

import java.util.List;

public interface IPresenter {

    void consult();

    void showConsult(List<DataModel> dataModels);
}
