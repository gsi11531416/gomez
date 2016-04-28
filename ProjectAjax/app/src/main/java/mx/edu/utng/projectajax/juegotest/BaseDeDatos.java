package mx.edu.utng.projectajax.juegotest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

public class BaseDeDatos extends SQLiteOpenHelper{
		   //Métodos de SQLiteOpenHelper
		Context a;
		   public BaseDeDatos(Context context) {
		          super(context, "rapidTest", null, 1);
		          this.a=context;
		   }
		 
		   @Override
		   public void onCreate(SQLiteDatabase db) {
		          db.execSQL("CREATE TABLE puntuaciones ("+
		                       "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
		                       "puntos INTEGER, nombre TEXT, fecha LONG, tematica INTEGER)");
		          		          
		          db.execSQL("CREATE TABLE preguntas ("+
	                       "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
	                       "pregunta TEXT, respuesta1 TEXT, respuesta2 TEXT, respuesta3 TEXT, respuesta4 TEXT, correcta INTEGER, tematica INTEGER, id_pregunta INTEGER)");
		          
		          llenarBaseDeDatos(db);
		          
		   }
		 
		   @Override 
		   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		   // En caso de una nueva versión habría que actualizar las tablas
		   }
		 
		   //Métodos de AlmacenPuntuaciones
		   public void guardarPuntuacion(int puntos, String nombre, long fecha, int tematica) {
		          SQLiteDatabase db = getWritableDatabase();
		          db.execSQL("INSERT INTO puntuaciones VALUES ( null, "+puntos+", '"+nombre+"', "+fecha+", "+tematica+")");
		   }
		   
		   public Vector<String> listaPuntuaciones(int tematica) {
		          Vector<String> result = new Vector<String>();
		          SQLiteDatabase db = getReadableDatabase();
		          Cursor cursor;
		          if(tematica !=3){
		          	cursor = db.rawQuery("SELECT puntos, nombre FROM " + "puntuaciones where tematica="+tematica+" ORDER BY puntos DESC LIMIT 10", null);
		          }else{
		        	cursor = db.rawQuery("SELECT puntos, nombre FROM " + "puntuaciones ORDER BY puntos DESC LIMIT 10", null);
		          }
		          while (cursor.moveToNext()){
		                       result.add(cursor.getString(1)+" - "+cursor.getInt(0));
		          }
		          cursor.close();
		          return result;
		   }
		  
		 //Métodos de AlmacenPreguntas
		   public void guardarPreguntas(String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, int correcta, int tematica, int id_pregunta){
		          SQLiteDatabase db = getWritableDatabase();
		          db.execSQL("INSERT INTO preguntas VALUES ( null, '"+pregunta+"', '"+respuesta1+"', '"+respuesta2+"', '"+respuesta3+"', '"+respuesta4+"', "+correcta+", "+tematica+", "+id_pregunta+")");
		   }
		   
		   public Vector<String> listaPreguntas(int tematica) {
		          Vector<String> result = new Vector<String>();
		          SQLiteDatabase db = getReadableDatabase();
		          Cursor cursor;
		          if(tematica !=3){
		        	  cursor = db.rawQuery("SELECT pregunta, respuesta1, respuesta2, respuesta3, respuesta4, correcta FROM " + "preguntas where tematica="+tematica, null);
		          }else{
		        	  cursor = db.rawQuery("SELECT pregunta, respuesta1, respuesta2, respuesta3, respuesta4, correcta FROM " + "preguntas ORDER BY id_pregunta ASC LIMIT 10", null);
		          }
		          while (cursor.moveToNext()){
		        	  result.add(cursor.getString(0)+";"+cursor.getString(1)+";"+cursor.getString(2)+";"+cursor.getString(3)+";"+cursor.getString(4)+";"+cursor.getInt(5));
		          }
		          cursor.close();
		          return result;
		   }
		   
		   private void llenarBaseDeDatos(SQLiteDatabase db){
			   for(int i=0;i<20;i++){
				   	String nombre = "Jugador "+i;
		        	  db.execSQL("INSERT INTO puntuaciones VALUES ( null, "+i*1000+", '"+nombre+"', "+i*1000000+(i%12*10000)+2013+", "+((i%2)+1)+")");
		       }
			   
	   		  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica10', 'Jill - Chris', 'Chris - Sheva', 'Jill - Parker', 'Parker - Sheva', 2, 1, 1)");
	   		  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica11', 'Sonic', 'Son Goku', 'Tails', 'Eggman', 1, 1, 2)");
	          db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica12', 'Halo', 'Final Fantasy', 'Super Mario Bros', 'The Legend Of Zelda', 4, 1, 3)");
	       	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica13', 'Vergil', 'Sparda', 'Mundus', 'Nero', 2, 1, 4)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica14', 'Blanca', 'Ken', 'Chun Li', 'Kratos', 4, 1, 5)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica15', '3', '4', '5', '6', 3, 1, 6)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica16', 'Luigi', 'Yoshi', 'Bowser', 'Peach', 4, 1, 7)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica17', 'preguntaTematica1Respuesta81', 'preguntaTematica1Respuesta82', 'preguntaTematica1Respuesta83', 'preguntaTematica1Respuesta84', 1, 1, 8)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica18', 'Robot', 'Saiyan', 'Eon', 'Seed', 4, 1, 9)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica19', '1999', '2000', '2001', '2002', 3, 1, 10)");

        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica20', 'Son Goku', 'Vegeta', 'Son Goten', 'Krilin', 1, 2, 1)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica21', 'Mu', 'Shaka', 'Ikki', 'Kiki', 3, 2, 2)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica22', 'Yu Kanda', 'Lucy Heartphilia', 'Allen Walker', 'Linali Li', 3, 2, 3)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica23', 'preguntaTematica2Respuesta31', 'One Piece', 'Big Whoop', 'preguntaTematica2Respuesta32', 2, 2, 4)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica24', 'Shinigami', 'Vizar', 'Arrancar', 'Hollow', 1, 2, 5)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica25', 'Naruto', 'Bleach', 'One Piece', 'preguntaTematica2Respuesta51', 4, 2, 6)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica26', 'Rasengan', 'Chidori', 'Final Flash', 'Raikiri', 3, 2, 7)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica27', 'preguntaTematica2Respuesta71', 'preguntaTematica2Respuesta72', 'preguntaTematica2Respuesta73', 'preguntaTematica2Respuesta74', 1, 2, 8)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica28', 'Asuna', 'Kirito', 'Leafa', 'Yui', 2, 2, 9)");
        	  db.execSQL("INSERT INTO preguntas VALUES ( null, 'preguntaTematica29', 'Natsu', 'Happy', 'Gray', 'Erza', 1, 2, 10)");
		   }
		   
}
