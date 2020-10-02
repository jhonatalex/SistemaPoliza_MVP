package com.example.modulo_3examenfinal.Presenter;

import com.example.modulo_3examenfinal.Modelo.InterfaceModelo;
import com.example.modulo_3examenfinal.Modelo.Modelo;
import com.example.modulo_3examenfinal.Vista.InterfaceVista;

public class Presenter implements InterfacePresenter {


    InterfaceVista SendVista;
    InterfaceModelo sendModelo;


    public Presenter(InterfaceVista Vista) {
        this.SendVista = Vista;
        sendModelo = new Modelo(this);
    }

    @Override
    public void EnviarDatos(String CLP) {
        sendModelo.EnviarDatos(CLP);
    }
    @Override
    public void MostrarResultado(double USD, double EUR) {
        SendVista.MostrarResultado(USD,EUR);
    }




    @Override
    public void EnviarTransito(double SueldoNeto) {
        sendModelo.EnviarTransito(SueldoNeto);
    }
    @Override
    public void MostrarTransito(double TotalMulta) {
        SendVista.MostrarTransito(TotalMulta);

    }



    @Override
    public void CalcularSeguro(double Precio, int siniestros, char Modelo, int edad) {
        sendModelo.CalcularSeguro(Precio,siniestros,Modelo,edad);
    }

    @Override
    public void MostrarPoliza(double TotalPoliza) {
        SendVista.MostrarPoliza(TotalPoliza);
    }

}
