package com.example.a2p2023pm01.Configuracion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2p2023pm01.ActivityCrear;
import com.example.a2p2023pm01.ActivityList;
import com.example.a2p2023pm01.Models.ActivityCombo;
import com.example.a2p2023pm01.R;

public class ActivityPrinc extends AppCompatActivity {

    Button btncreate, btnlists, btncombo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princ);

        btncreate = (Button) findViewById(R.id.btncreate);
        btnlists = (Button) findViewById(R.id.btnlistpe);
        btncombo = (Button) findViewById(R.id.btncombo);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityCrear.class);
                startActivity(intent);
            }
        });

        btnlists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(intent);
            }
        });

        btnlists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityCombo.class);
                startActivity(intent);
            }
        });

    }
}