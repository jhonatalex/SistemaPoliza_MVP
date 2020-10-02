package com.example.modulo_3examenfinal;

import android.os.Bundle;

import com.example.modulo_3examenfinal.Presenter.InterfacePresenter;
import com.example.modulo_3examenfinal.Presenter.Presenter;
import com.example.modulo_3examenfinal.Vista.InterfaceVista;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ActivityDivisas extends AppCompatActivity implements InterfaceVista {

    public InterfacePresenter sendData;


    private EditText CLP;
    private TextView Rdolar,Reuro;
    private Button Convertir,nuevo,salir;
    private String String_clp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divisas_activity);


        CLP= findViewById(R.id.clp);
        Rdolar=findViewById(R.id.dolar);
        Reuro=findViewById(R.id.euro);
        Convertir= findViewById(R.id.convertir);
        nuevo=findViewById(R.id.nuevo);
        salir=findViewById(R.id.salir);

        sendData= new Presenter(this);

        Convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String_clp=CLP.getText().toString();

                //ENVIA DATOS AL PRESENTER
                sendData.EnviarDatos(String_clp);


            }
        });

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLP.setText("");
                Rdolar.setText("");
                Reuro.setText("");

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    @Override
    public void MostrarResultado(double USD, double EUR) {

        Rdolar.setText(String.valueOf(USD));
        Reuro.setText(String.valueOf(EUR));


    }

    @Override
    public void MostrarTransito(double TotalMulta) {

    }

    @Override
    public void MostrarPoliza(double TotalPoliza) {

    }
}