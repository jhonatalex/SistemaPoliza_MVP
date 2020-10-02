package com.example.modulo_3examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.modulo_3examenfinal.Presenter.InterfacePresenter;
import com.example.modulo_3examenfinal.Presenter.Presenter;
import com.example.modulo_3examenfinal.Vista.InterfaceVista;

import org.w3c.dom.Text;

import java.nio.file.FileVisitOption;

public class ActivitySeguro extends AppCompatActivity implements InterfaceVista {

    public InterfacePresenter Enviar;


     private EditText Propietario,ValorAuto,Accidentes;
     private Button CalcularButton,SalirButton,NuevoButton;
     private RadioButton Modelo_a,Modelo_b,Modelo_c,menor,medio,mayor;
     private TextView TOTALP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguro);

    Propietario=findViewById(R.id.text_propietario);
    ValorAuto=findViewById(R.id.txt_valorauto);
    Accidentes=findViewById(R.id.text_accidente);
    TOTALP=findViewById(R.id.totalP);

    CalcularButton=findViewById(R.id.s_calcular);
    SalirButton=findViewById(R.id.s_salir);
    NuevoButton=findViewById(R.id.s_nuevo);

    Modelo_a=findViewById(R.id.modeloA);
    Modelo_b=findViewById(R.id.modeloB);
    Modelo_c= findViewById(R.id.modeloC);

    menor=findViewById(R.id.menor);
    medio=findViewById(R.id.medio);
    mayor=findViewById(R.id.mayor);

    Enviar =new Presenter(this);



    CalcularButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            char Modelo=' ';
            int edad=0;
            double Precio= Double.parseDouble(ValorAuto.getText().toString());
            int siniestros= Integer.parseInt(Accidentes.getText().toString());

            if (Modelo_a.isChecked()) {
                Modelo='A';
            } else if (Modelo_b.isChecked()) {
                Modelo='B';
            } else if (Modelo_c.isChecked()) {
                Modelo='C';
            }

            if (menor.isChecked()) {
                edad=1;
            } else if (medio.isChecked()) {
                edad=2;
            } else if (mayor.isChecked()) {
                edad=3;
            }

            Enviar.CalcularSeguro(Precio,siniestros,Modelo,edad);


        }
    });

    NuevoButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Propietario.setText("");
            ValorAuto.setText("");
            Accidentes.setText("");
            TOTALP.setText("");
        }
    });

    SalirButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();

        }
    });



    }

    @Override
    public void MostrarResultado(double USD, double EUR) {

    }

    @Override
    public void MostrarTransito(double TotalMulta) {

    }

    @Override
    public void MostrarPoliza(double TotalPoliza) {

        TOTALP.setText(String.valueOf(TotalPoliza));

    }
}