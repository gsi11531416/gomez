package mx.edu.utng.projectajax;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Vector;

public class JuegoTest extends Activity {
	
	private Vector<String> preguntasYrespuestas;
	private int resultado=0;
	private int posicion=0;
	static int puntos=0;
	static long tiempo=0;
	static int tematica=0;
	private Button bNext;
	private long valor1, valor2;
	   @Override public void onCreate(Bundle savedInstanceState) {
	    	 super.onCreate(savedInstanceState);
	         setContentView(R.layout.juegoprincipal);
	         SharedPreferences gPuntos = getSharedPreferences("org.example.rapid_test_preferences", Context.MODE_PRIVATE);
	         int tematica = Integer.parseInt(gPuntos.getString("tematica","1"));
	         this.preguntasYrespuestas = RapidTest.bbdd.listaPreguntas(tematica);
	         this.valor1=System.currentTimeMillis();
     		 listarPregunta(0);
     		 bNext = (Button) findViewById(R.id.siguiente);
     		 bNext.setOnClickListener(new OnClickListener() {
          	  		public void onClick(View view) {
          	  			siguientePregunta();
          	  		}
            });
	   }
	   
	   @Override
	   protected void onPause() {
	      super.onPause();
	   }
	    
	   @Override
	   protected void onResume() {
	      super.onResume();
	   }
	    
	   @Override
	   protected void onDestroy() {
	      super.onDestroy();
	   }
	   
	   public void siguientePregunta(){
		   
		   RadioButton rb1=(RadioButton)findViewById(R.id.opcion1);
		   RadioButton rb2=(RadioButton)findViewById(R.id.opcion2);
		   RadioButton rb3=(RadioButton)findViewById(R.id.opcion3);
		   RadioButton rb4=(RadioButton)findViewById(R.id.opcion4);
		   int respuesta=0;
		   this.posicion++;
		   
		   if(rb1.isChecked()){
			   respuesta=1;
		   }else if(rb2.isChecked()){
			   respuesta=2;
		   }else if(rb3.isChecked()){
			   respuesta=3;
		   }else if(rb4.isChecked()){
			   respuesta=4;
		   }
		   rb1.setChecked(false);
		   rb2.setChecked(false);
		   rb3.setChecked(false);
		   rb4.setChecked(false);
		   
		   if(this.resultado==respuesta) JuegoTest.puntos++;
		   
		   if(this.posicion<10)
			   listarPregunta(this.posicion);
		   else{
			   this.valor2=System.currentTimeMillis();
			   JuegoTest.puntos=(int)((JuegoTest.puntos*100000)/((this.valor2-this.valor1)/1000));
			   if(JuegoTest.puntos<0) JuegoTest.puntos= JuegoTest.puntos*(-1);
			   SharedPreferences gPuntos = getSharedPreferences("org.example.rapid_test_preferences", Context.MODE_PRIVATE);
		       JuegoTest.tematica = Integer.parseInt(gPuntos.getString("tematica","1"));
		       JuegoTest.tiempo = System.currentTimeMillis();
		       Intent i  = new Intent(this, PideNombre.class);
		       startActivity(i);
			   finish();
		   }
	   }
	   
	   public void listarPregunta(int posicion){
		   String aux[]=this.preguntasYrespuestas.elementAt(posicion).split(";");
		   TextView textView =(TextView)findViewById(R.id.preguntaActual);
           devuelveCadena(textView, aux[0]);
           RadioButton opcion1 = (RadioButton)findViewById(R.id.opcion1);
           devuelveCadena(opcion1, aux[1]);
           RadioButton opcion2 = (RadioButton)findViewById(R.id.opcion2);
           devuelveCadena(opcion2, aux[2]);
           RadioButton opcion3 = (RadioButton)findViewById(R.id.opcion3);
           devuelveCadena(opcion3, aux[3]);
           RadioButton opcion4 = (RadioButton)findViewById(R.id.opcion4);
           devuelveCadena(opcion4, aux[4]);
           this.resultado =Integer.parseInt(aux[5]);
	   }
	   
