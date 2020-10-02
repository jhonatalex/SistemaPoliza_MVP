package com.example.modulo_3examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.modulo_3examenfinal.Presenter.InterfacePresenter;
import com.example.modulo_3examenfinal.Presenter.Presenter;
import com.example.modulo_3examenfinal.Vista.InterfaceVista;

public class ActivityTransito extends AppCompatActivity implements InterfaceVista {

    public InterfacePresenter Ferrari;

    EditText Nombre,Rut,sueldo;
    Button Calcular,salir,nuevo;
    TextView Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transito);

       Nombre=findViewById(R.id.text_nombre);
       Rut=findViewById(R.id.txt_rut);
       sueldo=findViewById(R.id.text_sueldo);
       Total=findViewById(R.id.totalP);

       Calcular=findViewById(R.id.B_calcular);
       salir=findViewById(R.id.B_salir);
       nuevo=findViewById(R.id.B_nuevo);

       Ferrari= new Presenter(this);


       Calcular.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               double SueldoNeto=Double.parseDouble(sueldo.getText().toString());

             Ferrari.EnviarTransito(SueldoNeto);


           }
       });

       salir.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               finish();

           }
       });

       nuevo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            Nombre.setText("");
            sueldo.setText("");
            Rut.setText("");
            Total.setText("");
           }
       });


    }

    @Override
    public void MostrarResultado(double USD, double EUR) {

    }

    @Override
    public void MostrarTransito(double TotalMulta) {

        Total.setText(String.valueOf(TotalMulta));

    }

    @Override
    public void MostrarPoliza(double TotalPoliza) {

    }
}