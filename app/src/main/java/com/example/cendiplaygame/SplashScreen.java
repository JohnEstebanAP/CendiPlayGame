package com.example.cendiplaygame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Este puede generar error por lo que lo adecuado es colocarlo dentro de un try catch
        try{
            //El metodo Thread nos permite utilizar hilos, este nos permite con el metodo sleep detenernos o detener nuestro porgrama en un punto espesifico por milisegundos.
            Thread.sleep(2000);//Para deternerlo durante 2 segundos
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        startActivity(new Intent(this, LoginActivity.class));
        super.finish();//para finalizar la actividad y no quede en segundo plano avierta por detras luego de avirla otra actividad.
    }
}