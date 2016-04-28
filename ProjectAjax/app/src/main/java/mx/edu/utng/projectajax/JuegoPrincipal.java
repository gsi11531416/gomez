package mx.edu.utng.projectajax;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class JuegoPrincipal extends View{
	private int tematica;
    public JuegoPrincipal(Context context, AttributeSet attrs) {
          super(context, attrs);
          this.tematica=0;
          //jugarInicio();
    }

    @Override protected void onSizeChanged(int ancho, int alto, int ancho_anter, int alto_anter) {
          super.onSizeChanged(ancho, alto, ancho_anter, alto_anter);
    }

    @Override protected void onDraw(Canvas canvas) {
    }

	//Manejo sensores
    public void vistaJuegoResume(){
	}
    
    public void vistaJuegoPause(){
    }
    //Fin manejo sensores
    
    public void setTematica(int tematica){
    	this.tematica=tematica;
    }
    
    public int getTematica(){
    	return this.tematica;
    }
}