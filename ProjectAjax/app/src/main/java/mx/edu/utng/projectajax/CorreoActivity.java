package mx.edu.utng.projectajax;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Roberto on 19/04/2016.
 */
public class CorreoActivity extends AppCompatActivity implements View.OnClickListener {
    SQLControlador correo;

    private ImageView imvEnviarEmailAhora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         correo = new SQLControlador(getApplication());
        setContentView(R.layout.example_email_layout);
        initComponets();
        correo.abrirBaseDeDatos();
    }

    private void initComponets() {
        imvEnviarEmailAhora=(ImageView)findViewById(R.id.imv_email_email_haora);
        imvEnviarEmailAhora.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.imv_email_email_haora:


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
                email.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://"+ getPackageName()+ "/"));
                email.putExtra(Intent.EXTRA_SUBJECT, "Curso De AJAX certificado");
                email.putExtra(Intent.EXTRA_TEXT , "Tus resultados actuales en el curso AJAX son: \n Quiz 1: "+correo.resultado("1")
                + "\n Quiz 2: "+correo.resultado("2")
                + "\n Quiz 3: "+correo.resultado("3")
                + "\n Quiz 4: "+correo.resultado("4")
                + "\n Quiz 5: "+correo.resultado("5")
                + "\n Quiz 6: "+correo.resultado("6"));
                email.setType("plain/text");

                startActivity(Intent.createChooser(email, ""));


        }
    }
}
