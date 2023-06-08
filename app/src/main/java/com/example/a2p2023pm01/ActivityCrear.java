package com.example.a2p2023pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2p2023pm01.Configuracion.SQLiteConexion;
import com.example.a2p2023pm01.Configuracion.Transaccion;

public class ActivityCrear extends AppCompatActivity {

    EditText nombres, apellidos, edad, correo;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        nombres = findViewById(R.id.nombres);
        apellidos = findViewById(R.id.apellidos);
        edad = findViewById(R.id.edad);
        correo = findViewById(R.id.correo);

        btnagregar = (Button) findViewById(R.id.btnmostrar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddPerson();
            }
        });
    }

    private void AddPerson()
    {
        SQLiteConexion conexion = new SQLiteConexion( this, Transaccion.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transaccion.nombres, nombres.getText().toString());
        valores.put(Transaccion.apellidos, apellidos.getText().toString());
        valores.put(Transaccion.edad, edad.getText().toString());
        valores.put(Transaccion.correo, correo.getText().toString());

        Long result = db.insert(Transaccion.tablaPersonas, Transaccion.id, valores);
        Toast.makeText(getApplicationContext(), "Registro ingresado : " + result.toString(),Toast.LENGTH_LONG ).show();

        db.close();

        CleanScreen();
    }

    private void CleanScreen()
    {
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");

    }

}