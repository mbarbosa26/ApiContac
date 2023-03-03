package com.example.apicontac.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.apicontac.R;

public class DetailUser extends AppCompatActivity {

    TextView calle;
    TextView suite;
    TextView ciudad;
    TextView codigoP;
    TextView nombre;
    Bundle bStreet;
    Bundle bSuite;
    Bundle bCity;
    Bundle bCode;
    Bundle bName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        calle = findViewById(R.id.calle);
        suite = findViewById(R.id.suite);
        ciudad = findViewById(R.id.ciudad);
        codigoP = findViewById(R.id.codigop);
        nombre = findViewById(R.id.name);

        //obtenemos lo datos del putExtra con bundle
        bStreet = getIntent().getExtras();
        bSuite = getIntent().getExtras();
        bCity = getIntent().getExtras();
        bCode = getIntent().getExtras();
        bName = getIntent().getExtras();

        String obCalle = bStreet.getString("street");
        String obSuite = bSuite.getString("suite");
        String obCiudad = bCity.getString("city");
        String obCodigo = bCode.getString("zipc");
        String obName = bName.getString("name");

        //le seteamos los valores
        calle.setText(obCalle);
        suite.setText(obSuite);
        ciudad.setText(obCiudad);
        codigoP.setText(obCodigo);
        nombre.setText(obName);

    }
}