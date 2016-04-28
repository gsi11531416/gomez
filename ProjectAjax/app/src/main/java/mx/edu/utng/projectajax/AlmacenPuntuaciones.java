package mx.edu.utng.projectajax;

import java.util.ArrayList;

public interface AlmacenPuntuaciones {
	 public void guardarPuntuacion(int puntos, String nombre);
     public ArrayList<String> listaPuntuaciones(int cantidad);
}
