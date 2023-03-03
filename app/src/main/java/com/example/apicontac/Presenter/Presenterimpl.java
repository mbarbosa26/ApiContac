package com.example.apicontac.Presenter;

import com.example.apicontac.Models.DataModel;
import com.example.apicontac.Models.IModel;
import com.example.apicontac.Models.Modelimpl;
import com.example.apicontac.Views.IView;

import java.util.List;

public class Presenterimpl implements IPresenter {

    private IView iView;
    private IModel model;

    public Presenterimpl(IView iView) {
        this.iView = iView;
        this.model = new Modelimpl(this);
    }

    @Override
    public void consult() {
        model.consult();
    }

    @Override
    public void showConsult(List<DataModel> dataModels) {
        iView.showConsult(dataModels);
    }
}
