package mx.edu.utng.projectajax;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.projectajax.audios.AudioActividad1;
import mx.edu.utng.projectajax.audios.AudioActividad2;
import mx.edu.utng.projectajax.audios.AudioActividad3;
import mx.edu.utng.projectajax.audios.AudioActividad4;
import mx.edu.utng.projectajax.audios.AudioActividad5;
import mx.edu.utng.projectajax.quiz.QuizActivity;

public class ListarUnModulo extends ActionBarActivity {
    /*Declaración de variables*/

    private ImageView imgImagen;
    private TextView txtTitulo, txtContenido;
    String[] titulo;
    String[] contenido;
    private Button btn_video, btn_audio, btn_quiz;

    /*Agregamos las imagenes a las listas*/

    private int[] imagenXMLHttp = {
            R.drawable.ajax1,
            R.drawable.a3,
            R.drawable.interfaz,
            R.drawable.implementacion,
            R.drawable.a2,
            R.drawable.a1,
            R.drawable.navegadores,
            R.drawable.quiz
    };

    private int[] imagenSolicitar = {
            R.drawable.peticiones,
            R.drawable.activacion,
            R.drawable.a4,
            R.drawable.quiz
    };

    private int[] imagenRespuesta = {
            R.drawable.respuesta,
            R.drawable.a5,
            R.drawable.ready,
            R.drawable.propiedades,
            R.drawable.quiz
    };

    private int[] imagenEventos = {
            R.drawable.javascript,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.tecnologias,
            R.drawable.quiz
    };

    private int[] imagenPHP = {
            R.drawable.a9,
            R.drawable.formularios,
            R.drawable.ajax2,
            R.drawable.acentos,
            R.drawable.framework,
            R.drawable.a1,
            R.drawable.quiz
    };
    /*Enviamos al layout de la lista*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_un_modulo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        int idmodulo = extras.getInt("idmodulo");
        final int position = extras.getInt("position");
        String nombreModulo = extras.getString("nombreModulo");
        String nombreSubModulo = extras.getString("nombreSubModulo");


        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle(nombreModulo);
        actionBar.setSubtitle(nombreSubModulo);

        txtTitulo = (TextView) findViewById(R.id.tv_titulo_listarunmodulo);
        txtContenido = (TextView) findViewById(R.id.tv_contenido_listarunmodulo);
        imgImagen = (ImageView) findViewById(R.id.iv_imagen_listarunmodulo);
        btn_video = (Button)  findViewById(R.id.btn_video);
        btn_audio = (Button) findViewById(R.id.btn_audio);
        btn_quiz = (Button) findViewById(R.id.btn_quiz);

        switch (idmodulo){
            case 0: //modulo 1
                titulo = getResources().getStringArray(R.array.modulo1);
                contenido = getResources().getStringArray(R.array.modulo1_contenido_completo);
                imgImagen.setImageResource(imagenXMLHttp[position]);
                btn_video.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://youtu.be/MT9xjyMEp4c")));
                    }
                });
                btn_audio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ListarUnModulo.this, AudioActividad1.class));
                    }
                });

                break;
            case 1: //modulo 2
                titulo = getResources().getStringArray(R.array.modulo2);
                contenido = getResources().getStringArray(R.array.modulo2_contenido_completo);
                imgImagen.setImageResource(imagenSolicitar[position]);
                btn_video.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://youtu.be/tp3Gw-oWs2k")));
                    }
                });
                btn_audio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ListarUnModulo.this, AudioActividad2.class));
                    }
                });
                break;

            case 2: //modulo 3
                titulo = getResources().getStringArray(R.array.modulo3);
                contenido = getResources().getStringArray(R.array.modulo3_contenido_completo);
                imgImagen.setImageResource(imagenRespuesta[position]);
                btn_video.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://youtu.be/qqRiDlm-SnY")));
                    }
                });
                btn_audio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ListarUnModulo.this, AudioActividad3.class));
                    }
                });
                break;

            case 3: //modulo 4
                titulo = getResources().getStringArray(R.array.modulo4);
                contenido = getResources().getStringArray(R.array.modulo4_contenido_completo);
                imgImagen.setImageResource(imagenEventos[position]);
                btn_video.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://youtu.be/Zw5U5rwAHfk")));
                    }
                });
                btn_audio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ListarUnModulo.this, AudioActividad4.class));
                    }
                });
                break;

            case 4: //modulo 5
                titulo = getResources().getStringArray(R.array.modulo5);
                contenido = getResources().getStringArray(R.array.modulo5_contenido_completo);
                imgImagen.setImageResource(imagenPHP[position]);
                btn_video.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://youtu.be/7NiCss9jA_k")));
                    }
                });

                btn_audio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ListarUnModulo.this, AudioActividad5.class));
                    }
                });
                break;

            case 5: //quiz de certificacion
                titulo = getResources().getStringArray(R.array.quiz_cerfiticacion);

                btn_quiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ListarUnModulo.this, QuizActivity.class));
                    }
                });
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }


        txtTitulo.setText(titulo[position]);
        txtContenido.setText(contenido[position]);

    }
}
