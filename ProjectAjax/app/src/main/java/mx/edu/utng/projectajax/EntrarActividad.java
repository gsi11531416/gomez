package mx.edu.utng.projectajax;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;


public class EntrarActividad extends ActionBarActivity {

    private ImageView imvJue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.entrar_layout);
        imvJue = (ImageView)findViewById(R.id.imv_jue);
        imvJue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntrarActividad.this,
                        MainActivity.class);
                startActivity(intent);


            }
        }



        );

    }




}
