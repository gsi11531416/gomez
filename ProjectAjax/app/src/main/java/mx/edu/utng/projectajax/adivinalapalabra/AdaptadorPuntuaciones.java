package mx.edu.utng.projectajax.adivinalapalabra;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.edu.utng.projectajax.R;

public class AdaptadorPuntuaciones extends BaseAdapter {

	private final Activity actividad;
	private final ArrayList<String> lista;

	public AdaptadorPuntuaciones(Activity actividad, ArrayList<String> lista) {
		super();
		this.actividad = actividad;
		this.lista = lista;
	}

	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// String auxiliar
		String[] auxiliar;

		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_lista, null, true);

		// hacemos un split de intentos#usuario
		auxiliar = lista.get(position).split(" ");

		TextView intentos = (TextView) view.findViewById(R.id.intentos);
		intentos.setText(auxiliar[0] + " intentos");

		TextView usuario = (TextView) view.findViewById(R.id.usuario);
		usuario.setText("Usuario: " + auxiliar[1].toUpperCase());

		ImageView imageView = (ImageView) view.findViewById(R.id.icono);

		switch (position) {
			case 0:
				imageView.setImageResource(R.drawable.one);
				break;
			case 1:
				imageView.setImageResource(R.drawable.two);
				break;
			case 2:
				imageView.setImageResource(R.drawable.three);
				break;
			case 3:
				imageView.setImageResource(R.drawable.nfor);
				break;
			case 4:
				imageView.setImageResource(R.drawable.five);
				break;
			case 5:
				imageView.setImageResource(R.drawable.six);
				break;
			case 6:
				imageView.setImageResource(R.drawable.seven);
				break;
			case 7:
				imageView.setImageResource(R.drawable.eight);
				break;
			case 8:
				imageView.setImageResource(R.drawable.nine);
				break;
			case 9:
				imageView.setImageResource(R.drawable.ten);
	        	break;
			default:
				imageView.setImageResource(R.drawable.other);
				break;
		}

		return view;
	}

}
