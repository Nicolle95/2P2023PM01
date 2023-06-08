package com.example.a2p2023pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a2p2023pm01.Configuracion.SQLiteConexion;
import com.example.a2p2023pm01.Configuracion.Transaccion;
import com.example.a2p2023pm01.Models.Personas;

import java.util.ArrayList;
import java.util.List;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listpersonas;
    ArrayList<Personas> lista;
    ArrayList<String> ArregloPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion( this, Transaccion.NameDatabase,null, 1);
        listpersonas = (ListView) findViewById(R.id.listpersonas);

        ObtenerTabla();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloPersonas);
        listpersonas.setAdapter(adp);

        listpersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//obtener el elemento seleccionado en la lista
                String selectedItem = (String) adapterView.getItemAtPosition(i);
// realizar alguna accion con el elemento seleccionado
                Toast.makeText(getApplicationContext(),"Seleccionaste: " + selectedItem, Toast.LENGTH_SHORT).show();
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
        ArregloPersonas = new ArrayList<String>();

        for (int i=0; i<lista.size(); i++)
        {
            ArregloPersonas.add(lista.get(i).getId() + " - "
            +lista.get(i).getNombres() + " - "
                    +lista.get(i).getApellidos());

        }
    }
}