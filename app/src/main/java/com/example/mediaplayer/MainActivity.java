package com.example.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button btnnoreproducir;
    int posicion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnoreproducir     = findViewById(R.id.btnnoreproducir);
    }
    public void destruir(){
        if(mediaPlayer != null){
            mediaPlayer.release();
        }
    }
    //metodo play
    public void iniciar(View view){
        destruir();
        mediaPlayer= MediaPlayer.create(this,R.raw.homerosimpson);
        mediaPlayer.start();
        String op = btnnoreproducir.getText().toString();
        if(op.equals("no reproducir en forma circular")){
            mediaPlayer.setLooping(false);
        }else{
            mediaPlayer.setLooping(true);
        }
    }
    //metodo pausar si esta en reproduccion
    public void pausa(View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            posicion = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
    }

    //metodo continuar reproduccion
    public void continuar(View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying() == false){
            mediaPlayer.seekTo(posicion);
            mediaPlayer.start();
        }
    }

    //metodo detener
    public void detener(View view){
        if(mediaPlayer != null ){
            mediaPlayer.stop();
            posicion = 0;
        }
    }

    //metodo para habilitar reproducion continua
    public void circular(View view){
        detener(null);
        String op = btnnoreproducir.getText().toString();
        if(op.equals("no reproducir en forma circular")){
            btnnoreproducir.setText("reproducir en forma circular");
        }else{
            btnnoreproducir.setText("no reproducir en forma circular");
        }
    }
}