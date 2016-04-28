package mx.edu.utng.projectajax;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import mx.edu.utng.projectajax.juegotest.Apariencia;

public class PuntuacionesTest extends ListActivity {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuacionestest);
        SharedPreferences gPuntos = getSharedPreferences("org.example.rapid_test_preferences", Context.MODE_PRIVATE);
        int tematica = Integer.parseInt(gPuntos.getString("tematica","1"));
        setListAdapter(new Apariencia(this, RapidTest.bbdd.listaPuntuaciones(tematica)));
    }
}