package com.example.a2p2023pm01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityFoto extends AppCompatActivity {

    static final int peticion_captura_imagen=101;
    static final int peticion_acceso_camara=102;

    ImageView Objetoimagen;
    Button btntomarfoto;
    String pathfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        Objetoimagen = (ImageView) findViewById(R.id.imageView);
        btntomarfoto = (Button) findViewById(R.id.btnfoto);
        
        btntomarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permisos();
                
            }
        });
    }

    private void permisos()
    {
      if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
      {
          ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},peticion_acceso_camara);
      }
      else
      {
         TomarFoto();
      }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == peticion_acceso_camara)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                TomarFoto();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Se necesita el permiso para acceder a la camara", Toast.LENGTH_LONG).show();
        }
    }

    private void TomarFoto() {
    }
}