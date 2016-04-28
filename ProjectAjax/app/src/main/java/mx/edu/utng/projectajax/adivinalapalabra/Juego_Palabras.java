package mx.edu.utng.projectajax.adivinalapalabra;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.edu.utng.projectajax.R;

public class Juego_Palabras extends Activity {

	private ArrayList<String> lista_palabras;
	EditText pintroducida;
	TextView contador, menor, mayor, secreto;
	String psecreta;
	int numIntentos=0;
	String aux_menor="aaa", aux_mayor="zzz";
	SoundPool sonido;
	private MediaPlayer mp;
	int ganar;
	boolean vsonido, vmusica; 
	//private SharedPreferences pref;
	
	@Override
	public void onCreate(Bundle savedInstancedState){
		super.onCreate(savedInstancedState);
		setContentView(R.layout.juego);
		
		//capturamos los valores de las preferencias
		SharedPreferences preferencias = getPreferences(MODE_PRIVATE);
		vmusica = preferencias.getBoolean("musica", false);
		vsonido = preferencias.getBoolean("sonido", true);

		//forzamos la orientación portrait en codigo java ( en el manifest no funcionaba...)
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
		
		//inicilaizamos los textview
		contador = (TextView) findViewById(R.id.intentos);
		menor = (TextView) findViewById(R.id.pmenor);
		mayor = (TextView) findViewById(R.id.pmayor);
		secreto = (TextView) findViewById(R.id.psecreta);
		
		//cargamos las palabras en un ArrayList
		cargarPalabras();
		
		//generamos un número aleatorio
		int numAleatorio = (int) Math.floor(Math.random()*lista_palabras.size());
		psecreta = lista_palabras.get(numAleatorio);
		
		//Sonidos
		sonido = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		ganar = sonido.load(this, R.raw.ganar,0);
		
		//Musica, solo si está activada en las preferencias.
		if(vmusica){
			mp = MediaPlayer.create(this, R.raw.juego);
			mp.start();
		}
		

	}

	private void cargarPalabras() {
		/**
		 * Esto es provisional: Las palabras se leeran de la base de datos
		 * La idea es que esten todas las palabras del castellano de más de tres letras
		 *
		 * */
		
		lista_palabras = new ArrayList<String>();
		
		lista_palabras.add("hola");
		lista_palabras.add("sobre");
		lista_palabras.add("adíos");
		lista_palabras.add("año");
		lista_palabras.add("todos");
		lista_palabras.add("donde");
		lista_palabras.add("bien");
		lista_palabras.add("tiempo");
		lista_palabras.add("mismo");
		lista_palabras.add("vida");
		
		lista_palabras.add("otro");
		lista_palabras.add("despues");
		lista_palabras.add("gobierno");
		lista_palabras.add("durante");
		lista_palabras.add("siempre");
		lista_palabras.add("gran");
		lista_palabras.add("pais");
		lista_palabras.add("mundo");
		lista_palabras.add("menos");
		lista_palabras.add("antes");
		
		lista_palabras.add("estado");
		lista_palabras.add("nada");
		lista_palabras.add("hacer");
		lista_palabras.add("general");
		lista_palabras.add("poco");
		lista_palabras.add("presidente");
		lista_palabras.add("mayor");
		lista_palabras.add("menor");
		lista_palabras.add("hacia");
		lista_palabras.add("lugar");
		
		lista_palabras.add("madrid");
		lista_palabras.add("nacional");
		lista_palabras.add("trabajo");
		lista_palabras.add("entonces");
		lista_palabras.add("fin");
		lista_palabras.add("juan");
		lista_palabras.add("cuatro");
		lista_palabras.add("dentro");
		lista_palabras.add("enero");
		lista_palabras.add("febrero");
		
		lista_palabras.add("marzo");
		lista_palabras.add("abril");
		lista_palabras.add("mayo");
		lista_palabras.add("junio");
		lista_palabras.add("julio");
		lista_palabras.add("agosto");
		lista_palabras.add("septiembre");
		lista_palabras.add("octubre");
		lista_palabras.add("noviembre");
		lista_palabras.add("diciembre");
		
		lista_palabras.add("amigo");
		lista_palabras.add("autor");
		lista_palabras.add("viejo");
		lista_palabras.add("boca");
		lista_palabras.add("plaza");
		lista_palabras.add("pie");
		lista_palabras.add("sur");
		lista_palabras.add("norte");
		lista_palabras.add("este");
		lista_palabras.add("oeste");
		
		lista_palabras.add("grande");
		lista_palabras.add("pequeño");
		lista_palabras.add("zozobra");
		lista_palabras.add("mesa");
		lista_palabras.add("movil");
		lista_palabras.add("juego");
		lista_palabras.add("algo");
		lista_palabras.add("deshacer");
		lista_palabras.add("viento");
		lista_palabras.add("lluvia");
		
		lista_palabras.add("nieve");
		lista_palabras.add("primavera");
		lista_palabras.add("otoño");
		lista_palabras.add("verano");
		lista_palabras.add("invierno");
		lista_palabras.add("europa");
		lista_palabras.add("america");
		lista_palabras.add("africa");
		lista_palabras.add("oceania");
		lista_palabras.add("venezuela");
		
		lista_palabras.add("argentina");
		lista_palabras.add("francia");
		lista_palabras.add("italia");
		lista_palabras.add("china");
		lista_palabras.add("japon");
		lista_palabras.add("camsieta");
		lista_palabras.add("zapatillas");
		lista_palabras.add("cuadro");
		lista_palabras.add("ordenador");
		lista_palabras.add("portatil");
		
		lista_palabras.add("messi");
		lista_palabras.add("rey");
		lista_palabras.add("publica");
		lista_palabras.add("santander");
		lista_palabras.add("alicante");
		lista_palabras.add("monforte");
		lista_palabras.add("huelva");
		lista_palabras.add("podemos");
		lista_palabras.add("partido");
		lista_palabras.add("futbol");
	}
	
