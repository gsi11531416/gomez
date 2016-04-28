package mx.edu.utng.projectajax;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainGrafActivity extends AppCompatActivity {
    SQLControlador dbCalif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbCalif = new SQLControlador(getApplication());
        dbCalif.abrirBaseDeDatos();

        //Valores a mostrar en la gráfica

        ArrayList<BarEntry> entradas = new ArrayList<>();
        entradas.add(new BarEntry(Integer.parseInt(dbCalif.resultado("1")), 0));
        entradas.add(new BarEntry(Integer.parseInt(dbCalif.resultado("2")), 1));
        entradas.add(new BarEntry(Integer.parseInt(dbCalif.resultado("3")), 2));
        entradas.add(new BarEntry(Integer.parseInt(dbCalif.resultado("4")), 3));
        entradas.add(new BarEntry(Integer.parseInt(dbCalif.resultado("5")), 4));
        entradas.add(new BarEntry(Integer.parseInt(dbCalif.resultado("6")), 5));
        //Creamos el conjunto de datos a partir de las entradas

        BarDataSet dataset = new BarDataSet(entradas, "% de resultado");

        //Etiquetas para el eje X

        ArrayList<String> etiquetas = new ArrayList<String>();
        etiquetas.add("Quiz1");
        etiquetas.add("Quiz2");
        etiquetas.add("Quiz3");
        etiquetas.add("Quiz4");
        etiquetas.add("Quiz5");
        etiquetas.add("QuizFinal");

        //Aplicamos una plantillas de colores al conjunto de datos
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        //Definimos la gráfica

        BarChart grafica = new BarChart(getApplicationContext());
        setContentView(grafica);

        //Incluimos los datos y etiquetas en la gráfica

        BarData datos = new BarData(etiquetas, dataset);
        grafica.setData(datos);

        //Añadimos una descripción a la gráfica
        grafica.setDescription("# de quiz");

        //Aplicamos una animación al eje Y
        grafica.animateY(5000);

        //Incluímos una línea límite
        LimitLine linea = new LimitLine(22f);
        YAxis ejeY = grafica.getAxisLeft();
        ejeY.addLimitLine(linea);
    }
}
