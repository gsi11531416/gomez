package mx.edu.utng.projectajax.adivinalapalabra;

import android.app.ListActivity;
import android.os.Bundle;

import mx.edu.utng.projectajax.InicioActivity;
import mx.edu.utng.projectajax.R;
import mx.edu.utng.projectajax.adivinalapalabra.AdaptadorPuntuaciones;

public class Puntuaciones extends ListActivity{
	

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puntuaciones);
		setListAdapter(new AdaptadorPuntuaciones(this, InicioActivity.almacen.listaPuntuaciones(10)));
	}
	
	

}
