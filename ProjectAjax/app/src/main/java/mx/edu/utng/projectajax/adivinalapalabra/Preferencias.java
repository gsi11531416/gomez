package mx.edu.utng.projectajax.adivinalapalabra;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import mx.edu.utng.projectajax.R;

public class Preferencias extends PreferenceActivity{
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferencias);
	}
}
