package com.joseaguilar.firebase_database_realtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView mensajeTextView;
    private EditText mensajeEditText;
    private Button modificar;
    //Nota se la declara como variable global para que pueda ser utilizada en cualquier metodo de esta clase

    //PASO 1: Obtener referencia a la raiz del arbol de la base de datos
    DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    //PASO 2: Obtener referencia a la rama del arbol
    DatabaseReference mensajeRef = referencia.child("mensaje");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensajeTextView = (TextView) findViewById(R.id.mensajeTextView);
        mensajeEditText = (EditText) findViewById(R.id.mensajeEditText);
    }

    //NOTA, al haber creado en el mismo boton el evento onClick, no es necesario implementar el setonclickListener
    public void modificar(View view) {
    //PASO 3:  En este ejemplo haremos una escritura modificando el contenido de la rama
        //recogemos el valor que hayamos puesto en el edittext
        String mensaje = mensajeEditText.getText().toString();
        //establecemos que la variable "DatabaseReference" obtenga el dato del edittext
        mensajeRef.setValue(mensaje);
        //Limpiamos el edittext
        mensajeEditText.setText("");
    }

    //PASO 4: crearemos el evento addValueEventListener dentro del metodo onStart(), para poder leer desde la base de datos
    @Override
    protected void onStart() {
        super.onStart();
        mensajeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            //obtenemos el valor del mensaje que esta en la base de datos de firebase
                String value = dataSnapshot.getValue(String.class);
                mensajeTextView.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
