package mx.edu.utng.projectajax;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.projectajax.quiz.QuizActivity;
import mx.edu.utng.projectajax.quiz.QuizActivity1;
import mx.edu.utng.projectajax.quiz.QuizActivity2;
import mx.edu.utng.projectajax.quiz.QuizActivity3;
import mx.edu.utng.projectajax.quiz.QuizActivity4;
import mx.edu.utng.projectajax.quiz.QuizActivity5;

/**
 * Created by user on 23/12/2014.
 */
public class ListarModulo extends ActionBarActivity {

    int[] imagenXMLHttp = {
            R.drawable.ajax1,
            R.drawable.a3,
            R.drawable.interfaz,
            R.drawable.implementacion,
            R.drawable.a2,
            R.drawable.a1,
            R.drawable.navegadores,
            R.drawable.quiz
    };

    int[] imagenSolicitar = {
            R.drawable.peticiones,
            R.drawable.activacion,
            R.drawable.a4,
            R.drawable.quiz
    };

    int[] imagenRespuesta = {
            R.drawable.respuesta,
            R.drawable.a5,
            R.drawable.ready,
            R.drawable.propiedades,
            R.drawable.quiz
    };

    int[] imagenEventos = {
            R.drawable.javascript,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.tecnologias,
            R.drawable.quiz
    };

    int[] imagenPHP = {
            R.drawable.a9,
            R.drawable.formularios,
            R.drawable.ajax2,
            R.drawable.acentos,
            R.drawable.framework,
            R.drawable.a1,
            R.drawable.quiz
    };


    String[] titulo;
    String[] contenido;

    private ListView lista;
    ListViewAdapter adapter;

