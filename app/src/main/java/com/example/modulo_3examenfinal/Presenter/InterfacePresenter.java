package com.example.modulo_3examenfinal.Presenter;

public interface InterfacePresenter {

    //TODO: DIVISAS
    void EnviarDatos(String CLP);
    void MostrarResultado(double USD, double EUR);

    //TODO:TRANSITO
    void EnviarTransito(double SueldoNeto);
    void MostrarTransito(double TotalMulta);

    //TODO:SEGURO DE AUTO
     void CalcularSeguro(double Precio, int siniestros, char Modelo, int edad);
    void MostrarPoliza(double TotalPoliza);


}
