package mx.edu.utng.projectajax;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class VideoActividad extends Activity {
    private VideoView vwVideoPrueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.video_prueba_layout);
        vwVideoPrueba = (VideoView)findViewById(R.id.video);
        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ajax);
        vwVideoPrueba.setVideoURI(path);

        vwVideoPrueba.start();

    }


}
