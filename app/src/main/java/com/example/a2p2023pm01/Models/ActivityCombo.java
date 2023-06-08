package com.example.a2p2023pm01.Models;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.a2p2023pm01.Configuracion.SQLiteConexion;
import com.example.a2p2023pm01.Configuracion.Transaccion;
import com.example.a2p2023pm01.R;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {

    SQLiteConexion conexion;
    Spinner combopersonas;
    EditText nombres, apellidos, correo;

    ArrayList<String> listapersonas;
    ArrayList<Personas> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLiteConexion(this, Transaccion.NameDatabase, null, 1);
        combopersonas = (Spinner) findViewById(R.id.spinner);
        nombres = (EditText) findViewById(R.id.cbnombre);
        apellidos = (EditText) findViewById(R.id.cbapellido);
        correo = (EditText) findViewById(R.id.cbcorreo);

        ObtenerTabla();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter( this, android.R.layout.simple_spinner_item, listapersonas);
        combopersonas.setAdapter(adp);

        combopersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try
                {
                    nombres.setText(lista.get(i).getNombres());
                    apellidos.setText(lista.get(i).getApellidos());
                    correo.setText(lista.get(i).getCorreo());
                }
                catch (Exception ex)
                {
                    ex.toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void ObtenerTabla()
    {
        SQLiteDatabase db= conexion.getReadableDatabase();
        Personas person = null;
        lista = new ArrayList<Personas>();

        //Cursor de Base de Datos
        Cursor cursor = db.rawQuery(Transaccion.SelectTablePersona, null);

        // recorremos el cursor
        while (cursor.moveToNext())
        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            lista.add(person);

        }
        cursor.close();

        fillList();
    }

    private void fillList()
    {
        listapersonas = new ArrayList<String>();

        for (int i=0; i<lista.size(); i++)
        {
            listapersonas.add(lista.get(i).getId() + " - "
                    +lista.get(i).getNombres() + " - "
                    +lista.get(i).getApellidos());

        }
    }

}