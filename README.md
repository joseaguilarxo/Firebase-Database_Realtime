# Firebase-Database_Realtime
Integracion de Firebase a nuestros proyectos Android consumiendo el servicio de Base de Datos en tiempo real, en este proyecto se programo un ejemplo basico de como utilizar y modificar un dato de la db.

INTEGRACION DE FIREBASE A NUESTROS PROYECTOS

Paso 1: entrar a la pagina de Firebase
console.firebase.google.com

Paso 2: Creamos un nuevo proyecto y realizamos la configuracion
	-Agregamos el nombre del paquete : com.tuapp.activity
	-Agregamos el codigo de SHA-1: *opcional*

Paso 3: Se descargara el archivo .json
	google-services.json

Paso 4: Configuramos el proyecto android
	- En build.gradle del proyecto agregamos:
		classpath 'com.google.gms:google-services:3.0.0'
	- En build.gradle de la aplicacion
		en dependencias : compile 'com.google.firebase:firebase-core:9.0.0'
		afuera de todo : apply plugin: 'com.google.gms.google-services'

Paso 5: Ya dentro de android studio, cambiamos de vista de proyecto Android a Project y copiamos en la carpeta " APP " el archivo .json que se descargo en el paso 3.

----------------------------------------------****-----------------------------------------------

Nota 1: Para poder trabajar con esto, verificar que tengamos instalado en SDK tools
Google Play Services
Google Repository
Android support repository

Nota 2: las dependencias de firebase varian dependiendo al servicio que se quiera consumir, aca la lista:

Servicio					Dependencia
Analytics					com.google.firebase:firebase-core:9.0.0
Realtime Database				com.google.firebase:firebase-database:9.0.0 //TRABAJAREMOS CON ESTA
Storage						com.google.firebase:firebase-storage:9.0.0
Crash Reporting					com.google.firebase:firebase-crash:9.0.0
Authentication					com.google.firebase:firebase-auth:9.0.0
Cloud Messaging/Notificacion			com.google.firebase:firebase-messaging:9.0.0
Remote Config					com.google.firebase:firebase-config:9.0.0
Invites/Dynamic Links				com.google.firebase:firebase-invites:9.0.0
AdMob						com.google.firebase:firebase-ads:9.0.0
App Indexing					com.google.android.gms:play-services-appindexing:9.0.0

---------------------------------------------****---------------------------------------------------

-------> DATABASE REALTIME <------------

Conceptos: 
	- Al ser una base de datos en tiempo real no necesitamos realizar peticiones de consulta a nuestro servidor, es decir que en nuestra app tenga un boton de actualizar o un pool to refresh de las listas.

Caracteristicas:
	- No es necesario implantar seguridad tercera ya que firebase se encarga de esto
	- Posibilidad de trabajar OffLine (sin internet los datos se almacenan en cache) y una vez que tengamos conexion se sincroniza directamente.
	- Permite tener la posibilidad de tener 1 sola DB para multiples plataformas
	- En firebase todos los datos se almacenan como objetos JSON
	- Su estructura se asemeja a un arbol
	- Los tipos de datos que se pueden almacenar es texto, numeros o booleanos (true - false)

Estructura:

	{
	"usuarios": { //tabla
	   "jgarcia": 	{ // codigo
	       "nombre": "Jessica Garcia", //atributo 1
	       "contactos": { "achavez": true }, //atributo 2
			}
		    }
	}


Programacion:
	Paso 1: Obtener referencia a la raiz del arbol de la base de datos
	Paso 2: Obtener referencia a la rama del arbol
	Paso 3: En este ejemplo haremos una escritura modificando el contenido de la rama
	Paso 4: crearemos el evento addValueEventListener dentro del metodo onStart(), para poder leer desde 	la base de datos

LA DOCUMENTACION PASO A PASO ESTA EN EL PROYECTO


