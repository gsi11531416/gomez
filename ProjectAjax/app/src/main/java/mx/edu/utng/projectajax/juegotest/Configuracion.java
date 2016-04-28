package mx.edu.utng.projectajax.juegotest;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import mx.edu.utng.projectajax.R;

public class Configuracion extends PreferenceActivity {
/*Enviamos al las configuraciones del juago*/
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.configuracion);
    }
}