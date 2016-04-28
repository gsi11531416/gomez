package mx.edu.utng.projectajax.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper1 extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Nombre de la DB
	private static final String DATABASE_NAME = "triviaQuiz";
	// nombre de la tabla
	private static final String TABLE_QUEST = "quest";
	// nombre de las columnas de la tabla
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //opción correcra
	private static final String KEY_OPTA= "opta"; //opción a
	private static final String KEY_OPTB= "optb"; //opción b
	private static final String KEY_OPTC= "optc"; //opción c
	private SQLiteDatabase dbase;
	public DbHelper1(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		db.execSQL(sql);		
		addQuestions();
		//db.close();
	}
	private void addQuestions() //Agregamos las preguntas que estarán en los diferentes Quiz
	{
		//Quiz Modulo 1
		Question q1=new Question("¿Qué es XMLHttp?","Es un lenguaje de programación","Es una página web","Es una interfaz","Es una interfaz");
		this.addQuestion(q1);
		Question q2=new Question("¿Cómo empezar la instanciación de un objeto?","new XMLHttpRequest();","if (!httpRequest)","var httpRequest;","var httpRequest;");
		this.addQuestion(q2);
		Question q3=new Question("Implementar la interfaz de forma nativa mediante la siguente línea de comando: ","new ActiveXObject","new XMLHttpRequest();","httpRequest = new XMLHttpRequest();","httpRequest = new XMLHttpRequest();" );
		this.addQuestion(q3);
		Question q4=new Question("Crear objetos ActiveX mediante: ","if (window.ActiveXObject)","if (window.XMLHttpRequest)","thttpRequest = new ActiveXObject(\"MSXML2.XMLHTTP\");","thttpRequest = new ActiveXObject(\"MSXML2.XMLHTTP\");");
		this.addQuestion(q4);
		Question q5=new Question("Por quien fue desarrollada la primera versión de la interfaz XMLHttpRequest","Apple","Sun","Microsoft","Microsoft");
		this.addQuestion(q5);
		Question q6=new Question("¿En que fecha el World Wide Web Consortium presentó el primer borrador de una especificación estándar de la interfaz.2?","27 de junio de 2002","27 de agosto de 2004","27 de septiembre de 2006","27 de septiembre de 2006");
		this.addQuestion(q6);
		Question q7=new Question("Fecha de la versión actual, denominada XMLHttpRequest Level 2","17 febrero de 2010","17 de abril de 2014","17 de enero de 2012","17 de enero de 2012");
		this.addQuestion(q7);
		Question q8=new Question("Fecha en la que se publicó la primera versión de la especificación XMLHttpRequest Level 2.","20 de julio de 2006","16 de octubre de 2010","26 de febrero de 2008","26 de febrero de 2008");
		this.addQuestion(q8);
		Question q9=new Question("¿Para que sirve XMLHttpRequest","Para solicitar datos", "Para recibir archivos", "Para realizar llamadas mediante HTTP", "Para realizar llamadas mediante HTTP");
		this.addQuestion(q9);
		Question q10=new Question("Navegadores que permite AJAX", "Opera 7, Microsoft Internet Explorer, Anteriores a Safari 1.2 ", "Lynx, Lynks, Navegadores de Teléfonos móviles", "SeaMonkey, Flock, Epiphany, Navegadores basados en WebKit","SeaMonkey, Flock, Epiphany, Navegadores basados en WebKit");
		this.addQuestion(q10);

		//Quiz modulo 2
		Question q11=new Question("Es una clase de propósito general para realizar peticiones HTTP que gestiona el ciclo de vida de la solicitud", "Ajax.Solicite", "Ajax.onComplete", "Ajax.Request", "Ajax.Request");
		this.addQuestion(q11);
		Question q12=new Question("¿Cuál es el orden de activación de la llamada?","onCreate, onloading, onLoaded, onInteractive, onUninitialized, onSuccess o onFailure, onComplete", "onCreate, onloading, onLoaded, onInteractive, onUninitialized, onComplete","onCreate, onUninitialized, onloading, onLoaded, onInteractive, onSuccess o onFailure, onComplete", "onCreate, onUninitialized, onloading, onLoaded, onInteractive, onSuccess o onFailure, onComplete");
		this.addQuestion(q12);
		Question q13=new Question("¿Cuáles son las devoluciones de llamada infrautilizados?", "onloading y onLoaded", "onInteractive y onUninitialized", "onSuccess y onFailure","onSuccess y onFailure");
		this.addQuestion(q13);
		Question q14=new Question("¿Qué pasa si los contenidos Header son nulos (según el ejemplo visto)?","headerJSON se establece en 1","headerJSON obliga a validar los contenidos","headerJSON se establece en nulo","headerJSON se establece en nulo");
		this.addQuestion(q14);
		Question q15=new Question("Algunos tipos de MIME relacionados con JavaScript manejados por Prototype son:","application / ECMAScript, application / javascript, application / x-ecmascript, application / x-javascript","texto / ECMAScript, text / javascript, texto / x-ecmascript, texto / x-javascript","Ambas son correctas","Ambas son correctas");
		this.addQuestion(q15);
		Question q16=new Question("¿De qué manera se examina la cadena de tipo MIME?","Mayúsculas","Minúsculas","Ambas son correctas","Ambas son correctas");
		this.addQuestion(q16);
		Question q17=new Question("¿Cuál es el ciclo de vida definido de la solicitus?","Inicializado, Creado, Solicitud enviada, Respuesta siendo recibida, Solicitud completa, Respuesta recibida","Creado, Inicializado, Solicitud enviada, Respuesta siendo recibida, Solicitud completa, Respuesta recibida","Creado, Inicializado, Solicitud enviada, Respuesta siendo recibida, Respuesta recibida, Solicitud completa","Creado, Inicializado, Solicitud enviada, Respuesta siendo recibida, Respuesta recibida, Solicitud completa");
		this.addQuestion(q17);
		Question q18=new Question("Si una petición Ajax sigue la política del mismo origen y su respuesta tiene una relación con JavaScript tipo de contenido ¿Que pasa con el contenido de la responseText?","Permanece nulo","Ambas respuestas son incorrectas","Automáticamente pasa a eval","Automáticamente pasa a eval");
		this.addQuestion(q18);
		Question q19=new Question("Hablando de portatibilidad ¿Qué dos 'solicitudes' no son una apuesta segura 100% hasta el momento?","onCreate y onloading","onSuccess y onFailure","onLoaded y onInteractive","onLoaded y onInteractive");
		this.addQuestion(q19);
		Question q20=new Question("En el caso extremo en el que esté recibiendo una respuesta escrito en JavaScript, ¿Qué se proporciona?","onComplete","onSuccess","eval 'd","eval 'd");
		this.addQuestion(q20);


		//Quiz modulo 3
		Question q21=new Question("En el proceso de hacer una solicitud al servidor, a través de cuantos estados pasa XHR","A través de más de cinco (5) estados","A traves de menos de cinco (5) estados","A través de cinco (5) estados","A través de cinco (5) estados");
		this.addQuestion(q21);
		Question q22=new Question("¿Mediante qué esta representado el estado actual de XHR?","onreadystate","onreadystatechange","readyState","readyState");
		this.addQuestion(q22);
		Question q23=new Question("En la siguiente línea de código 'else if (xhr.readyState === 4)' dada en el ejemplo visto ¿A qué es igual el 4?","Es el tiempo que tardará en recibir una respuesta del servidor", "Espera la respuesta del servidor", "Respuesta del servidor se ha cargado por completo", "Respuesta del servidor se ha cargado por completo");
		this.addQuestion(q23);
		Question q24=new Question("Tomando en cuenta los diversos readyState  ¿Cuúl es el significado de UNSENT", "Antes de haber creado el objeto XMLHttpRequest, pero después de que haya llamado al método open ()", "Durante la creación del objeto XMLHttpRequest, pero antes de que haya llamado al método open ()", "Después de haber creado el objeto XMLHttpRequest, pero antes de que haya llamado al método open ()", "Después de haber creado el objeto XMLHttpRequest, pero antes de que haya llamado al método open ()");
		this.addQuestion(q24);
		Question q25=new Question("Estas son algunas de las propiedades importantes de XHR: ","UNSENT,HEADERS_RECEIVED, ABRIÓ, HECHO", "Todo es correcto","Propiedades, readyState, responseText, responseXML, estado y statusText", "Propiedades, readyState, responseText, responseXML, estado y statusText");
		this.addQuestion(q25);
		Question q26=new Question("Significado del siguiente readyState 'HEADERS_RECEIVED' :", "Durante que el método de envío se ha invocado y se han recibido las cabeceras de respuesta HTTP, la propiedad readyState del objeto XMLHttpRequest se le debe asignar un valor de 2", "Antes de que el método de envío se ha invocado y se han recibido las cabeceras de respuesta HTTP", "Después de que el método de envío se ha invocado y se han recibido las cabeceras de respuesta HTTP","Después de que el método de envío se ha invocado y se han recibido las cabeceras de respuesta HTTP");
		this.addQuestion(q26);
		Question q27=new Question("¿A que hace referencia la propiedad de XHR 'responseText' ?","Respuesta del servidor en texto con formato","Hace referencia a ambas","Respuesta del servidor en texto sin formato","Respuesta del servidor en texto sin formato");
		this.addQuestion(q27);
		Question q28=new Question("Significado de 'statusText' ","La cadena solicitada enviada para el servidor HTTP","La cadena de cancelación enviada por el servidor HTTP","La cadena de respuesta devuelto por el servidor HTTP","La cadena de respuesta devuelto por el servidor HTTP");
		this.addQuestion(q28);
		Question q29=new Question("¿Qué desencadena onreadystatechange ?","el evento readyState cambios everytime","","El evento everytime cambios readyState","El evento everytime cambios readyState");
		this.addQuestion(q29);
		Question q30=new Question("¿Cuál es el significado de la siguiente línea de código dada en el ejemplo ' si (== 200 && xhr.status <300 xhr.status) ' ","http estado entre 200 a 300 son todo un éxito","http estado entre 200 o 299 son todo un éxito","http estado entre 200 a 299 son todo un éxito","http estado entre 200 a 299 son todo un éxito");
		this.addQuestion(q30);

		//Quiz modulo 4

		Question q31=new Question("¿Qué producen las peticiones de AJAX?","Solo llamas sin posibles respuestas","Una serie de llamadas recibidas ","Una serie de diferentes eventos que se puede suscribir","Una serie de diferentes eventos que se puede suscribir");
		this.addQuestion(q31);
		Question q32=new Question("¿Cuántos tipos de eventos hay y cuáles son?","Existen tres tipos / Locales, Global e Interno","Existen dos tipos / Interno y Global","Existen dos tipos / Locales y Globales","Existen dos tipos / Locales y Globales");
		this.addQuestion(q32);
		Question q33=new Question("Este evento sólo se llama si la petición se ha realizado correctamente","éxito (Evento Local)","ajaxStart (Evento Global)","Ambos","éxito (Evento Local)");
		this.addQuestion(q33);
		Question q34=new Question("Este evento se activa cuando se inicia una petición Ajax","éxito (Evento Local)","ajaxStart (Evento Global)","Ambos","ajaxStart (Evento Global)");
		this.addQuestion(q34);
		Question q35=new Question("Este evento, que se activa antes de que se inicie una petición Ajax","Ambos","beforeSend (Evento Local)","beforeSend (Evento Global)","beforeSend (Evento Local)");
		this.addQuestion(q35);
		Question q36=new Question("Este evento sólo se llama si se ha producido un error en la solicitud","de error (Evento Local)","de error (Evento Global)","Amos","de error (Evento Local)");
		this.addQuestion(q36);
		Question q37=new Question("Este evento se llama independientemente de si la petición se ha realizado correctamente, o no.","completa (Evenyo Global)","completa (Evento Local)","Ambos","completa (Evento Local)");
		this.addQuestion(q37);
		Question q38=new Question("Este evento se comporta igual que el evento completo y se activará cada vez que finaliza una petición Ajax.","ajaxComplete (Evento Global)","ajaxComplete (Evento Local)","Ambos","ajaxComplete (Evento Global)");
		this.addQuestion(q38);
		Question q39=new Question("Este evento global se activa si no hay más solicitudes en trámite Ajax.","ajaxStop (Evento Global)","stopAjax (Evento Global)","ajaxStop (Evento Local)","ajaxStop (Evento Global)");
		this.addQuestion(q39);
		Question q40=new Question("Como desactivar una petición Ajax","$ .ajax ({ url: \"test.html\" mundial: falso , // ... });","$ .ajax ({ mundial: falso , url: \"test.html\" , // ... });","({ url: \"test.html\" mundial: falso , // ... $ .ajax  });","$ .ajax ({ url: \"test.html\" mundial: falso , // ... });");
		this.addQuestion(q40);


		//Quiz modulo 5
		Question q41=new Question("Para crear una página simple xajax y php ¿Cómo incluimos la clase?","require ('xajax/xajax.inc.php');","('xajax/xajax.inc.php')require ;","('xajax.inc.php/xajax')require ;","require ('xajax/xajax.inc.php');");
		this.addQuestion(q41);
		Question q42=new Question("Crear una instancia para el objeto de la clase xajax","new xajax();","$xajax = new xajax();","$xajax = new xajax","$xajax = new xajax();");
		this.addQuestion(q42);
		Question q43=new Question("Realizará acciones del lado del servidor y por tanto puede acceder a bases de datos, abrir ficheros o cualquier cosa que se nos ocurra.","function ($entrada){ if ($entrada=\"true\"){ \t$salida = \"Marcado\\ }else{ \t$salida = \"No marcado\\ ","function ($entrada){ if ($entrada==\"true\"){ \t$salida = \"Marcado\\ }else{ \t$salida = \"No marcado\\ }","function si_no($entrada){ if ($entrada==\"true\"){ \t$salida = \"Marcado\\ }else{ \t$salida = \"No marcado\\ }","function si_no($entrada){ if ($entrada==\"true\"){ \t$salida = \"Marcado\\ }else{ \t$salida = \"No marcado\\ }");
		this.addQuestion(q43);
		Question q44=new Question("¿Como podemos hacer llamadas a las funciones PHP en cualquier lugar del código, como respuesta a las acciones del usuario con javascript?","<\"xajax_si_no(document.formulario.si.checked)\"input type=\"checkbox\" name=\"si\" value=\"1\" onclick=>","<input type=\"checkbox\" name=\"si\" value=\"1\" onclick=\"xajax_si_no(document.formulario.si.checked)\">","\"checkbox\" name=\"si\" value=\"1\" onclick=\">","<input type=\"checkbox\" name=\"si\" value=\"1\" onclick=\"xajax_si_no(document.formulario.si.checked)\">");
		this.addQuestion(q44);
		Question q45=new Question("Solución de acentos en Ajax... instanciamos el objeto de la clase xajax","$xajax = new xajax(); $xajax->setCharEncoding('ISO-8859-1'); $xajax->decodeUTF8InputOn()","$xajax = new xajax(); $xajax->setCharEncoding('ISO-8859-1'); $xajax->decodeUTF8InputOn()","$xajax->setCharEncoding('ISO-8859-1'); $xajax->decodeUTF8InputOn()"," $xajax->setCharEncoding('ISO-8859-1'); $xajax->decodeUTF8InputOn() $xajax = new xajax();");
		this.addQuestion(q45);
		Question q46=new Question("¿Cómo indicamos el juego de caracteres para ésta acentuación?","('ISO-8859-1')$respuesta = new xajaxResponse;","respuesta =('ISO-8859-1') new xajaxResponse","$respuesta = new xajaxResponse('ISO-8859-1');","$respuesta = new xajaxResponse('ISO-8859-1');");
		this.addQuestion(q46);
		Question q47=new Question("Método que sirve para incluir un link con una declaración de estilos en el HEAD de la página","includeCSS","include_CSS","CSS.include","includeCSS");
		this.addQuestion(q47);
		Question q48=new Question("¿Para que sirve el método waitForCSS()","Para obligar al objeto response a esperar que finalice la carga de un CSS antes de continuar realizando acciones","","","Para obligar al objeto response a esperar que finalice la carga de un CSS antes de continuar realizando acciones");
		this.addQuestion(q48);
		Question q49=new Question("¿Qué te permiten las funciones de Xajax?","Incluir o quitar declaraciones de estilos","Solo incluir declaraciones de estilos","Solo quitar declaraciones de estilos","Incluir o quitar declaraciones de estilos");
		this.addQuestion(q49);
		Question q50=new Question("¿Cómo abrimos sesión Xajax?","session_start();","start()","start_session()","session_start();");
		this.addQuestion(q50);


		//Quiz de Certificación
		Question q51=new Question("¿Cuál es la característica fundamental de AJAX?","","Permitir actualizar parte de una página con información que se encuentra en el servidor sin tener que refrescar completamente la página","","Permitir actualizar parte de una página con información que se encuentra en el servidor sin tener que refrescar completamente la página");
		this.addQuestion(q51);
		Question q52=new Question("¿Qué significa AJAX?","JavaScript / XML","Asynchronous Java And XML","Asynchronous JavaScript And XML","Asynchronous JavaScript And XML");
		this.addQuestion(q52);
		Question q53=new Question("¿Qué es AJAX?","Es un lenguaje de programación","Es un software","Es una técnica de desarrollo web","Es una técnica de desarrollo web");
		this.addQuestion(q53);
		Question q54=new Question("¿Para qué sirve AJAX?","Para modificar códigos","Para diseñar páginas web","Para crear aplicaciones interactivas o RIA","Para crear aplicaciones interactivas o RIA");
		this.addQuestion(q54);
		Question q55=new Question("¿En dónde se ejecutan las aplicaciones creadas?","En la misma aplicación","En otra aplicación","En el navegador de los usuarios","En el navegador de los usuarios");
		this.addQuestion(q55);
		Question q56=new Question("¿Qué tipo de tecnología es AJAX?","Síncrona","Utiliza Ambas","Asíncrona","Asíncrona");
		this.addQuestion(q56);
		Question q57=new Question("¿En qué año y por quien fue creado el término AJAX?","2000 por Jesse James Garrett","1995 por Jhon James","2005 por Jesse James Garrett","2005 por Jesse James Garrett");
		this.addQuestion(q57);
		Question q58=new Question("¿El acceso de datos se realiza mediante...?","XMLHttpSolicitud","XMLHttp","XMLHttpRequest","XMLHttpRequest");
		this.addQuestion(q58);
		Question q59=new Question("La técnica AJAX es valida ¿Para?","Plataforma Única","No más de 2 plataformas","Múltiples Plataformas","Múltiples Plataformas");
		this.addQuestion(q59);
		Question q60=new Question("La técnica AJAX es basada y utilizable ¿En?","Sistema Operativo Único / Estándares Cerrados", "No más de 2 Sistemas Operativos / Estándares Cerrados y Abiertos", "Muchos Sistemas Operativos / Estándares Abiertos", "Muchos Sistemas Operativos / Estándares Abiertos");
		this.addQuestion(q60);


		Question q61=new Question("Crear objetos ActiveX mediante: ","if (window.ActiveXObject)","if (window.XMLHttpRequest)","thttpRequest = new ActiveXObject(\"MSXML2.XMLHTTP\");","thttpRequest = new ActiveXObject(\"MSXML2.XMLHTTP\");");
		this.addQuestion(q61);
		Question q62=new Question("¿Para que sirve XMLHttpRequest","Para solicitar datos", "Para recibir archivos", "Para realizar llamadas mediante HTTP", "Para realizar llamadas mediante HTTP");
		this.addQuestion(q62);
		Question q63=new Question("¿Cuál es el orden de activación de la llamada?","onCreate, onloading, onLoaded, onInteractive, onUninitialized, onSuccess o onFailure, onComplete", "onCreate, onloading, onLoaded, onInteractive, onUninitialized, onComplete","onCreate, onUninitialized, onloading, onLoaded, onInteractive, onSuccess o onFailure, onComplete", "onCreate, onUninitialized, onloading, onLoaded, onInteractive, onSuccess o onFailure, onComplete");
		this.addQuestion(q63);
		Question q64=new Question("¿Cuál es el ciclo de vida definido de la solicitus?","Inicializado, Creado, Solicitud enviada, Respuesta siendo recibida, Solicitud completa, Respuesta recibida","Creado, Inicializado, Solicitud enviada, Respuesta siendo recibida, Solicitud completa, Respuesta recibida","Creado, Inicializado, Solicitud enviada, Respuesta siendo recibida, Respuesta recibida, Solicitud completa","Creado, Inicializado, Solicitud enviada, Respuesta siendo recibida, Respuesta recibida, Solicitud completa");
		this.addQuestion(q64);
		Question q65=new Question("En la siguiente línea de código 'else if (xhr.readyState === 4)' dada en el ejemplo visto ¿A qué es igual el 4?","Es el tiempo que tardará en recibir una respuesta del servidor", "Espera la respuesta del servidor", "Respuesta del servidor se ha cargado por completo", "Respuesta del servidor se ha cargado por completo");
		this.addQuestion(q65);
		Question q66=new Question("Significado del siguiente readyState 'HEADERS_RECEIVED' :", "Durante que el método de envío se ha invocado y se han recibido las cabeceras de respuesta HTTP, la propiedad readyState del objeto XMLHttpRequest se le debe asignar un valor de 2", "Antes de que el método de envío se ha invocado y se han recibido las cabeceras de respuesta HTTP", "Después de que el método de envío se ha invocado y se han recibido las cabeceras de respuesta HTTP","Después de que el método de envío se ha invocado y se han recibido las cabeceras de respuesta HTTP");
		this.addQuestion(q66);
		Question q67=new Question("¿Cuál es el significado de la siguiente línea de código dada en el ejemplo ' si (== 200 && xhr.status <300 xhr.status) ' ","http estado entre 200 a 300 son todo un éxito","http estado entre 200 o 299 son todo un éxito","http estado entre 200 a 299 son todo un éxito","http estado entre 200 a 299 son todo un éxito");
		this.addQuestion(q67);
		Question q68=new Question("Como desactivar una petición Ajax","$ .ajax ({ url: \"test.html\" mundial: falso , // ... });","$ .ajax ({ mundial: falso , url: \"test.html\" , // ... });","({ url: \"test.html\" mundial: falso , // ... $ .ajax  });","$ .ajax ({ url: \"test.html\" mundial: falso , // ... });");
		this.addQuestion(q68);
		Question q69=new Question("¿Cómo indicamos el juego de caracteres para ésta acentuación?","('ISO-8859-1')$respuesta = new xajaxResponse;","respuesta =('ISO-8859-1') new xajaxResponse","$respuesta = new xajaxResponse('ISO-8859-1');","$respuesta = new xajaxResponse('ISO-8859-1');");
		this.addQuestion(q69);
		Question q70=new Question("¿Cómo abrimos sesión Xajax?","session_start();","start()","start_session()","session_start();");
		this.addQuestion(q70);

	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Eliminar la tabla anterior si existe
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Crear tablas otra vez
		onCreate(db);
	}
	// Agregamos nueva preguna
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION()); 
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);		
	}
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Selecciona todas las consultas
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// bucle a través de todas las filas y añadiendo a la lista
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// volver a la lista
		return quesList;
	}
	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
}
