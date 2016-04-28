package mx.edu.utng.projectajax.adivinalapalabra;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import mx.edu.utng.projectajax.AlmacenPuntuaciones;

public class AlmacenPuntuacionesFicheroInterno implements AlmacenPuntuaciones {

	private static String FICHERO = "puntuaciones.txt";

	private Context context;

	public AlmacenPuntuacionesFicheroInterno(Context context) {

		this.context = context;
		

	}


	public ArrayList<String> listaPuntuaciones(int cantidad) {

		ArrayList<String> result = new ArrayList<String>();

		try {

			FileInputStream f = context.openFileInput(FICHERO);

			BufferedReader entrada = new BufferedReader(

			new InputStreamReader(f));

			int n = 0;

			String linea;

			do {

				linea = entrada.readLine();

				if (linea != null) {

					result.add(linea);

					n++;

				}

			} while (n < cantidad && linea != null);
			
			f.close();

		} catch (Exception e) {

			Log.e("Juego_Palabras", e.getMessage(), e);

		}

		return result;

	}

	@Override
	public void guardarPuntuacion(int puntos, String nombre) {
		// TODO Auto-generated method stub
		try {

			FileOutputStream f = context.openFileOutput(FICHERO,Context.MODE_APPEND);

			String texto = puntos + " " + nombre + "\n";

			f.write(texto.getBytes());

			f.close();

		} catch (Exception e) {

			Log.e("Juego_Palabras", e.getMessage(), e);

		}
	}

}
