package mx.edu.utng.projectajax.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.edu.utng.projectajax.R;

public class ResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		//display score
		bar.setRating(score);
		switch (score) {
			case 1:
				t.setText("Pésimo :( Vulve a leer");
				break;
			case 2:
				t.setText("Muy Mal, Vuleve a Intentar !!!");
				break;
			case 3:
				t.setText("Mal, Sigue intentando");
				break;
			case 4:
				t.setText("Bien, Podr�as Mejorar!!!");
				break;
			case 5:
				t.setText("Muy Bien!!!");
				break;
			case 6: t.setText("Excelente, Muchas Felicidades!!!");
				break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}
}
