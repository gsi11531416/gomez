package mx.edu.utng.projectajax.quiz;

/**
 * Created by U_U on 30/03/2016.
 */

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import mx.edu.utng.projectajax.R;
import mx.edu.utng.projectajax.SQLControlador;

public class QuizActivity2 extends Activity {
    List<Question> quesList;
    int score=0;
    int qid=10;
    Question currentQ;

    RadioButton rda, rdb, rdc;
    Button butNext;


    TextView txtQuestion,txvTiempo;
    SQLControlador dbCalif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        dbCalif = new SQLControlador(getApplication());
       // dbCalif.abrirBaseDeDatos();


        DbHelper1 db=new DbHelper1(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        txvTiempo=(TextView)findViewById(R.id.txv_tiempo);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        final RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
        grp.clearCheck();



        txvTiempo.setText("00:03:00");
        CounterClass timer = new CounterClass(180000, 1000);
        timer.start();



        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbCalif.abrirBaseDeDatos();

                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                if (!(rda.isChecked()||rdb.isChecked() || rdc.isChecked()
                )){
                    Toast.makeText(QuizActivity2.this, "No haz respondido",Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                    if (currentQ.getANSWER().equals(answer.getText())) {
                        score++;
                        Log.d("score", "Your score" + score);
                    }
                    if (qid < 20) {
                        currentQ = quesList.get(qid);
                        setQuestionView();
                    } else {
                        Intent intent = new Intent(QuizActivity2.this, ResultActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }
                    grp.clearCheck();
                    int calif = (score * 100 / 10);
                    Toast.makeText(QuizActivity2.this, "Tu resultado es: " + calif, Toast.LENGTH_SHORT).

                            show();

                    dbCalif.actualizarDatos(2, String.valueOf(calif));
                    dbCalif.cerrar();
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {

        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%03d:%03d:%03d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            txvTiempo.setText(hms);
        }
    }

}