    int currentViewPager;
    String nombreModulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_modulo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);  //ir atras

        Bundle extras = getIntent().getExtras();
        currentViewPager = extras.getInt("currentViewPager");
        nombreModulo = extras.getString("nombreModulo");
        Log.i("ramiro", "currentViewPager: " + currentViewPager);


        /**INDICAR TITULO **/
        actionBar.setTitle(nombreModulo);

        lista = (ListView) findViewById(R.id.listView_listarModulo);
        switch (currentViewPager) {
            case 0: //modulo 1
                titulo = getResources().getStringArray(R.array.modulo1);
                contenido = getResources().getStringArray(R.array.modulo1_contenido);
                adapter = new ListViewAdapter(this, imagenXMLHttp, titulo, contenido);
                break;
            case 1: //modulo 2
                titulo = getResources().getStringArray(R.array.modulo2);
                contenido = getResources().getStringArray(R.array.modulo2_contenido);
                adapter = new ListViewAdapter(this, imagenSolicitar, titulo, contenido);
                break;

            case 2: //modulo 3
                titulo = getResources().getStringArray(R.array.modulo3);
                contenido = getResources().getStringArray(R.array.modulo3_contenido);
                adapter = new ListViewAdapter(this, imagenRespuesta, titulo, contenido);
                break;

            case 3: //modulo 4
                titulo = getResources().getStringArray(R.array.modulo4);
                contenido = getResources().getStringArray(R.array.modulo4_contenido);
                adapter = new ListViewAdapter(this, imagenEventos, titulo, contenido);
                break;

            case 4: //modulo 5
                titulo = getResources().getStringArray(R.array.modulo5);
                contenido = getResources().getStringArray(R.array.modulo5_contenido);
                adapter = new ListViewAdapter(this, imagenPHP, titulo, contenido);
                break;

            case 5: //Quiz Certificacion

                startActivity(new Intent(ListarModulo.this, QuizActivity.class));
                finish();
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                         Intent i = new Intent(getApplicationContext(), ListarUnModulo.class);

                                         @Override
                                         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                                             switch (currentViewPager) {
                                                 // MODULO 1
                                                 case 0:
                                                     switch (position) {

                                                         // SUBTEMA 1
                                                         case 0:

                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;

                                                         // SUBTEMA 2
                                                         case 1:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                                                             break;

                                                         // SUBTEMA 3
                                                         case 2:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;

                                                         // SUBTEMA 4
                                                         case 3:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;

                                                         // SUBTEMA 5
                                                         case 4:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;

                                                         // SUBTEMA 6
                                                         case 5:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;

                                                         // SUBTEMA 7
                                                         case 6:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;

                                                         // QUIZ
                                                         case 7:

                                                             Intent i = new Intent(ListarModulo.this, QuizActivity1.class);
                                                             startActivity(i);


                                                             break;

                                                     }
                                                     break;

                                                 // MODULO 2
                                                 case 1:
                                                     switch (position) {
                                                         case 0:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 1:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 2:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 3:
                                                             SQLControlador db = new SQLControlador(getApplication());
                                                             db.abrirBaseDeDatos();
                                                             if ((Integer.parseInt(db.resultado("1")) > 60)) {
                                                                 Intent i = new Intent(ListarModulo.this, QuizActivity2.class);
                                                                 startActivity(i);
                                                             } else {
                                                                 Toast.makeText(ListarModulo.this, "No haz aprobado el Módulo 1", Toast.LENGTH_LONG).show();
                                                             }
                                                             db.cerrar();

                                                             break;
                                                     }
                                                     break;

                                                 // MODULO 3
                                                 case 2:
                                                     switch (position) {
                                                         case 0:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 1:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 2:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 3:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 4:
                                                             SQLControlador db = new SQLControlador(getApplication());
                                                             db.abrirBaseDeDatos();
                                                             if ((Integer.parseInt(db.resultado("2")) > 60)) {
                                                                 Intent i = new Intent(ListarModulo.this, QuizActivity3.class);
                                                                 startActivity(i);
                                                             } else {
                                                                 Toast.makeText(ListarModulo.this, "No haz aprobado el Módulo 2", Toast.LENGTH_LONG).show();
                                                             }
                                                             db.cerrar();
                                                             break;
                                                     }
                                                     break;

                                                 // MODULO 4
                                                 case 3:
                                                     switch (position) {
                                                         case 0:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 1:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 2:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 3:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 4:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 5:
                                                             SQLControlador db = new SQLControlador(getApplication());
                                                             db.abrirBaseDeDatos();
                                                             if ((Integer.parseInt(db.resultado("3")) > 60)) {
                                                                 Intent i = new Intent(ListarModulo.this, QuizActivity4.class);
                                                                 startActivity(i);
                                                             } else {
                                                                 Toast.makeText(ListarModulo.this, "No haz aprobado el Módulo 3", Toast.LENGTH_LONG).show();
                                                             }
                                                             db.cerrar();
                                                             break;
                                                     }
                                                     break;

                                                 // MODULO 5
                                                 case 4:
                                                     switch (position) {
                                                         case 0:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 1:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 2:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 3:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 4:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 5:
                                                             i = new Intent(getApplicationContext(), ListarUnModulo.class);
                                                             i.putExtra("idmodulo", currentViewPager);
                                                             i.putExtra("position", position);
                                                             i.putExtra("nombreModulo", nombreModulo);
                                                             i.putExtra("nombreSubModulo", titulo[position]);
                                                             startActivity(i);
                                                             overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                                             break;
                                                         case 6:
                                                             SQLControlador db = new SQLControlador(getApplication());
                                                             db.abrirBaseDeDatos();
                                                             if ((Integer.parseInt(db.resultado("4")) > 60)) {
                                                                 Intent i = new Intent(ListarModulo.this, QuizActivity5.class);
                                                                 startActivity(i);
                                                             } else {
                                                                 Toast.makeText(ListarModulo.this, "No haz aprobado el Módulo 4", Toast.LENGTH_LONG).show();
                                                             }
                                                             db.cerrar();
                                                             break;
                                                     }
                                                     break;

                                             }

                                         }
                                     }

        );

    }



    /*******************
     * LISTVIEW ADAPTER
     **************************/

    public class ListViewAdapter extends BaseAdapter {
        // Declaración de variables
        Context context;
        int[] imagenes;
        String[] titulos;
        String[] contenido;
        LayoutInflater inflater;

        public ListViewAdapter(Context context, int[] imagenes, String[] titulos, String[] contenido) {
            this.context = context;
            this.imagenes = imagenes;
            this.titulos = titulos;
            this.contenido = contenido;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            // Declare Variables
            ImageView imgImg;
            TextView txtTitle;
            TextView txtContenido;

            //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.single_post_modulo, parent, false);

            // Locate the TextViews in listview_item.xml
            imgImg = (ImageView) itemView.findViewById(R.id.imagen_single_post_circuito);
            txtTitle = (TextView) itemView.findViewById(R.id.tv_titulo_single_post_circuito);
            txtContenido = (TextView) itemView.findViewById(R.id.tv_contenido_single_post_circuito);

            // Capture position and set to the TextViews
            imgImg.setImageResource(imagenes[position]);
            txtTitle.setText(titulos[position]);
            txtContenido.setText(contenido[position]);

            return itemView;
        }
    }
}
