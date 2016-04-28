package mx.edu.utng.projectajax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import mx.edu.utng.projectajax.juegotest.AcercaDeTest;
import mx.edu.utng.projectajax.juegotest.BaseDeDatos;
import mx.edu.utng.projectajax.juegotest.Configuracion;

public class RapidTest extends Activity {

	static BaseDeDatos bbdd;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bbdd=new BaseDeDatos(this);
        setContentView(R.layout.activity_rapid_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.exit:	lanzarSalir(null);break;
        case R.id.about: lanzarAcercaDe(null);break;
        case R.id.config: lanzarConfiguracion(null);break;
        }
        return true;
    }
    
    public void lanzarAcercaDe(View view){
    	Intent i = new Intent(this, AcercaDeTest.class);
    	startActivity(i);
    }
    
    public void lanzarPuntuaciones(View view){
    	Intent i = new Intent(this, PuntuacionesTest.class);
    	startActivity(i);
    }
    
    public void lanzarConfiguracion(View view){
    	Intent i = new Intent(this, Configuracion.class);
    	startActivity(i);
    }
    
    public void lanzarSalir(View view){
    	finish();
    }
    
    public void lanzarRapidText(View view){
    	Intent i = new Intent(this, JuegoTest.class);
    	startActivity(i);
    }
}
