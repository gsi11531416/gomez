package mx.edu.utng.projectajax.audios;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.edu.utng.projectajax.R;


public class AudioActividad3 extends Activity implements View.OnClickListener{

    /*Declaración de variables*/
   private MediaPlayer mp;
   private Button btnStart;
    private Button btnStop;

    /*onCreate para mandar a la vista y agregar el audio interno*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_layout);
        mp = MediaPlayer.create ( this, R.raw.audio3);

       intiComponets();

    }
    /*Intrucciones a los botones para pausar y reproducir el audio*/
private void intiComponets(){
    btnStart=(Button)findViewById(R.id.btn_start);
    btnStop=(Button)findViewById(R.id.btn_stop);
    btnStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mp.start();
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
    });
    btnStop.setOnClickListener(this);
}

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btn_stop){
            mp.pause();
        }
    }
}
