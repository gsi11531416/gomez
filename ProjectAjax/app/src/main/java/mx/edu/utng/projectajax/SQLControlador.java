package mx.edu.utng.projectajax;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import mx.edu.utng.projectajax.quiz.DBhelper;

public class SQLControlador {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;
    public static String resultado = "";

    public SQLControlador(Context c) {
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.CALIFICACION_NOMBRE, name);
        database.insert(DBhelper.TABLE_MEMBER, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelper.CALIFICACION_ID,
                DBhelper.CALIFICACION_NOMBRE
        };
        Cursor c = database.query(DBhelper.TABLE_MEMBER, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

/*
* SQLControlador db;
* db = new SQLControlador;
* db.abrirBaseDeDatos();
*
* //Siempre que quieras usar la base de datos es necesario declarar estas tres lineas para que puedas usar lo siguiente:
*
* db.resultado("1");<--- trae la calificacion con el id 1, pero en String
*
* //Para cnvertir el valor a entero, que es el que usas en la grafica es asi:
* //Ejemplo: Integer.parseInt(db.resultado("1"));
*
*
*
* y cuando guardes solo usa actualizar... por que sino va a insertar mas calificaciones que las de modulo 1 al 5
* //ejemplo
* SQLControlador db;
* db = new SQLControlador;
* db.abrirBaseDeDatos();
* db.actualizarDatos(1,"6");
* el primer atributo es el id, es decir el modulo, y el segundo es la calificacion que agarras del quiz el resultado
* */

    public String resultado(String id){
        try{
            Cursor cursor = database.rawQuery("select calificacion from calificacion where _id = ?",new String[]{id});
            cursor.moveToFirst();
            resultado = cursor.getString(0);
        }catch (Exception e){
            Log.i("El error ", e.toString());
        }
        return resultado;
    }


    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.CALIFICACION_NOMBRE, memberName);
        int i = database.update(DBhelper.TABLE_MEMBER, cvActualizar,
                DBhelper.CALIFICACION_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelper.TABLE_MEMBER, DBhelper.CALIFICACION_ID + "="
                + memberID, null);
    }
}