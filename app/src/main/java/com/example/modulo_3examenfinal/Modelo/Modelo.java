package com.example.modulo_3examenfinal.Modelo;

import com.example.modulo_3examenfinal.Presenter.InterfacePresenter;

public class Modelo implements InterfaceModelo{

    public double CLPVALOR,USD,EUR;
    public double TotalPoliza;

    InterfacePresenter Resultado;
    public Modelo(InterfacePresenter resultado) {
        Resultado = resultado;
    }



    @Override
    public void EnviarDatos(String CLP) {

        CLPVALOR=Double.parseDouble(CLP);

        USD=(0.0013)*CLPVALOR;
        EUR=(0.0011)*CLPVALOR;

        Resultado.MostrarResultado(USD,EUR);

    }

    @Override
    public void EnviarTransito(double SueldoNeto) {
        Double TotalMulta=SueldoNeto*0.10;
        Resultado.MostrarTransito(TotalMulta);

    }

    @Override
    public void CalcularSeguro(double Precio, int siniestros, char Modelo, int edad) {

        double CargoModelo=0;
        double CargoEdad=0;
        double  CargosSiniestros=0;

      switch (Modelo){
          case 'A': CargoModelo= Precio*0.011; break;
          case 'B': CargoModelo= Precio*0.012; break;
          case 'C': CargoModelo= Precio*0.015; break;
      }

        switch (edad){
            case 1: CargoEdad= 36000; break;
            case 2: CargoEdad= 24000; break;
            case 3: CargoEdad= 43000; break;

        }

        if(siniestros<=3){
            CargosSiniestros=17000;
        }else{
            CargosSiniestros=21000;
        }

        TotalPoliza= (Precio*0.035)+CargoModelo+CargoEdad+CargosSiniestros;

        Resultado.MostrarPoliza(TotalPoliza);


    }
}
