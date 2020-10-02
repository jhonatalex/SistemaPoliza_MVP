package com.example.modulo_3examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button entrar;
    EditText usuario,pasword;
    public  int i;
    public int x=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        entrar=findViewById(R.id.btnLogin);
        usuario=findViewById(R.id.inputEmail);
        pasword=findViewById(R.id.inputPassword);


        i=1;

            entrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String email=usuario.getText().toString();

                    if(i<=3){
                            if(email.equals("admin") && pasword.getText().toString().equals("123")){
                                Intent ingresar =new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(ingresar);
                            }else{
                                x--;
                                Toast.makeText(LoginActivity.this, "Datos Incorrectos ", Toast.LENGTH_LONG).show();
                                Toast.makeText(LoginActivity.this, "Te quedan "+x+" Intentos", Toast.LENGTH_SHORT).show();
                                i++;
                            }
                    }else {
                        Toast.makeText(LoginActivity.this, "Cantidad de Intentos Superado", Toast.LENGTH_LONG).show();
                        Toast.makeText(LoginActivity.this, "USUARIO BLOQUEADO", Toast.LENGTH_LONG).show();
                        }
                }

            });





    }
}