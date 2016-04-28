package mx.edu.utng.projectajax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import mx.edu.utng.projectajax.adivinalapalabra.AcercaDePa;
import mx.edu.utng.projectajax.adivinalapalabra.AlmacenPuntuacionesFicheroInterno;
import mx.edu.utng.projectajax.adivinalapalabra.Juego_Palabras;
import mx.edu.utng.projectajax.adivinalapalabra.Preferencias;
import mx.edu.utng.projectajax.adivinalapalabra.Puntuaciones;

public class InicioActivity extends Activity {
	
	
	private Button play;
	private Button conf;
	private Button rank;
	private ImageView info;
	private ImageView logros;
	public static AlmacenPuntuaciones almacen;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		
		almacen= new AlmacenPuntuacionesFicheroInterno(this);
		
		play = (Button) findViewById(R.id.btn_play);
		conf =  (Button) findViewById(R.id.btn_conf);
		rank = (Button) findViewById(R.id.btn_puntuaciones);
		info = (ImageView) findViewById(R.id.acerca);
		logros = (ImageView) findViewById(R.id.logros);
		
		//Al pulsar sobre el boton de Jugar
		play.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Que hacer al pulsar el boton de jugar
				lanzarJuego(null);
			}
		});
		
		//Al pulsar sobre el boton de configurar
		conf.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Que hacer al pulsar el boton de configuracion
				lanzarPreferencias(null);
			}
		});
		
		//Al pulsar sobre el boton de puntuaciones
		rank.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Que hacer al pulsar sobre puntuaciones
				lanzarPuntuaciones(null);
			}
		});
		
		//Al pulsar sobre la imagen de informacion
		info.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Que hacer al pulsar la imagen de info
				lanzarAcerca(null);
			}
		});
		
		//AL pulsar sobre el boton de logros
		logros.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Que hacer al pulsar la imagen de logros
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.mainpa, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch(item.getItemId()){
			case R.id.action_acerca:
				lanzarAcerca(null);
				break;
			case R.id.action_conf:
				lanzarPreferencias(null);
				break;
			case R.id.action_logros:
				break;
		}
		
		return true;
	}

	public void lanzarAcerca(View view) {
		Intent i = new Intent(this, AcercaDePa.class);
		startActivity(i);
	}
	
	public void lanzarPreferencias(View view) {
		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	}
	
	public void lanzarJuego(View view) {
		Intent i = new Intent(this, Juego_Palabras.class);
		startActivityForResult(i,1);
	}
	
	public void lanzarPuntuaciones(View view) {
		Intent i = new Intent(this, Puntuaciones.class);
		startActivity(i);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	    if (requestCode == 1) {
	        if(resultCode == RESULT_OK){
	            int puntos=data.getExtras().getInt("result");
	            almacen.guardarPuntuacion(puntos, "Yo");
	            lanzarPuntuaciones(null);
	        }
	        //if (resultCode == RESULT_CANCELED) {
	            //Write your code if there's no result
	        //}
	    }
	}
}