	   public void devuelveCadena(TextView textV, String aux){
		   
		   if(aux.equals("preguntaTematica10")){
			   textV.setText(R.string.preguntaTematica10);
		   }else if(aux.equals("preguntaTematica11")){
			   textV.setText(R.string.preguntaTematica11);
		   }else if(aux.equals("preguntaTematica12")){
			   textV.setText(R.string.preguntaTematica12);
		   }else if(aux.equals("preguntaTematica13")){
			   textV.setText(R.string.preguntaTematica13);
		   }else if(aux.equals("preguntaTematica14")){
			   textV.setText(R.string.preguntaTematica14);
		   }else if(aux.equals("preguntaTematica15")){
			   textV.setText(R.string.preguntaTematica15);
		   }else if(aux.equals("preguntaTematica16")){
			   textV.setText(R.string.preguntaTematica16);
		   }else if(aux.equals("preguntaTematica17")){
			   textV.setText(R.string.preguntaTematica17);
		   }else if(aux.equals("preguntaTematica18")){
			   textV.setText(R.string.preguntaTematica18);
		   }else if(aux.equals("preguntaTematica19")){
			   textV.setText(R.string.preguntaTematica19);
		   }else if(aux.equals("preguntaTematica1Respuesta81")){
			   textV.setText(R.string.preguntaTematica1Respuesta81);
		   }else if(aux.equals("preguntaTematica1Respuesta82")){
			   textV.setText(R.string.preguntaTematica1Respuesta82);
		   }else if(aux.equals("preguntaTematica1Respuesta83")){
			   textV.setText(R.string.preguntaTematica1Respuesta83);
		   }else if(aux.equals("preguntaTematica1Respuesta84")){
			   textV.setText(R.string.preguntaTematica1Respuesta84);
		   }else if(aux.equals("preguntaTematica20")){
			   textV.setText(R.string.preguntaTematica20);
		   }else if(aux.equals("preguntaTematica21")){
			   textV.setText(R.string.preguntaTematica21);
		   }else if(aux.equals("preguntaTematica22")){
			   textV.setText(R.string.preguntaTematica22);
		   }else if(aux.equals("preguntaTematica23")){
			   textV.setText(R.string.preguntaTematica23);
		   }else if(aux.equals("preguntaTematica24")){
			   textV.setText(R.string.preguntaTematica24);
		   }else if(aux.equals("preguntaTematica25")){
			   textV.setText(R.string.preguntaTematica25);
		   }else if(aux.equals("preguntaTematica26")){
			   textV.setText(R.string.preguntaTematica26);
		   }else if(aux.equals("preguntaTematica27")){
			   textV.setText(R.string.preguntaTematica27);
		   }else if(aux.equals("preguntaTematica28")){
			   textV.setText(R.string.preguntaTematica28);
		   }else if(aux.equals("preguntaTematica29")){
			   textV.setText(R.string.preguntaTematica29);
		   }else if(aux.equals("preguntaTematica2Respuesta31")){
			   textV.setText(R.string.preguntaTematica2Respuesta31);
		   }else if(aux.equals("preguntaTematica2Respuesta32")){
			   textV.setText(R.string.preguntaTematica2Respuesta32);
		   }else if(aux.equals("preguntaTematica2Respuesta51")){
			   textV.setText(R.string.preguntaTematica2Respuesta51);
		   }else if(aux.equals("preguntaTematica2Respuesta71")){
			   textV.setText(R.string.preguntaTematica2Respuesta71);
		   }else if(aux.equals("preguntaTematica2Respuesta72")){
			   textV.setText(R.string.preguntaTematica2Respuesta72);
		   }else if(aux.equals("preguntaTematica2Respuesta73")){
			   textV.setText(R.string.preguntaTematica2Respuesta73);
		   }else if(aux.equals("preguntaTematica2Respuesta74")){
			   textV.setText(R.string.preguntaTematica2Respuesta74);
		   }else{
			   textV.setText(aux);
		   }
	   }
}