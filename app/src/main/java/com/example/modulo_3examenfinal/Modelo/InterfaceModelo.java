package com.example.modulo_3examenfinal.Modelo;

public interface InterfaceModelo {


    void EnviarDatos(String CLP);

    void EnviarTransito(double SueldoNeto);


   void  CalcularSeguro(double Precio, int siniestros,char Modelo, int edad);

}
