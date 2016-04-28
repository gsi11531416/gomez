package mx.edu.utng.projectajax;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PideNombre extends Activity {

    /** Enviamos al layout para pedir nombre del jugador */
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pidenombre);
        Button bAcept = (Button) findViewById(R.id.aceptar);
		bAcept.setOnClickListener(new OnClickListener() {
     	  		public void onClick(View view) {
     	  			EditText et = (EditText)findViewById(R.id.nombreJug);
     	  			RapidTest.bbdd.guardarPuntuacion(JuegoTest.puntos, et.getText().toString(), JuegoTest.tiempo, JuegoTest.tematica);
     	  			finish();
     	  		}
       });
    }
}