package com.example.modulo_3examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    CardView Divisas,Ley,Seguro;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Divisas=findViewById(R.id.divisas);
       Ley=findViewById(R.id.transito);
       Seguro=findViewById(R.id.seguro);

       //TODO: Banner
        MobileAds.initialize(this,getString(R.string.admob_app_id));


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        // Display Banner ad
        mAdView.loadAd(adRequest);



        Divisas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ir =new Intent(getApplicationContext(), ActivityDivisas.class);
                startActivity(ir);
            }
        });

        Ley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ir2 =new Intent(getApplicationContext(), ActivityTransito.class);
                startActivity(ir2);

            }
        });

        Seguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent ir3 =new Intent(getApplicationContext(), ActivitySeguro.class);
                startActivity(ir3);
            }
        });

    }


    public void salir(View view){

        finish();


    };

    public void onBackPressed() {
        super.onBackPressed(); finishAffinity(); System.exit(0);
    }




}