	public void comprobarPalabra(View view){
		pintroducida = (EditText) findViewById(R.id.palabraIntroducida);
		
		if(pintroducida.getText().toString().length()>2){
			String aux = pintroducida.getText().toString();
			
			if(aux.equals(psecreta)){
				Toast.makeText(this,"Has ganado!!",Toast.LENGTH_LONG).show();
				secreto.setText(psecreta);
				//Si el sonido esta activo, aplausos al ganar.
				if(vsonido)
					sonido.play(ganar, 1, 1, 1, 0, 1);
				Intent returnIntent = new Intent();
				returnIntent.putExtra("result",numIntentos);
				setResult(RESULT_OK,returnIntent);
				this.finish();
			}else{
				Toast.makeText(this,"Has fallado!!",Toast.LENGTH_LONG).show();
				numIntentos++;//incrementamos el contador de intentos
				
				//Comprobamos los auxiliares
				if(aux.compareTo(psecreta)<0){
					if(aux.compareTo(aux_menor)>0)
						aux_menor=aux;
				}else if(aux.compareTo(psecreta)>0){
					if(aux.compareTo(aux_mayor)<0)
						aux_mayor=aux;
				}
				
				//actualizamos la vista
				actualizarVista();
				
			}
		}else{
			Toast.makeText(this,"Palabra invalida, introduce una palabra de más de 2 letras",Toast.LENGTH_LONG).show();
		}
	}
	
	

	public void actualizarVista(){
		//actualizamos el contador
		contador.setText("Intentos: "+numIntentos);
		
		//actualizamos palabras de referencia
		menor.setText(aux_menor);
		mayor.setText(aux_mayor);
		
		//actualizamos solucion
		boolean iguales=true;
		int i=0;
		int f=1;
		String aux="";
		do{
			if(aux_menor.substring(i, f).equals(aux_mayor.substring(i, f))){
				aux+=aux_menor.substring(i, f);
			}else{
				iguales=false;
			}
			i++;
			f++;
		}while(iguales);
		
		secreto.setText(aux);

		//borramos la palabra introducida
		pintroducida.setText("");
	}

	@Override
	protected void onPause() {
		if(vmusica)
			mp.pause();
		super.onPause();
	}

	
	@Override
	protected void onSaveInstanceState(Bundle estado){
		super.onSaveInstanceState(estado);
		if (mp != null) {
			int pos = mp.getCurrentPosition();
			estado.putInt("posicion", pos);
		}
		estado.putString("secreta", psecreta);
		estado.putInt("contador", numIntentos);
		estado.putString("menor", aux_menor);
		estado.putString("mayor", aux_mayor);
	}
		
	@Override
	protected void onRestoreInstanceState(Bundle estado){
		super.onRestoreInstanceState(estado);
		if(estado != null && mp != null){
			int pos = estado.getInt("posicion");
			mp.seekTo(pos);
			psecreta = estado.getString("secreta");
			numIntentos = estado.getInt("contador");
			aux_menor = estado.getString("menor");
			aux_mayor = estado.getString("mayor");
		}
	}
	
}
