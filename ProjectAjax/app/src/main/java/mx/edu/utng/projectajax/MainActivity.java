package mx.edu.utng.projectajax;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.projectajax.agenda.AgendaFinalActivity;
import mx.edu.utng.projectajax.audios.AudioActividad;
import mx.edu.utng.projectajax.audios.AudioCompActividad;
import mx.edu.utng.projectajax.juegotest.TresEnRaya;


public class MainActivity extends ActionBarActivity {

    ViewPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    public String[] mModulo;
    //String[] titulo = getResources().getStringArray(R.array.categorias);


    protected static Integer[] mImageIds = {
            R.drawable.modulo1,
            R.drawable.modulo2,
            R.drawable.modulo3,
            R.drawable.modulo4,
            R.drawable.modulo5,
            R.drawable.quizcer
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        //VIEWPAGER
        mModulo = getResources().getStringArray(R.array.modulo);

        mSectionsPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);

        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(0,mModulo[0], mImageIds[0]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(1,mModulo[1], mImageIds[1]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(2,mModulo[2], mImageIds[2]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(3,mModulo[3], mImageIds[3]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(4,mModulo[4], mImageIds[4]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(5,mModulo[5], mImageIds[5]));


        mViewPager.setAdapter(mSectionsPagerAdapter);
        //FIN VIEWPAGER

    }




    /****************** VIEWPAGER *********************/
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments; //acá voy a guardar los fragments

        //constructor
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<Fragment>();
        }

        @Override
        public Fragment getItem(int position) {
            //return PlaceholderFragment.newInstance(position + 1);
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            //return 3;
            return this.fragments.size();
        }

        public void addFragment(Fragment xfragment){
            this.fragments.add(xfragment);
        }
    }
    /****************** FIN VIEWPAGER *********************/

    /****************** FRAGMENTOS *********************/
    public static class Fragmentos extends Fragment {
        /**
         Agregue "color"
         */
        private static final String CURRENT_VIEWVAPER ="currentviewpager";
        private static final String NOMBRE_MODULO = "modulo";
        private static final String IMAGEVIEW = "image";

        private int currentViewPager;
        private String nombre_modulo;
        private int image;

        public static Fragmentos newInstance(int currentViewPager, String moduloNombre, int image) {

            Fragmentos fragment = new Fragmentos();   //instanciamos un nuevo fragment

            Bundle args = new Bundle();                                 //guardamos los parametros
            args.putInt(CURRENT_VIEWVAPER, currentViewPager);
            args.putString(NOMBRE_MODULO, moduloNombre);
            args.putInt(IMAGEVIEW, image);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);     //agrego para que no se pierda los valores de la instancia
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //cuando crea una instancia de tipo PlaceholderFragment
            //si lo enviamos parametros, guarda esos
            //si no le envio nada, toma el color gris y un número aleatroio
            if(getArguments() != null){
                this.currentViewPager = getArguments().getInt(CURRENT_VIEWVAPER);
                this.nombre_modulo = getArguments().getString(NOMBRE_MODULO);
                this.image = getArguments().getInt(IMAGEVIEW);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_modulo, container, false);

            TextView tv_modulo = (TextView) rootView.findViewById(R.id.tv_modulo);
            tv_modulo.setText(nombre_modulo);

            ImageView frg_image = (ImageView) rootView.findViewById(R.id.frg_imageView);
            frg_image.setImageResource(image);
            frg_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), ListarModulo.class);
                    i.putExtra("currentViewPager", currentViewPager);
                    i.putExtra("nombreModulo", nombre_modulo);
                    startActivity(i);
                    //overridePendingTransition(R.anim.left_in, R.anim.left_out);
                }
            });
            return rootView;
        }
    }
    /****************** FIN FRAGMENTOS *********************/

    /***************** SUBMENÚ *****************************/
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layouts, menu);
        return true;
    }
/*Menu principal*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String mensage = "";
        switch (item.getItemId()){
            case R.id.itm_Audio:
                mensage= "Audio Canción";
                startActivity(new Intent(MainActivity.this, AudioActividad.class));
                break;
            case R.id.itm_audicom:
                mensage = "Audio Tutorial Completo";
                startActivity(new Intent(MainActivity.this, AudioCompActividad.class));
                break;
            case R.id.itm_video:
                mensage = "Video AJAX";
                startActivity(new Intent(MainActivity.this, VideoActividad.class));
                break;
            case R.id.itm_agenda:
                mensage = "Agenda";
                startActivity(new Intent(MainActivity.this, AgendaFinalActivity.class));
                break;
            case R.id.itm_cal:
                mensage= "Calculadora";
                startActivity(new Intent(MainActivity.this, Calculadora.class));
                break;
            case R.id.itm_avance:
                if(LoginActividad.acceso==1) {
                    mensage = "Grafica Avance";
                    startActivity(new Intent(MainActivity.this, MainGrafActivity.class));
            }else {
                    mensage = "No haz iniciado sesión";
                    startActivity(new Intent(MainActivity.this, LoginActividad.class));
                }

                break;
            case R.id.itm_juego:
                mensage = "Juego Distracción";
                startActivity(new Intent(MainActivity.this, TresEnRaya.class));
                break;
            case R.id.itm_juegopa:
                mensage = "Juego Palabras";
                startActivity(new Intent(MainActivity.this, InicioActivity.class));
                break;
            case R.id.itm_rapid:
                mensage = "Juego Rapid Test";
                startActivity(new Intent(MainActivity.this, RapidTest.class));
                break;

            case R.id.itm_dinamica:
                mensage = "Material Dinamico De Ayuda";
                startActivity(new Intent(MainActivity.this, MaterialDinamicoActivity.class));
                break;
            case R.id.itm_desarrollador:
                mensage = "Desarrollador: Carmen Gomez";
                startActivity(new Intent(MainActivity.this, Desarrollador.class));
                break;
            case R.id.itm_seting:
                mensage = "Configuraciones Avanzadas";
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;
            case R.id.itm_correo:
                if (LoginActividad.acceso==1){
                    mensage = "Correo de Certificación";
                    startActivity(new Intent(MainActivity.this, CorreoActivity.class));
                }else {
                    mensage = "No haz iniciado sesión";
                    startActivity(new Intent(MainActivity.this, LoginActividad.class));
                }

                break;
            case R.id.itm_salir:
                mensage = "Gracias por tu visita";
                itmSalir();
                break;

        }
        Toast.makeText(getApplicationContext(), mensage, Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
        private void itmSalir(){
            finish();
            Intent intent1=new Intent(Intent.ACTION_MAIN);
            intent1.addCategory(Intent.CATEGORY_HOME);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent1);
        }
}
